package com.group14.webkarting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group14.webkarting.Services.RaceService;

@Controller
public class RaceController {
    @Autowired
    private RaceService raceService;

    @RequestMapping("/Races/")
    public String getRaces(Model model) {
        model.addAttribute("races", raceService.findAll());
        return "races";
    }
    @RequestMapping("/newRace")
    public String newRace(Model model) {
        return "new_race";
    }

    @RequestMapping("/Race/{id}/")
    public String getReserve(Model model,@PathVariable long id) {
        model.addAttribute("race", raceService.findById(id));
        return "race";
    }

    @RequestMapping("/Race/{id}/User/{idUser}")
    public String getReserve(Model model,@PathVariable long id, @PathVariable long idUser) {
        model.addAttribute("driver", raceService.findById(id).getListDrivers().get((int) idUser));
        return "raceUser";
    }
}
