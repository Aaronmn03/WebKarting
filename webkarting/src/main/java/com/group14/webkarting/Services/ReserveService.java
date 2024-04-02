package com.group14.webkarting.Services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.group14.webkarting.Models.Reserve;

@Service
public class ReserveService {
    private ConcurrentMap<Long, Reserve> reserves = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public ReserveService() {

    }

    public Collection<Reserve> findAll() {
        return reserves.values();
    }
     
    public Reserve findById(long id) {
        return reserves.get(id);    
    }

    public void save(Reserve reserve) {
        if(reserve.getId() == null || reserve.getId() == 0) {
            long id = nextId.getAndIncrement();
            reserve.setId(id);
        }
        this.reserves.put(reserve.getId(), reserve);
    }

    public void deleteById(long id) {
        this.reserves.remove(id);
    }
}
