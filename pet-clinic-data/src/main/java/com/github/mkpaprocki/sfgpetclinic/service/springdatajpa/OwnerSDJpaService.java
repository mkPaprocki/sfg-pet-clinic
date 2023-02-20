package com.github.mkpaprocki.sfgpetclinic.service.springdatajpa;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.repositories.OwnerRepository;
import com.github.mkpaprocki.sfgpetclinic.repositories.PetRepository;
import com.github.mkpaprocki.sfgpetclinic.repositories.PetTypeRepository;
import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long aLong) {
    return ownerRepository.findById(aLong).orElse(null);
  }

  @Override
  public Owner save(Owner object) {
    return ownerRepository.save(object);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public List<Owner> findAllByLastNameLike(String lastName) {
    return ownerRepository.findAllByLastNameLike(lastName);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }
}
