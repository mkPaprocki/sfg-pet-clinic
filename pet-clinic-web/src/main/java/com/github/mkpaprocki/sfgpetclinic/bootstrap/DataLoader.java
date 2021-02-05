package com.github.mkpaprocki.sfgpetclinic.bootstrap;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.model.PetType;
import com.github.mkpaprocki.sfgpetclinic.model.Vet;
import com.github.mkpaprocki.sfgpetclinic.model.service.OwnerService;
import com.github.mkpaprocki.sfgpetclinic.model.service.PetTypeService;
import com.github.mkpaprocki.sfgpetclinic.model.service.VetService;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
