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
import com.group14.webkarting.utils.DNI;
import com.group14.webkarting.utils.Mail;
import com.group14.webkarting.utils.Person;
import com.group14.webkarting.utils.Phone;
import com.group14.webkarting.utils.Representant;

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

        if(!representants.existsByDniNumberAndDniLetter(reserve.getRepresentant().getDni().getNumber(),reserve.getRepresentant().getDni().getLetter())){
            if(!phones.existsByPhone(reserve.getRepresentant().getPhone().getPhone())){
                phones.save(reserve.getRepresentant().getPhone());
            }else{
                reserve.getRepresentant().setPhone(phones.findByPhone(reserve.getRepresentant().getPhone().getPhone()));
            }
            if(!dnis.existsByNumber(reserve.getRepresentant().getDni().getNumber())){
                dnis.save(reserve.getRepresentant().getDni());
            }else{
                reserve.getRepresentant().setDni(dnis.findByNumber(reserve.getRepresentant().getDni().getNumber()));
            }
            if(!mails.existsByMail(reserve.getRepresentant().getMail().getMail())){
                mails.save(reserve.getRepresentant().getMail());
            }else{
                reserve.getRepresentant().setMail(mails.findByMail(reserve.getRepresentant().getMail().toString()));
            }
            representants.save(reserve.getRepresentant());
            persons.save(reserve.getRepresentant());
        }else{
            reserve.getRepresentant().setPerson_id(persons.findByDniNumber(reserve.getRepresentant().getDni().getNumber()).getPerson_id());
        }

        for (int i = 1; i < reserve.getListUsers().size(); i ++){
            Person person = reserve.getListUsers().get(i);

            if(!persons.existsByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter())){
                if(!dnis.existsByNumber(person.getDni().toString())){
                    dnis.save(person.getDni());
                }else{
                    person.setDni(dnis.findByNumber(person.getDni().toString()));
                }
                persons.save(person);
            }else{
                //Person aux = persons.findByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter()).getPerson_id();
                //person = persons.findByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter());
                person.setPerson_id(persons.findByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter()).getPerson_id());
            }
        }
        reserve.getListUsers().get(0).setPerson_id(reserve.getRepresentant().getPerson_id());
        //reserve.getRepresentant().setPerson_id(reserve.getListUsers().get(0).getPerson_id());
        reserves.save(reserve);
    }

    public void deleteById(long id) {
        this.reserves.deleteById(id);
    }
}
