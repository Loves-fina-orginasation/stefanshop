package se.systementor.supershoppen1.shop.services;

public interface EmailService {

    void sendSimpleEmail(String to,
                         String Subject,
                         String message);

}
