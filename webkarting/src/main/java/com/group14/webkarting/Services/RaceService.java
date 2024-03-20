package com.group14.webkarting.Services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.group14.webkarting.Models.Race;

@Service
public class RaceService {
    private ConcurrentMap<Long, Race> races = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);
    
    public RaceService() {

    }

    public Collection<Race> findAll() {
        return races.values();
    }
     
    public Race findById(long id) {
        return races.get(id);    
    }

    public void save(Race race) {
        if(race.getId() == null || race.getId() == 0) {
            long id = nextId.getAndIncrement();
            race.setId(id);
        }
        this.races.put(race.getId(), race);
    }

    public void deleteById(long id) {
        this.races.remove(id);
    }
}
