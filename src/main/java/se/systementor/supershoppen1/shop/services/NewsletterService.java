package se.systementor.supershoppen1.shop.services;

import org.springframework.stereotype.Service;
import se.systementor.supershoppen1.shop.model.Newsletter;
import se.systementor.supershoppen1.shop.model.NewsletterRepository;
import se.systementor.supershoppen1.shop.model.Subscriber;

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
    public void sendNewsletter(Newsletter Newsletter) {
        repository.save(Newsletter);
    }

    public Newsletter getLastNewsletter() {
        return getAll().get(getAll().size()-1);
    }

    public void deleteNewsletter(Integer id) {
        repository.deleteById(id);
    }
}