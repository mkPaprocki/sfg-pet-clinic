package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.PetType;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 05.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface PetTypeService extends CrudService<PetType, Long> {

  void deleteById(Long id);
}
