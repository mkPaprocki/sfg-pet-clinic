package com.github.mkpaprocki.sfgpetclinic.repositories;


import com.github.mkpaprocki.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
