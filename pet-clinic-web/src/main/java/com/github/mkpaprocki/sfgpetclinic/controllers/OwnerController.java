package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.model.Owner;
import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Project: sfg-pet-clinic
 * <p>
 * Created on: 21.01.2021
 * <p>
 * Author    : Mateusz Paprocki
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

//  @GetMapping({"", "/", "/index", "/index.html"})
//  String listOwners(Model model) {
//
//    model.addAttribute("owners", ownerService.findAll());
//
//    return "owners/index";
//  }

  @RequestMapping("/find")
  public String findOwners(Model model) {
    model.addAttribute("owner", Owner.builder().build());
    return "owners/findOwners";
  }

  @GetMapping
  public String processFindForm(Owner owner, BindingResult result, Model model) {

    //allow parameterless GET request for /owners to return all records

    if (owner.getLastName() == null) {
      owner.setLastName(""); //empty string signifies broadest possible search
    }

    //find owners by last name
    List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());

    if (results.isEmpty()) {
      result.rejectValue("lastName", "notFound", "not found");
      return "owners/findOwners";
    } else if (results.size() == 1) {
      //1 owner found
      owner = results.get(0);
      return "redirect:/owners/" + owner.getId();
    } else {
      model.addAttribute("selections", results);
      return "owners/ownersList";
    }
  }

  @GetMapping("/{ownerId}")
  public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
    ModelAndView mav = new ModelAndView("owners/ownerDetails");
    mav.addObject(ownerService.findById(ownerId));
    return mav;
  }
}
