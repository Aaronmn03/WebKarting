package com.group14.webkarting.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.webkarting.Models.Race;
import com.group14.webkarting.Repositories.DNIRepository;
import com.group14.webkarting.Repositories.DriverRepository;
import com.group14.webkarting.Repositories.LapRepository;
import com.group14.webkarting.Repositories.RaceRepository;
import com.group14.webkarting.utils.Driver;
import com.group14.webkarting.utils.Lap;

@Service
public class RaceService {
    @Autowired
    private RaceRepository races;

    @Autowired
    private DNIRepository dnis;

    @Autowired
    private DriverRepository drivers;

    @Autowired
    private LapRepository lapRepository;
    
    public RaceService() {

    }

    public Collection<Race> findAll() {
        return races.findAll();
    }
     
    public Race findById(long id) {
        return races.findById(id).get();    
    }

    public void save(Race race) {
        List<Driver> newDrivers = new ArrayList<>();
        for(Driver driver : race.getListDrivers()){
            if(!dnis.existsByNumber(driver.getDni().toString())){
                dnis.save(driver.getDni());
            }
            List<Lap> savedLaps = lapRepository.saveAll(driver.getListLaps());
            Driver driverSaved= new Driver(driver.getDni(),driver.getName(),driver.getSurname(),savedLaps,driver.getnKart()); 
            newDrivers.add(driverSaved);            
        }   
        drivers.saveAll(newDrivers);
        Race auxRace = new Race(newDrivers, race.getNumberLaps());     
        races.save(auxRace);
    }

    public void deleteById(long id) {
        races.deleteById(id);
    }
}
