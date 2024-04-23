package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.Representant;


public interface RepresentantRepository extends JpaRepository<Representant,Long>{  
    boolean existsByDniNumberAndDniLetter(String number, char letter);
    Representant findByDniNumberAndDniLetter(String number, char letter);
}
