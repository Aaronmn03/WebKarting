package com.group14.webkarting.RestController;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group14.webkarting.Models.Race;
import com.group14.webkarting.Models.Reserve;
import com.group14.webkarting.Services.RaceService;

@RestController
@RequestMapping("/api/Race")
public class RaceRestController {
    @Autowired
    private RaceService races;

    @PostMapping("/")
    public  ResponseEntity<Race> createRace(@RequestBody Race race) {
        races.save(race);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(race.getId()).toUri();

        return ResponseEntity.created(location).body(race);
    }

    @GetMapping("/")
    public Collection<Race> getRaces() {
        return races.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> getRaces(@PathVariable long id) {
        Race race = races.findById(id);
        if (race != null) {
            return ResponseEntity.ok(race);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Race> deleteRace(@PathVariable long id) {
        Race race = races.findById(id);
        if (race != null) {
            races.deleteById(id);
            return ResponseEntity.ok(race);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> replaceReserve(@PathVariable long id, @RequestBody Race newRace) {
        Race race = races.findById(id);
        if (race != null) {
            newRace.setId(id);
            races.save(newRace);
            return ResponseEntity.ok(race);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //PATCH

}
