package com.github.mkpaprocki.sfgpetclinic.model;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 13.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
