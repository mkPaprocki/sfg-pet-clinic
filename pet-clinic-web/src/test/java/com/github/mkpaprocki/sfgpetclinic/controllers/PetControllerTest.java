package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import com.github.mkpaprocki.sfgpetclinic.service.PetService;
import com.github.mkpaprocki.sfgpetclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

  Owner owner;

  @Mock
  PetService petService;
  @Mock
  OwnerService ownerService;
  @Mock
  PetTypeService petTypeService;

  @InjectMocks
  PetController controller;

  @BeforeEach
  void setUp() {
    owner = Owner.builder().id(1L).build();
  }

  @Test
  void populatePetTypes() {
  }

  @Test
  void findOwner() {
  }

  @Test
  void initOwnerBinder() {
  }

  @Test
  void initCreationForm() {
  }

  @Test
  void processCreationForm() {
  }

  @Test
  void initUpdateForm() {
  }

  @Test
  void processUpdateForm() {
  }
}