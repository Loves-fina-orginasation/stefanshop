package se.systementor.supershoppen1.shop.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.systementor.supershoppen1.shop.model.Newsletter;
import se.systementor.supershoppen1.shop.model.NewsletterSubscriberRepository;
import se.systementor.supershoppen1.shop.model.Subscriber;
import se.systementor.supershoppen1.shop.model.SubscriberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubscriberServiceTest {

    private SubscriberService sut;
    private SubscriberRepository subscriberRepository;
    private NewsletterSubscriberRepository newsletterSubscriberRepository;
    private static List<Subscriber> listOfSubscribers;
    private static List<Newsletter> listOfNewsletters;


    @BeforeEach
    void initService(){
        subscriberRepository = mock(SubscriberRepository.class);
        newsletterSubscriberRepository = mock(NewsletterSubscriberRepository.class);
        sut = new SubscriberService(subscriberRepository,newsletterSubscriberRepository);
        listOfSubscribers = new ArrayList<>();
        listOfNewsletters = new ArrayList<>();
        init();
    }

    public static void init(){

        //SET UP SUBSCRIBER
        Subscriber firstSubscriber = new Subscriber();
        firstSubscriber.setEmail("test@test.com");
        firstSubscriber.setId(1);
        firstSubscriber.setNewsletter(listOfNewsletters);
        listOfSubscribers.add(firstSubscriber);

        //SET UP NEWSLETTER
        Newsletter firstNewsletter = new Newsletter();
        firstNewsletter.setId(1);
        firstNewsletter.setSubject("Test");
        firstNewsletter.setMessage("Test");
    }

    @Test
    void getAll() {

        //ARRANGE

        when(subscriberRepository.findAll()).thenReturn(listOfSubscribers);

        //ACT

        List<Subscriber> actualSubscriberList = sut.getAll();

        //ASSERT

        assertEquals(1, actualSubscriberList.size());

    }

    @Test
    void getSubscriber() {

        //ARRANGE

        when(subscriberRepository.findById(1)).thenReturn(Optional.of(listOfSubscribers.get(0)));

        //ACT

        Subscriber actualSubscriber = sut.getSubscriber(1);

        //ASSERT

        assertEquals(1, actualSubscriber.getId());
        assertEquals("test@test.com", actualSubscriber.getEmail());
        verify(subscriberRepository,times(1)).findById(1);
    }

    @Test
    void save() {

        //ARRANGE

        Subscriber secondSubscriber = new Subscriber();
        secondSubscriber.setId(2);
        secondSubscriber.setEmail("test2@test.com");

        when(subscriberRepository.findAll()).thenReturn(listOfSubscribers);

        //ACT
        listOfSubscribers.add(secondSubscriber);
        sut.save(secondSubscriber);


        //ASSERT
        assertEquals(2, listOfSubscribers.size());
        verify(subscriberRepository,times(1)).save(secondSubscriber);

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
    void should_return_false_if_email_does_not_exists(){

        //ARRANGE

        when(subscriberRepository.findAll()).thenReturn(listOfSubscribers);

        //ACT

        boolean result = sut.checkIfEmailExists("test2@test.com");

        //ASSERT

        assertFalse(result);
    }


    @Test
    void getSubscribersByNewsletter() {

        //ARRANGE

        when(newsletterSubscriberRepository.findSubscriberByNewsletterId(1)).thenReturn(listOfSubscribers);


        //ACT

        List<String> actualSubscriber = sut.getSubscribersByNewsletter(1);

        //ASSERT

        assertEquals(1, actualSubscriber.size());
        assertEquals("test@test.com", actualSubscriber.get(0));
    }
}