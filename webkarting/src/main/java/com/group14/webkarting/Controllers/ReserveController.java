package com.group14.webkarting.Controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group14.webkarting.Reserva;

@RestController
@RequestMapping("/Reserve")

public class ReserveController {
    private Map<Integer, Reserva> reservasMapa = new HashMap<>();
    private int contadorReservas = 1; // Utilizado como identificador único para cada reserva

    @PostMapping("")
    public  ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {

        reservasMapa.put(contadorReservas, reserva);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{contadorReservas}").buildAndExpand(contadorReservas).toUri();

        contadorReservas++;
        return ResponseEntity.created(location).body(reserva);

    }

    @GetMapping("")
    public  Map<Integer, Reserva> getReserva() {
        
        return reservasMapa;
    }
}
