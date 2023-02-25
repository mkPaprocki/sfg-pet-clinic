package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.model.Pet;
import com.github.mkpaprocki.sfgpetclinic.model.PetType;
import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import com.github.mkpaprocki.sfgpetclinic.service.PetService;
import com.github.mkpaprocki.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

  private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

  private final PetService petService;
  private final OwnerService ownerService;
  private final PetTypeService petTypeService;

  public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
    this.petService = petService;
    this.ownerService = ownerService;
    this.petTypeService = petTypeService;
  }

  @ModelAttribute("petType")
  public Collection<PetType> populatePetTypes() {
    return petTypeService.findAll();
  }

  @ModelAttribute("owner")
  public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
    return ownerService.findById(ownerId);
  }

  @InitBinder("owner")
  public void initOwnerBinder(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @GetMapping("/pets/new")
  public String initCreationForm(Owner owner, Model model) {
    Pet pet = new Pet();
    owner.getPets().add(pet);
    model.addAttribute("pet", pet);
    return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
  }

  @PostMapping("/pets/new")
  public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
    if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
      result.rejectValue("name", "duplicate", "already exists");
    }

    owner.getPets().add(pet);
    pet.setOwner(owner);
    if (result.hasErrors()) {
      model.addAttribute("pet", pet);
      return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    Owner savedOwner = ownerService.save(owner);
    return "redirect:/owners/" + savedOwner.getId();
  }

  @GetMapping("/pets/{petId}/edit")
  public String initUpdateForm(Owner owner, @PathVariable("petId") Long petId, Model model) {
    Pet pet = owner.getPet(petId);
    model.addAttribute("pet", pet);
    return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
  }

  @PostMapping("/pets/{petId}/edit")
  public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("pet", pet);
      return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    owner.getPets().add(pet);
    Owner savedOwner = ownerService.save(owner);
    return "redirect:/owners/}" + savedOwner.getId();
  }
}
