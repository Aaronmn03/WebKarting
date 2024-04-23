package com.group14.webkarting.Services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group14.webkarting.Models.Reserve;
import com.group14.webkarting.Repositories.DNIRepository;
import com.group14.webkarting.Repositories.MailRepository;
import com.group14.webkarting.Repositories.PersonRepository;
import com.group14.webkarting.Repositories.PhoneRepository;
import com.group14.webkarting.Repositories.RepresentantRepository;
import com.group14.webkarting.Repositories.ReserveRepository;
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
        Representant representant = reserve.getRepresentant();
        if(!representants.existsByDniNumberAndDniLetter(representant.getDni().getNumber(),representant.getDni().getLetter())){
            saveRepresentant(representant);
        }else{
            representant.setPerson_id(persons.findByDniNumber(representant.getDni().getNumber()).getPerson_id());
        }
        
        checkSavePersons(reserve.getListUsers());
      
        reserve.getListUsers().get(0).setPerson_id(reserve.getRepresentant().getPerson_id());
        reserves.save(reserve);
    }

    private void saveRepresentant(Representant representant){
        if(!phones.existsByPhone(representant.getPhone().getPhone())){
            phones.save(representant.getPhone());
        }else{
            representant.setPhone(phones.findByPhone(representant.getPhone().getPhone()));
        }
        if(!dnis.existsByNumber(representant.getDni().getNumber())){
            dnis.save(representant.getDni());
        }else{
            representant.setDni(dnis.findByNumber(representant.getDni().getNumber()));
        }
        if(!mails.existsByMail(representant.getMail().getMail())){
            mails.save(representant.getMail());
        }else{
            representant.setMail(mails.findByMail(representant.getMail().toString()));
        }
        representants.save(representant);
        persons.save(representant);
    }

    private void checkSavePersons(List<Person> list_persons){
        for (int i = 1; i < list_persons.size(); i ++){
            Person person = list_persons.get(i);
            if(!persons.existsByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter())){
                savePerson(person);
            }else{
                person.setPerson_id(persons.findByDniNumberAndDniLetter(person.getDni().getNumber(),person.getDni().getLetter()).getPerson_id());
            }
        }
    }

    private void savePerson(Person person){
        if(!dnis.existsByNumber(person.getDni().toString())){
            dnis.save(person.getDni());
        }else{
            person.setDni(dnis.findByNumber(person.getDni().toString()));
        }
        persons.save(person);
    }

    public void deleteById(long id) {
        this.reserves.deleteById(id);
    }
}
