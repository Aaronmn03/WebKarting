package com.group14.webkarting.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group14.webkarting.utils.Mail;

public interface MailRepository extends JpaRepository<Mail,Long>{
    Mail findByMail(String mail);
    boolean existsByMail(String mail);
}
