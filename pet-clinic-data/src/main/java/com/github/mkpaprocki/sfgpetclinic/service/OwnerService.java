package com.github.mkpaprocki.sfgpetclinic.service;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;

import java.util.List;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 19.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);

  void deleteById(Long Id);
}
