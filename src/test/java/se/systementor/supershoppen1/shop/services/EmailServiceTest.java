package se.systementor.supershoppen1.shop.services;

import org.aspectj.bridge.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailServiceImpl sut;


    @BeforeEach
    void initService(){
        sut = new EmailServiceImpl();
    }

    @Test
    void sendSimpleEmail_with_messageNotSent_result() {
        //ARRANGE
        String from = "test@systementor.se";
        String to = "test@systementor.se";
        String subject = "test";
        String text = "test";


        //ACT

        String result = sut.sendSimpleEmail(to, subject, text);

        //ASSERT

        assertEquals("Message not sent", result);


    }
}