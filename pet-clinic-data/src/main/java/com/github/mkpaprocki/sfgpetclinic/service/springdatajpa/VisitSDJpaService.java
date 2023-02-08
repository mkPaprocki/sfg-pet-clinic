package com.github.mkpaprocki.sfgpetclinic.service.springdatajpa;

import com.github.mkpaprocki.sfgpetclinic.model.Visit;
import com.github.mkpaprocki.sfgpetclinic.repositories.VisitRepository;
import com.github.mkpaprocki.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

  private final VisitRepository visitRepository;

  public VisitSDJpaService(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long aLong) {
    return visitRepository.findById(aLong).orElseGet(null);
  }

  @Override
  public Visit save(Visit object) {
    return visitRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }
}
