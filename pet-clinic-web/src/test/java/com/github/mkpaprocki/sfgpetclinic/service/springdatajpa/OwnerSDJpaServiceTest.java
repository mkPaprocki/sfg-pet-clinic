package com.github.mkpaprocki.sfgpetclinic.service.springdatajpa;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.repositories.OwnerRepository;
import com.github.mkpaprocki.sfgpetclinic.repositories.PetRepository;
import com.github.mkpaprocki.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  public static final String LAST_NAME = "Smith";

  Owner returnOwner;

  @Mock
  OwnerRepository ownerRepository;
  @Mock
  PetRepository petRepository;
  @Mock
  PetTypeRepository petTypeRepository;

  @InjectMocks
  OwnerSDJpaService ownerSDJpaService;

  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
  }

  @Test
  void findAll() {
    Set<Owner> returnOwnerSet = new HashSet<>();
    returnOwnerSet.add(Owner.builder().id(2L).build());
    returnOwnerSet.add(Owner.builder().id(3L).build());
    when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

    Set<Owner> owners = ownerSDJpaService.findAll();

    assertNotNull(owners);
    assertEquals(2, owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(1L)).thenReturn(Optional.of(returnOwner));
    Owner owner = ownerSDJpaService.findById(1L);
    assertNotNull(owner);
    assertEquals(1L, owner.getId());
  }

  @Test
  void findByIdNotFound() {
    when(ownerRepository.findById(1L)).thenReturn(Optional.empty());
    Owner owner = ownerSDJpaService.findById(1L);
    assertNull(owner);
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().id(1L).build();
    when(ownerRepository.save(any())).thenReturn(returnOwner);
    Owner savedOwner = ownerSDJpaService.save(ownerToSave);
    assertNotNull(savedOwner);
    assertEquals(ownerToSave.getId(), savedOwner.getId());
  }

  @Test
  void delete() {
    ownerSDJpaService.delete(returnOwner);
    verify(ownerRepository).delete(any());
  }

  @Test
  void findByLastName() {

    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

    Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, smith.getLastName());
    verify(ownerRepository).findByLastName(any());
  }

  @Test
  void deleteById() {
    ownerSDJpaService.deleteById(1L);
    verify(ownerRepository).deleteById(1L);
  }
}