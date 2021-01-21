package com.github.mkpaprocki.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
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

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listOwners() {
        return "/owners/index";
    }
}
