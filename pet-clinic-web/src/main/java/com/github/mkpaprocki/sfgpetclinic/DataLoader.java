package com.github.mkpaprocki.sfgpetclinic;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.model.Vet;
import com.github.mkpaprocki.sfgpetclinic.model.service.OwnerService;
import com.github.mkpaprocki.sfgpetclinic.model.service.VetService;
import com.github.mkpaprocki.sfgpetclinic.model.service.map.OwnerServiceMap;
import com.github.mkpaprocki.sfgpetclinic.model.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        System.out.println("Loaded Vets...");

    }
}
