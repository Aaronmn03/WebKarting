package com.group14.webkarting.RestController;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group14.webkarting.Models.Contact;
import com.group14.webkarting.Services.ContactService;

@RestController
@RequestMapping("/api/Contact")
public class ContactRestController {
    
    @Autowired
    private ContactService contacts;

    @PostMapping("/")
    public  ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        contacts.save(contact);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();

        return ResponseEntity.created(location).body(contact);
    }

    @GetMapping("/")
    public Collection<Contact> getContacts() {
        return contacts.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable long id) {
        Contact contact = contacts.findById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable long id) {
        Contact contact = contacts.findById(id);
        if (contact != null) {
            contacts.deleteById(id);
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> replaceReserve(@PathVariable long id, @RequestBody Contact newContact) {
        Contact contact = contacts.findById(id);
        if (contact != null) {
            newContact.setId(id);
            contacts.save(newContact);
            return ResponseEntity.ok(contact);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
