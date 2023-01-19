package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.Pet;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface PetService extends CrudService<Pet, Long> {

  void deleteById(Long id);
}
