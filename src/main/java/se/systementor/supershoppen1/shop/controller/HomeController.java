package se.systementor.supershoppen1.shop.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import se.systementor.supershoppen1.shop.model.Product;
import se.systementor.supershoppen1.shop.services.ProductService;

@Controller
public class HomeController {
    private  ProductService productService;
    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

   @GetMapping(path="/")
    String empty(Model model)
    {
        getKrisInfo(model);
        return "home";

    }

    private void getKrisInfo(Model model){

        String url = "https://api.krisinformation.se/v3/features";
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(url, Object[].class);
        model.addAttribute("krisinformation", Arrays.asList(result));
    }

    public Model getSingleKrisArticle(Model model, String id){
        String url = "https://api.krisinformation.se/v3/features/"+id;
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(url, Object.class);
        return model.addAttribute("krisArticle", result);
    }

    @GetMapping(path="/kris-information")
    public String krisinfo(Model model,
                           @RequestParam(value = "id") String articleId){
        getSingleKrisArticle(model, articleId);
        return "kris-information";
    }

    @GetMapping(path="/test2")
    List<Product> getAll(){
        return productService.getAll();
    }
}
