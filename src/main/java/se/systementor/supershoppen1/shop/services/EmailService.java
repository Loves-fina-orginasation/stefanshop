package se.systementor.supershoppen1.shop.services;

public interface EmailService {

    String sendSimpleEmail(String to,
                         String Subject,
                         String message);

}
