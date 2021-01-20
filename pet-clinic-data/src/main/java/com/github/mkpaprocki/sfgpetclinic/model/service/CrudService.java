package com.github.mkpaprocki.sfgpetclinic.model.service;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 20.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T oject);

    void delete(T object);
}
