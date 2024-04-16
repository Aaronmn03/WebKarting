package com.group14.webkarting.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.group14.webkarting.Models.Contact;
import com.group14.webkarting.Models.Reserve;
import com.group14.webkarting.Repositories.ContactRepository;
import com.group14.webkarting.Repositories.DNIRepository;
import com.group14.webkarting.Repositories.MailRepository;
import com.group14.webkarting.Repositories.PersonRepository;
import com.group14.webkarting.Repositories.PhoneRepository;
import com.group14.webkarting.Repositories.RepresentantRepository;
import com.group14.webkarting.Repositories.ReserveRepository;
import com.group14.webkarting.utils.DNI;
import com.group14.webkarting.utils.Mail;
import com.group14.webkarting.utils.Person;
import com.group14.webkarting.utils.Phone;
import com.group14.webkarting.utils.Representant;

import jakarta.annotation.PostConstruct;

@Component
@Profile("local")
public class DatabasePopulator {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MailRepository mailRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private DNIRepository DNIRepository;

    @Autowired
    private RepresentantRepository representRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ReserveRepository reserveRepository;
    
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
        
        Mail mail4 = new Mail("pedro@gmail.com");
        Mail mail5 = new Mail("maria@gmail.com");
        Mail mail6 = new Mail("jose@gmail.com");
        Mail mail7 = new Mail("javier@gmail.com");
        mailRepository.saveAll(Arrays.asList(mail4,mail5,mail6,mail7));

        Phone phone1 = new Phone(987655689);
        Phone phone2 = new Phone(123456789);
        Phone phone3 = new Phone(987654321);
        Phone phone4 = new Phone(123456189);
        Phone phone5 = new Phone(987754321);
        
        phoneRepository.saveAll(Arrays.asList(phone1,phone2,phone3,phone4,phone5));

        DNI dni1 = new DNI("87654321X");
        DNI dni2 = new DNI("53958835F");
        DNI dni3 = new DNI("12345678Z");
        DNI dni4 = new DNI("04657567K");
        DNI dni5 = new DNI("53958835F");

        DNIRepository.saveAll(Arrays.asList(dni1,dni2,dni3,dni4,dni5));
        
        Person person1 = new Person(dni1, "Pedro", "Gonzalez");
        Person person2 = new Person(dni2, "Maria", "Pérez");
        Person person3 = new Person(dni3, "Jose", "García");
        Person person4 = new Person(dni4, "Javier", "Martínez");
        Person person5 = new Person(dni5, "Paco", "Palotes");
        
        
        List<Person> listPerson = Arrays.asList(person1,person2,person3,person4);
        personRepository.saveAll(listPerson);

        Representant representant = new Representant(person5,mail7,phone5);
        representRepository.save(representant);

        Reserve reserve = new Reserve(4,LocalDateTime.now(),representant,listPerson);
        reserveRepository.save(reserve);

    }
}
