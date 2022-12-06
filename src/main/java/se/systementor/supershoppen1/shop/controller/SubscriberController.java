package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(path="/getAll")
    public List<Subscriber> getAll(){
        return subscriberService.getAll();
    }

    @GetMapping(path="/get/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id){
        return subscriberService.getSubscriber(id);
    }

    @PostMapping(path="/save")
    public void save(Subscriber Subscriber) {
        subscriberService.save(Subscriber);
    }

    @GetMapping(path="/checkUser")
    public boolean checkUserToDb(Integer id){
        return subscriberService.checkUserToDb(id);
    }

}