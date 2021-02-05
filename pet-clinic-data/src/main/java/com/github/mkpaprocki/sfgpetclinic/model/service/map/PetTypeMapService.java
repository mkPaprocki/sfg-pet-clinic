package com.github.mkpaprocki.sfgpetclinic.model.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.PetType;
import com.github.mkpaprocki.sfgpetclinic.model.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 05.02.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
