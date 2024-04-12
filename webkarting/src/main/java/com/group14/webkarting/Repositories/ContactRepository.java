package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.Models.Contact;
import java.util.List;
import com.group14.webkarting.utils.Mail;


public interface ContactRepository extends JpaRepository<Contact,Long>{  
    List<Contact> findByMail(Mail mail);
}
