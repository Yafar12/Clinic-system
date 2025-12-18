package com.project.project.domain.model;

import java.util.UUID;

public class Guest {
    private UUID id;
    private Integer dni;
    private String firstName;
    private String lastName;
    private Byte[] photo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public Integer getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Byte[] getPhoto() {
        return photo;
    }
}
