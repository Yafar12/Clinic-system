package com.project.project.infrastructure.input.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestGetByIdResponse {

    UUID id;
    Integer dni;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
}
