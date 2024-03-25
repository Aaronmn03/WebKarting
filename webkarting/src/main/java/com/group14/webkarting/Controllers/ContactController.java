package com.group14.webkarting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group14.webkarting.Services.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/newContacts")
    public String newContact() {
        return "new_contact";
    }

    @RequestMapping("/Contacts/")
    public String getRaces(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "contacts";
    }
    
    @RequestMapping("/Contact/{id}/")
    public String getReserve(Model model,@PathVariable long id) {
        model.addAttribute("contact", contactService.findById(id));
        return "contact_info";
    }
}
