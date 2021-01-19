package com.github.mkpaprocki.sfgpetclinic.model.service;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
