package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.systementor.supershoppen1.shop.model.Contact;

import se.systementor.supershoppen1.shop.services.ContactService;

@Controller

public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    
    @GetMapping("/contact")
    public String form (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }
    


}
