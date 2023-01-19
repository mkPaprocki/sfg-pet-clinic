package com.github.mkpaprocki.sfgpetclinic.repositories;

import com.github.mkpaprocki.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
