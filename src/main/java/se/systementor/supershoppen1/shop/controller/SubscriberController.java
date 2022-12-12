package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.systementor.supershoppen1.shop.model.Newsletter;
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

    @GetMapping(path="/get/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id){
        return subscriberService.getSubscriber(id);
    }


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveEmail(@RequestParam(name = "addingsub") String email) {
        Subscriber subscriber = new Subscriber();
        if(checkIfEmailExists(email)){
            return "redirect:/";
        }else{
            subscriber.setEmail(email);
            subscriberService.save(subscriber);
        }
        return "redirect:/";
    }

    public boolean checkIfEmailExists(String email){
        return subscriberService.checkIfEmailExists(email);
    }
}