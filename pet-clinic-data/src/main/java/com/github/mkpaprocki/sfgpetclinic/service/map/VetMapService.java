package com.github.mkpaprocki.sfgpetclinic.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Speciality;
import com.github.mkpaprocki.sfgpetclinic.model.Vet;
import com.github.mkpaprocki.sfgpetclinic.service.SpecialtyService;
import com.github.mkpaprocki.sfgpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
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
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    map.remove(id);
  }

  @Override
  public Vet save(Vet object) {

    if (object.getSpecialities().size() > 0) {
      object.getSpecialities().forEach(speciality -> {
        if (speciality.getId() == null) {
          Speciality savedSpeciality = specialtyService.save(speciality);
          savedSpeciality.setId(savedSpeciality.getId());
        }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
