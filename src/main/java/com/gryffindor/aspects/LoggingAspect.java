package com.gryffindor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public LoggingAspect() {}

    @Before("execution(* com.gryffindor.services.UserService.*(..))")
    public void beforeUserServiceCalls(JoinPoint joinPoint) {
        System.out.println("UserService Method: " + joinPoint.getSignature() + " called");
    }

    @AfterThrowing("execution(* com.gryffindor.services.UserService.*(..))")
    public void notAManager(JoinPoint joinPoint) {
        System.out.println("You are not a manager");
    }

    @AfterReturning("execution(* com.gryffindor.services.UserService.*(..))")
    public void afterReturningAUser(JoinPoint joinPoint) {
        System.out.println("A User was returned from: " + joinPoint.getSignature());
    }

    @After("execution(* com.gryffindor.services.UserService.*(..))")
    public void afterReturnUser(JoinPoint joinPoint) {
        System.out.println("A User was returned from: ");
    }

    @Before("execution(* com.gryffindor.services.ReservationService.*(..))")
    public void beforeReservationServiceCalls(JoinPoint joinPoint) {
        System.out.println("ReservationService Method: " + joinPoint.getSignature() + " called");
    }

    @AfterReturning("execution(* com.gryffindor.services.ReservationService.*(..))")
    public void afterReturningAReservation(JoinPoint joinPoint) {
        System.out.println("A Reservation was returned from: " + joinPoint.getSignature());
    }

    @After("execution(* com.gryffindor.services.ReservationService.*(..))")
    public void afterReturnReservation(JoinPoint joinPoint) {
        System.out.println("A Reservation was returned from: ");
    }
}