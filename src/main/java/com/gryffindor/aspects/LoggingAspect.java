package com.gryffindor.aspects;
/*
import com.gryffindor.models.Reservation;
import com.gryffindor.models.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @AfterReturning("execution(com.gryffindor.services.UserService *(..))")
    public void afterReturningAUser(JoinPoint joinPoint) {
        System.out.println("A User was returned from: " + joinPoint.getSignature());
    }

    @After("execution(* com.gryffindor.services.UserService.*(..))")
    public void afterReturnUser(JoinPoint joinPoint) {
        System.out.println("A User was returned from: ");
    }

    @Around("execution(* com.gryffindor.services.UserService.*(..))")
    public User aroundCreateUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("New User registering");
        for(int i = 0; i < proceedingJoinPoint.getArgs().length; i++) {
            System.out.println(proceedingJoinPoint.getArgs()[i]);
        }

        User user = (User)proceedingJoinPoint.proceed();
        System.out.println("User: " + user + "was registered");

        return user;
    }

    @Before("execution(* com.gryffindor.services.ReservationService.*(..))")
    public void beforeReservationServiceCalls(JoinPoint joinPoint) {
        System.out.println("ReservationService Method: " + joinPoint.getSignature() + " called");
    }

    @AfterReturning("execution(com.gryffindor.services.ReservationService *(..))")
    public void afterReturningAReservation(JoinPoint joinPoint) {
        System.out.println("A Reservation was returned from: " + joinPoint.getSignature());
    }

    @After("execution(* com.gryffindor.services.ReservationService.*(..))")
    public void afterReturnReservation(JoinPoint joinPoint) {
        System.out.println("A Reservation was returned from: ");
    }

    @Around("execution(* com.gryffindor.services.ReservationService.*(..))")
    public Reservation aroundCreateReservation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("New Reservation being created");
        for(int i = 0; i < proceedingJoinPoint.getArgs().length; i++) {
            System.out.println(proceedingJoinPoint.getArgs()[i]);
        }

        Reservation reservation = (Reservation)proceedingJoinPoint.proceed();
        System.out.println("Reservation: " + reservation + "was registered");

        return reservation;
    }
}
*/