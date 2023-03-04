package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.model.Visit;
import com.github.mkpaprocki.sfgpetclinic.service.PetService;
import com.github.mkpaprocki.sfgpetclinic.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
class VisitController {

  private final PetService petService;
  private final VisitService visitService;

  public VisitController(PetService petService, VisitService visitService) {
    this.petService = petService;

    this.visitService = visitService;
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
  public Visit loadPetWithVisit(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId, Model model) {
    Pet pet = petService.findById(petId);
    model.addAttribute("pet", pet);
    Visit visit = Visit.builder().build();
    pet.getVisits().add(visit);
    visit.setPet(pet);
    return visit;
  }

  @InitBinder
  public void dataBinder(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");

    dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDate.parse(text));
      }
    });
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
  public String processNewVisitForm(@ModelAttribute Owner owner, @PathVariable Long petId, @Valid Visit visit, BindingResult result) {
    if (result.hasErrors()) {
      return "pets/createOrUpdateVisitForm";
    }

    Pet pet = petService.findById(petId);
    pet.getVisits().add(visit);
    visit.setPet(pet);

    visitService.save(visit);
    return "redirect:/owners/" + pet.getOwner().getId();
  }

}