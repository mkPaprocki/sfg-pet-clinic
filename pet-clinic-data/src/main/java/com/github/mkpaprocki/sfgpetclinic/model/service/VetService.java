package com.github.mkpaprocki.sfgpetclinic.model.service;

import com.github.mkpaprocki.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
