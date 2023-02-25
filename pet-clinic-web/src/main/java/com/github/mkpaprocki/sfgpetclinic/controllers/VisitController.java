package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.model.Visit;
import com.github.mkpaprocki.sfgpetclinic.repositories.VisitRepository;
import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import com.github.mkpaprocki.sfgpetclinic.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
class VisitController {

  private final OwnerService ownerService;
  private final VisitService visitService;
  private final VisitRepository visitRepository;

  public VisitController(OwnerService ownerService, VisitService visitService,
                         VisitRepository visitRepository) {
    this.ownerService = ownerService;
    this.visitService = visitService;
    this.visitRepository = visitRepository;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  /**
   * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
   * we always have fresh data - Since we do not use the session scope, make sure that
   * Pet object always has an id (Even though id is not part of the form fields)
   *
   * @param petId
   * @return Pet
   */
  @ModelAttribute("visit")
  public Visit loadPetWithVisit(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId,
                                Model model) {
    Owner owner = ownerService.findById(ownerId);

    Pet pet = owner.getPet(petId);
    model.addAttribute("pet", pet);
    model.addAttribute("owner", owner);

    Visit visit = new Visit();
    pet.getVisits().add(visit);
    visit.setPet(pet);
    return visit;
  }

  // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is
  // called
  @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String initNewVisitForm() {
    return "pets/createOrUpdateVisitForm";
  }

  // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is
  // called
  @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String processNewVisitForm(@ModelAttribute Owner owner, @PathVariable int petId, @Valid Visit visit,
                                    BindingResult result) {
    if (result.hasErrors()) {
      return "pets/createOrUpdateVisitForm";
    }

    Pet pet = owner.getPets().stream().filter(ownersPet -> ownersPet.getId() == petId).findFirst().get();
    pet.getVisits().add(visit);

    visitService.save(visit);
    return "redirect:/owners/" + visit.getPet().getOwner().getId();
  }

}