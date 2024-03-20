package com.group14.webkarting.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group14.webkarting.Services.ReserveService;

@Controller
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @RequestMapping("/")
    public String Home(Model model) {
        return "home";
    }

    @RequestMapping("/Reserves/")
    public String getReserves(Model model) {
        model.addAttribute("reserves", reserveService.findAll());
        return "reserves";
    }

    @RequestMapping("/newReserve")
    public String newReserve(Model model) {

        return "new_reserve";
    }

    @RequestMapping("/Reserves/{id}/")
    public String getReserve(Model model,@PathVariable long id) {
        model.addAttribute("reserve", reserveService.findById(id));
        return "reserve";
    }

    @RequestMapping("/Reserves/editReserve/{id}/")
    public String editReserve(Model model,@PathVariable long id) {
        model.addAttribute("reserve", reserveService.findById(id));
        return "edit_reserve";
    }
    @RequestMapping("/Reserves/removeReserve/{id}/")
    public String deleteReserve(Model model,@PathVariable long id) {
        reserveService.deleteById(id);
        model.addAttribute("reserves", reserveService.findAll());
        return "reserves";
    }
}
