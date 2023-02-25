package com.github.mkpaprocki.sfgpetclinic.bootstrap;

import com.github.mkpaprocki.sfgpetclinic.model.*;
import com.github.mkpaprocki.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 26.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialitiesService;
  private final VisitService visitService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                    SpecialtyService specialitiesService, VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialitiesService = specialitiesService;
    this.visitService = visitService;
  }

  @Override
  public void run(String... args) throws Exception {

    int count = petTypeService.findAll().size();

    if (count == 0) {
      loadData();
    }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
      PetType savedDogPetType = petTypeService.save(dog);

      PetType cat = new PetType();
      cat.setName("Cat");
      PetType savedCatPetType = petTypeService.save(cat);

      Speciality radiology = new Speciality();
      radiology.setDescription("Radiology");
      Speciality savedRadiology = specialitiesService.save(radiology);

      Speciality surgery = new Speciality();
      surgery.setDescription("Surgery");
      Speciality savedSurgery = specialitiesService.save(surgery);

      Speciality dentistry = new Speciality();
      dentistry.setDescription("Dentistry");
      Speciality savedDentistry = specialitiesService.save(dentistry);

      Owner.builder().address("ADSF").id(3L).firstName("name").build();

      Owner owner1 = new Owner();
      owner1.setFirstName("Michael");
      owner1.setLastName("Weston");
      owner1.setAddress("123 Brockerel");
      owner1.setCity("Miami");
      owner1.setTelephone("1231231234");

      Pet mieksPet = new Pet();
      mieksPet.setPetType(savedDogPetType);
      mieksPet.setOwner(owner1);
      mieksPet.setBirthDate(LocalDate.now());
      mieksPet.setName("Rosco");
      owner1.getPets().add(mieksPet);

      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setFirstName("Fiona");
      owner2.setLastName("Gleanne");
      owner2.setAddress("123 Brockerel");
      owner2.setCity("Miami");
      owner2.setTelephone("1231231234");

      Pet fionasCat = new Pet();
      fionasCat.setPetType(savedCatPetType);
      fionasCat.setOwner(owner2);
      fionasCat.setBirthDate(LocalDate.now());
      fionasCat.setName("Just Cat");
      owner2.getPets().add(fionasCat);
      ownerService.save(owner2);

      Visit catVisit = new Visit();
      catVisit.setPet(fionasCat);
      catVisit.setDate(LocalDate.now());
      catVisit.setDescription("Sneezy Kitty");

      visitService.save(catVisit);

      System.out.println("Loaded Owners...");

      Vet vet1 = new Vet();
      vet1.setFirstName("Sam");
      vet1.setLastName("Axe");
      vet1.getSpecialities().add(savedRadiology);

      vetService.save(vet1);

      Vet vet2 = new Vet();
      vet2.setFirstName("Jessie");
      vet2.setLastName("Porter");
      vet2.getSpecialities().add(savedSurgery);

      vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
