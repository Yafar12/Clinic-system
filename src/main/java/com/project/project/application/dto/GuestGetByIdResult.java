package com.project.project.application.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class GuestGetByIdResult {

    UUID id;
    Integer dni;
    String firstName;
    String lastName;
    byte[] photo;
}
