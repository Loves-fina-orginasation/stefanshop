package se.systementor.supershoppen1.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleEmail(
            String to,
            String subject,
            String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("");
        //TODO: set from - email
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

}
