package com.group14.webkarting.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    
    @RequestMapping("/Events")
    public String getEvents(){
        return "events";
    }
}