package com.group14.webkarting.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerClass {

    @GetMapping("/")
    public String si(Model model) {

        return "index";
    }
    
}
