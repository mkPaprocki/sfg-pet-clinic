package com.github.mkpaprocki.sfgpetclinic.service.springdatajpa;

import com.github.mkpaprocki.sfgpetclinic.model.PetType;
import com.github.mkpaprocki.sfgpetclinic.repositories.PetTypeRepository;
import com.github.mkpaprocki.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepository.deleteById(id);
  }
}
