package com.github.mkpaprocki.sfgpetclinic.model;

import lombok.*;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

  @Column(name = "description")
  private String description;

}
