package com.project.project.infrastructure.input.mapper;

import java.util.Base64;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;
import com.project.project.infrastructure.input.dto.GuestPostAdapterRequest;
import com.project.project.infrastructure.input.dto.GuestPostAdapterResponse;

@Mapper(componentModel = "spring")
public interface GuestPostAdapterMapper {

    @Mapping(source = "photo", target = "photo", qualifiedByName = "stringToByteArray")
    @Mapping(target = "id", ignore = true)
    GuestCreatorCommand toCommand(GuestPostAdapterRequest request);

    GuestPostAdapterResponse toResponse(GuestCreatorResult result);

    @Named("stringToByteArray")
    default byte[] stringToByteArray(String photo) {
        if (photo == null || photo.isBlank()) {
            return null;
        }
        return Base64.getDecoder().decode(photo);
    }
}
