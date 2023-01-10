package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.systementor.supershoppen1.shop.services.EmailService;
import se.systementor.supershoppen1.shop.services.EmailServiceImpl;


@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public  EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public void sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message
    ){
        emailService.sendSimpleEmail(to, subject,message);
    }

}
