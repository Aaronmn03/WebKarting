package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.Phone;


public interface PhoneRepository extends JpaRepository<Phone,Long>{  
    boolean existsByPhone(int phone);
}
