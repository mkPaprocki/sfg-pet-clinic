package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.Speciality;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 05.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface SpecialtyService extends CrudService<Speciality, Long> {

  void deleteById(Long id);
}
