package com.group14.webkarting.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.group14.webkarting.Models.Reserve;



@Controller
public class ControllerClass {

    @GetMapping("/")
    public String Home(Model model) {
        return "home";
    }
    @GetMapping("/Tarifas")
    public String Rates(Model model) {

        return "rates";
    }

}
