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
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    String listVets() {
        return "vets/index";
    }
}
