package se.systementor.supershoppen1.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import se.systementor.supershoppen1.shop.model.Subscriber;
import se.systementor.supershoppen1.shop.model.SubscriberRepository;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    SubscriberService(SubscriberRepository repository) {
        super();
        this.subscriberRepository = repository;
    }

    public List<Subscriber> getAll(){
        List<Subscriber> list = new ArrayList<Subscriber>();
        for(Subscriber subscriber : subscriberRepository.findAll()){
            list.add(subscriber);
        }
        return list;
    }

    public Subscriber getSubscriber(Integer id){
        return subscriberRepository.findById(id).get();
    }

    public void save(Subscriber Subscriber) {
        subscriberRepository.save(Subscriber);
    }

    public boolean checkIfEmailExists(String email) {
        List<Subscriber> subscribers= getAll();
        for(Subscriber sub : subscribers){
            if(sub.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
}

