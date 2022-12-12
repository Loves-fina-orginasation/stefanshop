package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.systementor.supershoppen1.shop.model.Newsletter;
import org.springframework.web.servlet.ModelAndView;
import se.systementor.supershoppen1.shop.model.Subscriber;
import se.systementor.supershoppen1.shop.services.SubscriberService;

import java.util.List;

@Controller
@RequestMapping("/subscriber")
public class SubscriberController {
    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService SubscriberService) {
        this.subscriberService = SubscriberService;
    }

    @GetMapping(path = "/get/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id) {
        return subscriberService.getSubscriber(id);
    }


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveEmail(@ModelAttribute("Newsletter")Subscriber subscriber, Model model,
                            @RequestParam(name = "addingsub") String email){

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        boolean exists = checkIfEmailExists(email);
        if(exists){
            model.addAttribute("checkEmail", exists);
        }else if(email.matches(emailRegex)){
            subscriber.setEmail(email);
            subscriberService.save(subscriber);
        }else{
            model.addAttribute("checkEmail", exists);
        }
        return "home";
    }

    public boolean checkIfEmailExists(String email){
        return subscriberService.checkIfEmailExists(email);
    }

    @ResponseBody
    @GetMapping(path = "/checkEmail/{email}")
    public boolean checkIfEmailExists(@PathVariable String email) {
        return subscriberService.checkIfEmailExists(email);
    }

    @GetMapping(path = "/getByNewsletter/{id}")
    public List<String> getSubscriberByNewsletter(@PathVariable Integer id) {
        return subscriberService.getSubscribersByNewsletter(id);
    }


}