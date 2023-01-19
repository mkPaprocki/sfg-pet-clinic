package com.github.mkpaprocki.sfgpetclinic.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.service.PetService;
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
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Pet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    map.remove(id);
  }

  @Override
  public Pet save(Pet object) {
    return super.save(object);
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }
}
