package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.DNI;


public interface DNIRepository extends JpaRepository<DNI,Long>{  
    boolean existsByNumber(String number);
}
