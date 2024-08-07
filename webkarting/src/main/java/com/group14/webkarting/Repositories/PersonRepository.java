package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.Person;


public interface PersonRepository extends JpaRepository<Person,Long>{  
    boolean existsByDniNumberAndDniLetter(String number, char letter);
    Person findByDniNumberAndDniLetter(String number, char letter);
    Person findByDniNumber(String number);
}
