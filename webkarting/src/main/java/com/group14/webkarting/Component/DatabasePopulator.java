package com.group14.webkarting.Component;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.group14.webkarting.Models.Contact;
import com.group14.webkarting.Repositories.ContactRepository;
import com.group14.webkarting.Repositories.MailRepository;
import com.group14.webkarting.utils.Mail;

import jakarta.annotation.PostConstruct;

@Component
@Profile("local")
public class DatabasePopulator {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MailRepository mailRepository;

    @PostConstruct
    public void populateDB(){
        Mail mail1 = new Mail("juan@gmail.com");
        Mail mail2 = new Mail("luis@gmail.com");
        Mail mail3 = new Mail("juana@gmail.com");
        mailRepository.saveAll(Arrays.asList(mail1, mail2, mail3));

        // Crea y guarda los objetos Contact
        contactRepository.saveAll(
            Arrays.asList(
                new Contact(mail1, "Juan", "Holaa, me encanta vuestra pagina"),
                new Contact(mail2, "Luis", "Vuestra forma de reservar me encanta"),
                new Contact(mail3, "Juana", "Como me gusta la oferta del campeonato")
            )
        );
    }
}
