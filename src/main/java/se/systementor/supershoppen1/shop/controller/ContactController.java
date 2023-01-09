package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.systementor.supershoppen1.shop.model.Contact;

import se.systementor.supershoppen1.shop.services.ContactService;
import se.systementor.supershoppen1.shop.services.EmailService;

@Controller

public class ContactController {

    private final ContactService contactService;
    private final EmailService emailService;

    @Autowired
    public ContactController(ContactService contactService,
                             EmailService emailService) {
        this.contactService = contactService;
        this.emailService = emailService;
    }

    
    @GetMapping("/contact")
    public String form (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping("/contactUs")
    public String sendForm (@RequestParam(value="email") String email,
                            @RequestParam(value="subject") String subject,
                            @RequestParam(value="message") String message) {

        emailService.sendSimpleEmail(email, subject, message);
        return "contact";
    }




}
