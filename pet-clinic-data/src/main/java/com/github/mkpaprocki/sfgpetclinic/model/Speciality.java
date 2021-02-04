package com.github.mkpaprocki.sfgpetclinic.model;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 04.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
