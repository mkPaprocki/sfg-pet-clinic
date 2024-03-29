package com.github.mkpaprocki.sfgpetclinic.service.map;

import com.github.mkpaprocki.sfgpetclinic.model.Visit;
import com.github.mkpaprocki.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Visit object) {

  }

  @Override
  public Visit save(Visit visit) {
    if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
      throw new RuntimeException("Invalid Visit");
    }
    return super.save(visit);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }
}
