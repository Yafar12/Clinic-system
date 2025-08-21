package com.clinic.system.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clinic.system.dto.mapper.helpers.DoctorRefMapper;
import com.clinic.system.dto.nonWorkingDay.NonWorkingCreateRequest;
import com.clinic.system.dto.nonWorkingDay.NonWorkingResponse;
import com.clinic.system.dto.nonWorkingDay.NonWorkingUpdateRequest;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.model.NonWorkingDay;

import java.time.LocalTime;

@Component
public class NonWorkingDayMapper {

        @Autowired
        private DoctorRefMapper doctorRef;

        public NonWorkingResponse toResponse(NonWorkingDay entity) {
                if (entity == null)
                        return null;
                return new NonWorkingResponse(
                                entity.getId(),
                                doctorRef.toDni(entity.getDoctor()),
                                entity.getDate(),
                                entity.getStartTime(),
                                entity.getEndTime(),
                                entity.getReason());
        }

        public NonWorkingDay toEntity(NonWorkingCreateRequest dto) {
                if (dto == null)
                        return null;

                validateRange(dto.startTime(), dto.endTime());

                NonWorkingDay nwd = new NonWorkingDay();
                nwd.setDoctor(doctorRef.fromDni(dto.dni()));
                nwd.setDate(dto.date());
                nwd.setStartTime(dto.startTime());
                nwd.setEndTime(dto.endTime());
                nwd.setReason(hasText(dto.reason()) ? dto.reason() : null);
                return nwd;
        }

        public void updateReason(NonWorkingDay target, NonWorkingUpdateRequest dto) {
                if (target == null || dto == null)
                        return;
                if (dto.reason() != null) {
                        target.setReason(hasText(dto.reason()) ? dto.reason() : null);
                }
        }

        private static void validateRange(LocalTime start, LocalTime end) {
                if (start != null && end != null && start.isAfter(end)) {
                        throw AppException.badRequest("startTime no puede ser posterior a endTime");
                }
        }

        private static boolean hasText(String s) {
                return s != null && !s.isEmpty();
        }
}
