package se.systementor.supershoppen1.shop.services;

import org.springframework.stereotype.Service;
import se.systementor.supershoppen1.shop.model.Newsletter;
import se.systementor.supershoppen1.shop.model.NewsletterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsletterService {

    private final NewsletterRepository repository;

    public NewsletterService(NewsletterRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Newsletter> getAll(){
        var l = new ArrayList<Newsletter>();
        for(Newsletter r : repository.findAll())
        {
            l.add(r);
        }
        return l;
    }

}