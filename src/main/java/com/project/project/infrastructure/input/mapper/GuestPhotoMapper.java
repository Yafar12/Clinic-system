package com.project.project.infrastructure.input.mapper;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class GuestPhotoMapper {

    public byte[] map(String base64) {

        if (base64 == null || base64.isBlank()) {
            return null;
        }

        try {
            // Limpia header data:image/...;base64,
            if (base64.contains(",")) {
                base64 = base64.split(",")[1];
            }

            // Limpia saltos de línea y espacios
            base64 = base64.replaceAll("\\s", "");

            return Base64.getDecoder().decode(base64);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "La imagen no es Base64 válido",
                    e);
        }
    }
}
