package org.kje.main.controllers;

import org.kje.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController implements ExceptionProcessor {

    @GetMapping
    public String index() {

        return "front/main/index";
    }
}