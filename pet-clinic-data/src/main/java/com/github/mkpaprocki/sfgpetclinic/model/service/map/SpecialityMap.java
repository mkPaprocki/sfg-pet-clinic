package com.github.mkpaprocki.sfgpetclinic.model.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Speciality;
import com.github.mkpaprocki.sfgpetclinic.model.service.SpecialtyService;
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
public class SpecialityMap extends AbstractMapService<Speciality, Long> implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
