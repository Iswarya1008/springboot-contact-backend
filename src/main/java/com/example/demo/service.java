package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class service {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactMail(model contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(contact.getEmail());
        message.setTo("svfworld1@gmail.com"); // Receiver email
        message.setSubject("New Contact Enquiry from " + contact.getName());
        message.setText(
                "Name: " + contact.getName() + "\n" +
                        "Email: " + contact.getEmail() + "\n" +
                        "Phone: " + contact.getPhone() + "\n" +
                        "Location: " + contact.getLocation() + "\n" +
                        "Message: " + contact.getMessage()
        );

        mailSender.send(message);
    }

}
