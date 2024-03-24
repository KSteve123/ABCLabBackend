package com.ABCLaboratories.TestRegistrationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage m1=new SimpleMailMessage();
        m1.setFrom("stevegame007@gmail.com");
        m1.setTo(toEmail);
        m1.setText(body);
        m1.setSubject(subject);

        mailSender.send(m1);

        System.out.print("Mail sent Successfully");
    }
}
