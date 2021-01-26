package com.github.mkpaprocki.sfgpetclinic.model.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Vet;
import com.github.mkpaprocki.sfgpetclinic.model.service.CrudService;
import com.github.mkpaprocki.sfgpetclinic.model.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 20.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
