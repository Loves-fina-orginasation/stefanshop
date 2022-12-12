package se.systementor.supershoppen1.shop.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsletterSubscriberRepository extends CrudRepository<Subscriber, Integer> {

List<Subscriber> findSubscriberByNewsletterId(Integer id);

}


