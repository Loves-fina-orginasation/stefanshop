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

    @GetMapping("/admin/edit-newsletter")
    public String editNewsletter(Model model) {
        Newsletter newsletter = new Newsletter();
        Newsletter tempNewsletter = getLastNewsletter();
        model.addAttribute("newsletter", newsletter);
        model.addAttribute("message",tempNewsletter.getMessage());
        model.addAttribute("subject",tempNewsletter.getSubject());

        return "admin/edit-newsletter";
    }

    public Newsletter getLastNewsletter(){
        return newsletterService.getLastNewsletter();
    }



    @PostMapping("/admin/newsletters")
    public String sendNewsletter(@ModelAttribute("newsletter") Newsletter newsletter, Model model,
                                 @RequestParam(value = "send-newsletter", required = false) String sendButton,
                                 @RequestParam(value = "save-newsletter", required = false) String saveButton,
                                 @RequestParam(value = "subject", required = false) String subject,
                                 @RequestParam(value = "message", required = false) String message){

        Newsletter test = getLastNewsletter().getSent() ? newsletter: getLastNewsletter();

        if (saveButton != null) {
            saveNewsletter(test, subject, message, false);
        } else if (sendButton != null) {
                saveNewsletter(test, subject, message, true);
        }
        model.addAttribute("newsletters", newsletterService.getAll());
        return "admin/newsletters";
    }

    private void saveNewsletter(Newsletter newsletter, String subject, String message, boolean bol) {
        newsletter.setSent(bol);
        newsletter.setSubject(subject);
        newsletter.setMessage(message);
        newsletterService.sendNewsletter(newsletter);
    }

}