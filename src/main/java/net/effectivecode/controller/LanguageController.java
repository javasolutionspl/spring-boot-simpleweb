package net.effectivecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {

    //Mapping for defined request in home.html - see line number 23
    @GetMapping("/language")
    public String get() {

        return "redirect:/";
    }
}