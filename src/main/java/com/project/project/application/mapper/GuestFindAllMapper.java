package com.project.project.application.mapper;

import org.mapstruct.Mapper;
import com.project.project.application.dto.GuestFindAllResult;
import com.project.project.domain.model.Guest;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GuestFindAllMapper {
    List<GuestFindAllResult> toResultList(List<Guest> guests);
}