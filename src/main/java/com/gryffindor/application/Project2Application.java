package com.gryffindor.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.gryffindor")
public class  Project2Application {
	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}
}

/*
*
* application is not able to recognize components because of folder structure
* components must be in same folder as or subfolder in application
*
* got this error when using @ComponentScan, or when trying to rearrange folder structure:
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
* will not compile when reservation controller is recognized
*
* */

