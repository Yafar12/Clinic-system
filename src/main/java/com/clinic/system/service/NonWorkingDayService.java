package com.clinic.system.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinic.system.dto.nonWorkingDay.NonWorkingCreateRequest;
import com.clinic.system.dto.nonWorkingDay.NonWorkingResponse;
import com.clinic.system.dto.nonWorkingDay.NonWorkingUpdateRequest;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.dto.mapper.NonWorkingDayMapper;
import com.clinic.system.model.NonWorkingDay;
import com.clinic.system.repository.INonWorkingDayRepository;

@Service
@Transactional
public class NonWorkingDayService implements
    IModelService<NonWorkingResponse, Integer, NonWorkingCreateRequest, NonWorkingUpdateRequest> {

  @Autowired
  private INonWorkingDayRepository repo;
  @Autowired
  private NonWorkingDayMapper mapper;


  @Override
  public List<NonWorkingResponse> findAll() {
    return repo.findAll().stream().map(mapper::toResponse).toList();
  }

  @Override
  public NonWorkingResponse findById(Integer id) {
    NonWorkingDay e = repo.findById(id)
        .orElseThrow(() -> AppException.notFound("Bloque no encontrado"));
    return mapper.toResponse(e);
  }

  @Override
  public NonWorkingResponse create(NonWorkingCreateRequest req) {
    var w = validateAndNormalize(req.startTime(), req.endTime());

    if (w.fullDay() && !repo.findByDoctor_DniAndDate(req.dni(), req.date()).isEmpty()) {
      throw AppException.conflict("Ya existen bloqueos ese día; no se puede crear día completo.");
    }
    if (!w.fullDay()
        && repo.existsByDoctor_DniAndDateAndStartTimeIsNullAndEndTimeIsNull(req.dni(), req.date())) {
      throw AppException.conflict("Existe un bloqueo de día completo en esa fecha.");
    }

    var sameDay = repo.findByDoctor_DniAndDate(req.dni(), req.date());
    for (NonWorkingDay b : sameDay) {
      var e = normalize(b.getStartTime(), b.getEndTime());
      if (overlaps(w, e)) throw AppException.conflict("Se solapa con otro bloqueo existente.");
    }

    NonWorkingDay entity = mapper.toEntity(req);
    return mapper.toResponse(repo.save(entity));
  }

  @Transactional
  public NonWorkingResponse update(Integer id, NonWorkingUpdateRequest req) {
    NonWorkingDay entity = repo.findById(id)
        .orElseThrow(() -> AppException.notFound("Bloque no encontrado"));

    var w = validateAndNormalize(req.startTime(), req.endTime());

    var sameDay = repo.findByDoctor_DniAndDate(entity.getDoctor().getDni(), entity.getDate());
    for (NonWorkingDay b : sameDay) {
      if (b.getId().equals(entity.getId())) continue;
      var e = normalize(b.getStartTime(), b.getEndTime());
      if (w.fullDay() || e.fullDay() || overlaps(w, e)) {
        throw AppException.conflict("El nuevo horario se solapa con otro bloqueo existente.");
      }
    }

    mapper.updateReason(entity, req);
    return mapper.toResponse(repo.save(entity));
  }

  @Override
  public void delete(Integer id) {
    NonWorkingDay entity = repo.findById(id)
        .orElseThrow(() -> AppException.notFound("Bloque no encontrado"));
    repo.delete(entity);
  }


  public List<NonWorkingResponse> listByDoctorAndDate(Long dni, LocalDate date) {
    return repo.findByDoctor_DniAndDate(dni, date).stream().map(mapper::toResponse).toList();
  }

  public List<NonWorkingResponse> listByDoctorAndRange(Long dni, LocalDate start, LocalDate end) {
    return repo.findByDoctor_DniAndDateBetween(dni, start, end).stream().map(mapper::toResponse).toList();
  }

  private record TimeWindow(LocalTime start, LocalTime end, boolean fullDay) { }

  private TimeWindow validateAndNormalize(LocalTime start, LocalTime end) {
    if (start == null && end == null) {
      return new TimeWindow(LocalTime.MIN, LocalTime.MAX, true);
    }
    if (start == null || end == null) {
      throw AppException.badRequest("Si especifica horarios, startTime y endTime son obligatorios.");
    }
    if (!start.isBefore(end)) {
      throw AppException.badRequest("startTime debe ser menor a endTime.");
    }
    return new TimeWindow(start, end, false);
  }

  private TimeWindow normalize(LocalTime start, LocalTime end) {
    if (start == null && end == null) return new TimeWindow(LocalTime.MIN, LocalTime.MAX, true);
    return new TimeWindow(start, end, false);
  }

  private boolean overlaps(TimeWindow a, TimeWindow b) {
    return a.start().isBefore(b.end()) && a.end().isAfter(b.start());
  }
}
