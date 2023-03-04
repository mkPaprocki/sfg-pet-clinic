package com.github.mkpaprocki.sfgpetclinic.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.service.PetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PetTypeMapServiceTest {

  private static final long PET_1_ID = 1L;
  private static final long PET_2_ID = 2L;
  PetService service;
  Pet pet1;
  Pet pet2;

  @BeforeEach
  void setUp() {
    this.service = new PetMapService();
    //given
    pet1 = Pet.builder()
        .id(PET_1_ID)
        .build();
    pet2 = Pet.builder()
        .id(PET_2_ID)
        .build();

    service.save(pet1);
    service.save(pet2);
  }

  @Test
  void findAllReturnsEmptyList() {
    //given
    service = new PetMapService();

    //when
    Set<Pet> returnedList = service.findAll();

    //then
    assertNotNull(returnedList);
    assertEquals(0, returnedList.size());
  }

  @Test
  void findAllReturns2Elements() {
    //when
    Set<Pet> returnedList = service.findAll();

    //then
    assertNotNull(returnedList);
    assertEquals(02, returnedList.size());
  }

  @Test
  void savingNullTrowsException() {
    Assertions.assertThrows(RuntimeException.class, () -> service.save(null));
  }

  @Test
  void findByIdPetReturnsThatPet() {
    //then
    assertEquals(pet1, service.findById(pet1.getId()));
    assertEquals(pet2, service.findById(pet2.getId()));
    assertEquals(2, service.findAll().size());
    assertTrue(service.findAll().contains(pet1));
    assertTrue(service.findAll().contains(pet2));
  }

  @Test
  void findByIdNonExistingIdReturnsNull() {
    //when
    Pet nonExistingPet = service.findById(3l);

    //then
    assertNull(nonExistingPet);
  }

  @Test
  void deletingPetDeletesThatPet() {
    //when
    service.delete(pet1);

    //then
    assertEquals(1, service.findAll().size());
    assertTrue(service.findAll().contains(pet2));
    assertFalse(service.findAll().contains(pet1));
  }

  @Test
  void deletingPetByIdDeletesThatPet() {
    //when
    service.deleteById(PET_1_ID);

    //then
    assertEquals(1, service.findAll().size());
    assertTrue(service.findAll().contains(pet2));
    assertFalse(service.findAll().contains(pet1));
  }

  @Test
  void deletingPetByIdNull() {
    //when
    service.deleteById(null);

    //then
    assertEquals(2, service.findAll().size());
    assertTrue(service.findAll().contains(pet2));
    assertTrue(service.findAll().contains(pet1));
  }

  @Test
  void deletingPetByIdOfNotExistingPet() {
    //when
    service.deleteById(3L);

    //then
    assertEquals(2, service.findAll().size());
    assertTrue(service.findAll().contains(pet2));
    assertTrue(service.findAll().contains(pet1));
  }

  @Test
  void saveNoId() {
    //given
    service = new PetMapService();

    //when
    service.save(Pet.builder().build());

    //then
    assertEquals(1, service.findAll().size());
    assertNotNull(service.findAll().iterator().next().getId());
  }
}