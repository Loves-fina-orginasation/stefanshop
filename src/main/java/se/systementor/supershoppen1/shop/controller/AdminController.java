package se.systementor.supershoppen1.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import se.systementor.supershoppen1.shop.services.ProductService;
import se.systementor.supershoppen1.shop.services.SubscriberService;

@Controller
public class AdminController {
    private  ProductService productService;
    private SubscriberService subscriberService;

    @Autowired
    public AdminController(ProductService productService, SubscriberService subscriberService) {
        this.productService = productService;
        this.subscriberService = subscriberService;
    }    

    @GetMapping(path="/admin/products")
    String empty(Model model)
    {
        model.addAttribute("products", productService.getAll());
        return "admin/products";
    }

    @GetMapping(path="/subscriber/getAll")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("subscriber");
        mav.addObject("subscribers", subscriberService.getAll());
        return mav;
    }



}
