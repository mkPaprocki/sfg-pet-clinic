package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.Vet;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface VetService extends CrudService<Vet, Long> {

  void deleteById(Long id);
}
