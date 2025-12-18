package com.project.project.application.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class GuestFindAllResult {

    private UUID id;
    private Integer dni;
    private String firstName;
    private String lastName;

}
