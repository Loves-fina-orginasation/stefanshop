package se.systementor.supershoppen1.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping(path = "/getAll")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("subscriber");
        mav.addObject("subscribers", subscriberService.getAll());
        return mav;
    }

    @GetMapping(path = "/get/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id) {
        return subscriberService.getSubscriber(id);
    }

    @PostMapping(path = "/save")
    public void saveEmail(@ModelAttribute Subscriber subscriber, Model model) {
        model.addAttribute("saved");
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmail(@RequestParam(name = "addingsub") String email) {
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email);
        subscriberService.save(subscriber);
        return "redirect:/";
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