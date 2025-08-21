package com.clinic.system.dto.mapper;

import org.mapstruct.*;

import com.clinic.system.dto.mapper.helpers.DoctorRefMapper;
import com.clinic.system.dto.nonWorkingDay.NonWorkingCreateRequest;
import com.clinic.system.dto.nonWorkingDay.NonWorkingResponse;
import com.clinic.system.dto.nonWorkingDay.NonWorkingUpdateRequest;
import com.clinic.system.model.NonWorkingDay;

@Mapper(
    componentModel = "spring",
    uses = DoctorRefMapper.class
)
public interface NonWorkingDayMapper {

    @Mapping(source = "doctor", target = "dni")
    NonWorkingResponse toResponse(NonWorkingDay entity);

    @Mapping(source = "dni", target = "doctor")
    @Mapping(target = "id", ignore = true)
    NonWorkingDay toEntity(NonWorkingCreateRequest dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "startTime", ignore = true)
    @Mapping(target = "endTime", ignore = true)
    void updateReason(@MappingTarget NonWorkingDay entity, NonWorkingUpdateRequest dto);
}
