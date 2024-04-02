package com.group14.webkarting.Services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.group14.webkarting.Models.Contact;

@Service
public class ContactService {
    private ConcurrentMap<Long, Contact> contacts = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);
    
    public ContactService() {

    }

    public Collection<Contact> findAll() {
        return contacts.values();
    }
     
    public Contact findById(long id) {
        return contacts.get(id);    
    }

    public void save(Contact contact) {
        if(contact.getId() == null || contact.getId() == 0) {
            long id = nextId.getAndIncrement();
            contact.setId(id);
        }
        this.contacts.put(contact.getId(), contact);
    }

    public void deleteById(long id) {
        this.contacts.remove(id);
    }
}
