package com.group14.webkarting.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.representer.Represent;

import com.group14.webkarting.Models.Reserve;
import com.group14.webkarting.Repositories.DNIRepository;
import com.group14.webkarting.Repositories.MailRepository;
import com.group14.webkarting.Repositories.PersonRepository;
import com.group14.webkarting.Repositories.PhoneRepository;
import com.group14.webkarting.Repositories.RepresentantRepository;
import com.group14.webkarting.Repositories.ReserveRepository;
import com.group14.webkarting.utils.Mail;
import com.group14.webkarting.utils.Person;
import com.group14.webkarting.utils.Phone;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository reserves;

    @Autowired
    private DNIRepository dnis;

    @Autowired
    private MailRepository mails;

    @Autowired
    private PersonRepository persons;

    @Autowired
    private PhoneRepository phones;

    @Autowired
    private RepresentantRepository representants;

    public ReserveService() {

    }

    public Collection<Reserve> findAll() {
        return reserves.findAll();
    }
     
    public Reserve findById(long id) {
        return reserves.findById(id).get();    
    }

    public void save(Reserve reserve) {
        for (Person person : reserve.getListUsers()){
            if(!persons.existsByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter())){
                if(!dnis.existsByNumber(person.getDni().toString())){
                    dnis.save(person.getDni());
                }
                persons.save(person);
            }
        }

        if(!representants.existsByDniNumberAndDniLetter(reserve.getRepresentant().getDni().getNumber(),reserve.getRepresentant().getDni().getLetter())){
            if(!phones.existsByPhone(reserve.getRepresentant().getPhone().getPhone())){
                phones.save(reserve.getRepresentant().getPhone());
            }
            if(!dnis.existsByNumber(reserve.getRepresentant().getDni().toString())){
                dnis.save(reserve.getRepresentant().getDni());
            }
            if(!mails.existsByMail(reserve.getRepresentant().getMail().getMail())){
                mails.save(reserve.getRepresentant().getMail());
            }
            representants.save(reserve.getRepresentant());
            reserve.getListUsers().get(0).setPerson_id(reserve.getRepresentant().getPerson_id());
        }

        reserves.save(reserve);
    }

    public void deleteById(long id) {
        this.reserves.deleteById(id);
    }
}
