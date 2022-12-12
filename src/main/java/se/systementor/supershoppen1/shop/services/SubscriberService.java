package se.systementor.supershoppen1.shop.services;

import org.springframework.stereotype.Service;
import se.systementor.supershoppen1.shop.model.NewsletterSubscriberRepository;
import se.systementor.supershoppen1.shop.model.Subscriber;
import se.systementor.supershoppen1.shop.model.SubscriberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;
    private final NewsletterSubscriberRepository newsletterSubscriberRepository;

    SubscriberService(SubscriberRepository repository,
                      NewsletterSubscriberRepository newsletterSubRepository) {
        super();
        this.subscriberRepository = repository;
        this.newsletterSubscriberRepository = newsletterSubRepository;
    }

    public List<Subscriber> getAll() {
        List<Subscriber> list = new ArrayList<Subscriber>();
        for (Subscriber subscriber : subscriberRepository.findAll()) {
            list.add(subscriber);
        }
        return list;
    }

    public Subscriber getSubscriber(Integer id) {
        return subscriberRepository.findById(id).get();
    }

    public void save(Subscriber Subscriber) {
        subscriberRepository.save(Subscriber);
    }

    public boolean checkIfEmailExists(String email) {
        List<Subscriber> subscribers = getAll();
        for (Subscriber sub : subscribers) {
            if (sub.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getSubscribersByNewsletter(Integer id) {
        List<String> subscriberList = new ArrayList<>();
        for (Subscriber subscriber : newsletterSubscriberRepository.findSubscriberByNewsletterId(id)) {
            subscriberList.add(subscriber.getEmail());
        }
        return subscriberList;
    }

}

