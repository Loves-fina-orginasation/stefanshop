package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.systementor.supershoppen1.shop.model.Newsletter;
import se.systementor.supershoppen1.shop.services.NewsletterService;

@Controller
public class NewsletterController {
    private NewsletterService newsletterService;

    @Autowired
    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @GetMapping(path="/admin/newsletters")
    String empty(Model model)
    {
        model.addAttribute("newsletters", newsletterService.getAll());
        return "admin/newsletters";
    }

    /*@PostMapping(path="/admin/newsletters/send")
    public void sendNewsletter(@RequestBody Newsletter newNewsletter) {
            newsletterService.sendNewsletter(newNewsletter);
            }

    /*@RequestMapping("/admin/send-newsletter")
    public String sendNewsletter() {
        return "/admin/send-newsletter";
            }

     */
    @GetMapping("/admin/send-newsletter")
    public String newNewsletter(Model model) {
        Newsletter newsletter = new Newsletter();
        model.addAttribute("newsletter", newsletter);

        return "admin/send-newsletter";
    }

    @PostMapping("/admin/newsletters")
    public String sendNewsletter(@ModelAttribute("newsletter") Newsletter newsletter, Model model) {
        newsletterService.sendNewsletter(newsletter);
        model.addAttribute("newsletters", newsletterService.getAll());
        return "admin/newsletters";
    }
}