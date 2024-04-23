package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.Driver;


public interface DriverRepository extends JpaRepository<Driver,Long>{  
    boolean existsByDniNumberAndDniLetter(String number, char letter);
}
