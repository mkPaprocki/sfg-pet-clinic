package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.PetType;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 05.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface PetTypeService extends CrudService<PetType, Long> {

  Set<PetType> findAll();

  PetType findById(Long aLong);

  void deleteById(Long id);

  PetType save(PetType object);

  void delete(PetType object);
}
