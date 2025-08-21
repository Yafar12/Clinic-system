package com.clinic.system.dto.mapper;

import com.clinic.system.dto.mapper.helpers.DoctorRefMapper;
import com.clinic.system.dto.nonWorkingDay.NonWorkingCreateRequest;
import com.clinic.system.dto.nonWorkingDay.NonWorkingResponse;
import com.clinic.system.dto.nonWorkingDay.NonWorkingUpdateRequest;
import com.clinic.system.model.NonWorkingDay;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-21T08:02:19-0300",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class NonWorkingDayMapperImpl implements NonWorkingDayMapper {

    @Autowired
    private DoctorRefMapper doctorRefMapper;

    @Override
    public NonWorkingResponse toResponse(NonWorkingDay entity) {
        if ( entity == null ) {
            return null;
        }

        Long dni = null;
        Integer id = null;
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;
        String reason = null;

        dni = doctorRefMapper.toDni( entity.getDoctor() );
        id = entity.getId();
        date = entity.getDate();
        startTime = entity.getStartTime();
        endTime = entity.getEndTime();
        reason = entity.getReason();

        NonWorkingResponse nonWorkingResponse = new NonWorkingResponse( id, dni, date, startTime, endTime, reason );

        return nonWorkingResponse;
    }

    @Override
    public NonWorkingDay toEntity(NonWorkingCreateRequest dto) {
        if ( dto == null ) {
            return null;
        }

        NonWorkingDay nonWorkingDay = new NonWorkingDay();

        nonWorkingDay.setDoctor( doctorRefMapper.fromDni( dto.dni() ) );
        nonWorkingDay.setDate( dto.date() );
        nonWorkingDay.setEndTime( dto.endTime() );
        nonWorkingDay.setReason( dto.reason() );
        nonWorkingDay.setStartTime( dto.startTime() );

        return nonWorkingDay;
    }

    @Override
    public void updateReason(NonWorkingDay entity, NonWorkingUpdateRequest dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.reason() != null ) {
            entity.setReason( dto.reason() );
        }
    }
}
