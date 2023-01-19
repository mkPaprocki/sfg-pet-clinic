package com.github.mkpaprocki.sfgpetclinic.repositories;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

  Owner findByLastName(String lastName);

  void deleteById(Long id);

}
