package com.github.mkpaprocki.sfgpetclinic.model.service;

import com.github.mkpaprocki.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
