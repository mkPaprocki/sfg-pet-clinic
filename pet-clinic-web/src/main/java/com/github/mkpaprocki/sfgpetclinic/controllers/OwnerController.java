package com.github.mkpaprocki.sfgpetclinic.controllers;

import com.github.mkpaprocki.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }
}
