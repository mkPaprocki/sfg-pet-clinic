package com.github.mkpaprocki.sfgpetclinic.repositories;

import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
