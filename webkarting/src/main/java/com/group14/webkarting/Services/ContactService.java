package com.group14.webkarting.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.webkarting.Models.Contact;
import com.group14.webkarting.Repositories.ContactRepository;
import com.group14.webkarting.Repositories.MailRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contacts;

    @Autowired
    private MailRepository mails;
    
    public ContactService() {

    }

    public Collection<Contact> findAll() {
        return contacts.findAll();
    }
     
    public Contact findById(long id) {
        return contacts.findById(id).get();    
    }

    public void save(Contact contact) {
        if(!mails.existsByMail(contact.getMail().getMail())){
            mails.save(contact.getMail());
        }else{
            contact.getMail().setMail_id(mails.findByMail(contact.getMail().getMail()).getMail_id());
        }
        
        contacts.save(contact);
    }

    public void deleteById(long id) {
        contacts.deleteById(id);
    }
}
