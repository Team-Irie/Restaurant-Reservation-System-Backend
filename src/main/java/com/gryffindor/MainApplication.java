package com.gryffindor;

import com.gryffindor.services.EmailSenderService;
import com.gryffindor.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class  MainApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("*").allowedOrigins("http://localhost:4200");
            }
        };
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        senderService.sendEmail("parajuli.kr@gmail.com",
                "Reservation Confirmation",
                "Your reservation request has been confirmed");

    }*/
}