package com.group14.webkarting.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RatesController {

    
    @RequestMapping("/Rates")
    public String getEvents(Model model){
        return "rates";
    }
}