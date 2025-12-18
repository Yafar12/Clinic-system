package com.project.project.application.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class GuestCreatorCommand {
    private UUID id;
    private Integer dni;
    private String firstName;
    private String lastName;
    private byte[] photo;
}
