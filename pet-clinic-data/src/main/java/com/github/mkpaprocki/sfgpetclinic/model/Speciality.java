package com.github.mkpaprocki.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 04.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

  @Column(name = "description")
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
