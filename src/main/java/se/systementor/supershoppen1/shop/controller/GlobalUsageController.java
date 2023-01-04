package se.systementor.supershoppen1.shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import se.systementor.supershoppen1.shop.services.SubscriberService;

@ControllerAdvice
public class GlobalUsageController {
    private SubscriberService subscriberService;

    public GlobalUsageController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @ModelAttribute("hideSubscription")
    public boolean newsLetterWindow()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) return false;
        Object ud = auth.getPrincipal();
        if(ud instanceof UserDetails)
        {
            String email = ((UserDetails)ud).getUsername();
            return subscriberService.checkIfEmailExists(email);
        }
        else{
            return false;
        }
    }
}
