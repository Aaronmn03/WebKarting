package com.group14.webkarting.RestController;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group14.webkarting.Models.Reserve;
import com.group14.webkarting.Services.ReserveService;

@RestController
@RequestMapping("/api/Reserve")

public class ReserveRestController {
    
    @Autowired
    private ReserveService reserves;


    @PostMapping("/")
    public  ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve) {
        reserves.save(reserve);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reserve.getId()).toUri();

        return ResponseEntity.created(location).body(reserve);
    }

    @GetMapping("/")
    public Collection<Reserve> getReserves() {
        return reserves.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> getReserve(@PathVariable long id) {
        Reserve reserve = reserves.findById(id);
        if (reserve != null) {
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reserve> deleteReserve(@PathVariable long id) {
        Reserve reserve = reserves.findById(id);
        if (reserve != null) {
            reserves.deleteById(id);
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserve> replaceReserve(@PathVariable long id, @RequestBody Reserve newReserve) {
        Reserve reserve = reserves.findById(id);
        if (reserve != null) {
            newReserve.setId(id);
            reserves.save(newReserve);
            return ResponseEntity.ok(reserve);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Reserve> editReserve(@PathVariable long id, @RequestBody Reserve patchRequest) {
        Reserve existingReserve = reserves.findById(id);
    
        if (existingReserve == null) {
            return ResponseEntity.notFound().build();
        }
        
        if (patchRequest.getNumUsers() != 0) {
            existingReserve.setNumUsers(patchRequest.getNumUsers());
        }
        if (patchRequest.getDate_hour() == null) {
            existingReserve.setDate_hour(patchRequest.getDate_hour());
        }
        if (patchRequest.getListUsers() == null) {
            existingReserve.setListUsers(patchRequest.getListUsers());
        }
        if (patchRequest.getRepresentant() == null) {
            existingReserve.setRepresentant(patchRequest.getRepresentant());
        }
        reserves.save(existingReserve);

        return ResponseEntity.ok(existingReserve);
    }

}
