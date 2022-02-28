package com.gryffindor.application;

import com.gryffindor.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@ComponentScan("com.gryffindor")
public class  Project2Application {


	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {

		SpringApplication.run(Project2Application.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("parajuli.kr@gmail.com",
				"Reservation Confirmation",
				"Your reservation request has been confirmed");

	}

}

/*
*
* application is not able to recognize components because of directory structure
* components must be in either:
* 1. same directory as main application
* 2. subdirectory within the main application directory
*
* got this error when using @ComponentScan, or when trying to rearrange directory structure:
*
*
* ***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in com.gryffindor.controllers.ReservationController required a bean of type 'com.gryffindor.services.ReservationService' that could not be found.


Action:

Consider defining a bean of type 'com.gryffindor.services.ReservationService' in your configuration.
*
*
* will not compile when controllers are referenced in @ComponentScan
*
* */

