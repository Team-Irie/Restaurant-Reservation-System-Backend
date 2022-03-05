package com.gryffindor;

import com.gryffindor.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class  MainApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        senderService.sendEmail("parajuli.kr@gmail.com",
                "Reservation Confirmation",
                "Your reservation request has been confirmed");

    }*/
}