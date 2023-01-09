package se.systementor.supershoppen1.shop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public String sendSimpleEmail(
            String to,
            String subject,
            String text) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("info@systementor.se");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            return "Message sent";
        }catch(Exception e){
            return "Message not sent";
        }


    }


}
