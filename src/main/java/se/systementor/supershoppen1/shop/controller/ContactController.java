package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import se.systementor.supershoppen1.shop.model.Contact;
=======
>>>>>>> Stashed changes
import se.systementor.supershoppen1.shop.services.ContactService;

@Controller
//@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
<<<<<<< Updated upstream
    
    @GetMapping("/contact")
    public String form (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

=======

    @GetMapping(path = "/admin/contact")
    public String form(Model model) {
        model.addAttribute("contact");
        return "admin/contact";
    }
>>>>>>> Stashed changes

}
