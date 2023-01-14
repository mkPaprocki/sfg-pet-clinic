package com.github.mkpaprocki.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 13.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
