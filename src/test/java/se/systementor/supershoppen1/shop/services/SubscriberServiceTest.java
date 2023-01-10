package se.systementor.supershoppen1.shop.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.systementor.supershoppen1.shop.model.NewsletterSubscriberRepository;
import se.systementor.supershoppen1.shop.model.Subscriber;
import se.systementor.supershoppen1.shop.model.SubscriberRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SubscriberServiceTest {

    private SubscriberService sut;
    private SubscriberRepository subscriberRepository;
    private NewsletterSubscriberRepository newsletterSubscriberRepository;
    private static List<Subscriber> listOfSubscribers;


    @BeforeEach
    void initService(){
        subscriberRepository = mock(SubscriberRepository.class);
        newsletterSubscriberRepository = mock(NewsletterSubscriberRepository.class);
        sut = new SubscriberService(subscriberRepository,newsletterSubscriberRepository);
        listOfSubscribers = new ArrayList<>();
        initSubscriber();
    }

    public static void initSubscriber(){
        Subscriber firstSubscriber = new Subscriber();
        firstSubscriber.setEmail("test@test.com");
        listOfSubscribers.add(firstSubscriber);
    }

    @Test
    void getAll() {

        //ARRANGE

        //ACT

        //ASSERT
    }

    @Test
    void getSubscriber() {

        //ARRANGE

        //ACT

        //ASSERT
    }

    @Test
    void save() {

        //ARRANGE

        //ACT

        //ASSERT
    }

    @Test
    void checkIfEmailExists() {
        //ARRANGE

        when(subscriberRepository.findAll()).thenReturn(listOfSubscribers);

        //ACT

        boolean result = sut.checkIfEmailExists("test@test.com");

        //ASSERT

        assertTrue(result);

    }

    @Test
    void getSubscribersByNewsletter() {

        //ARRANGE

        //ACT

        //ASSERT
    }
}