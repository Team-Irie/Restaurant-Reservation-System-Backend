package com.gryffindor.project2.controllers;

import com.gryffindor.controllers.ReservationController;
import com.gryffindor.models.Reservation;
import com.gryffindor.models.User;
import com.gryffindor.services.ReservationService;
import com.gryffindor.services.UserService;
import com.gryffindor.types.ReservationStatus;
import com.gryffindor.types.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {
    @InjectMocks
    ReservationController reservationController;
    @Mock
    private UserService userService;
    @Mock
    private ReservationService reservationService;
    private User user;
    private Reservation reservation1;
    private List<Reservation> reservationList = new ArrayList<>();
    @BeforeEach
    public void run() {
        user = new User(12,"john","Cary","jon@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        reservation1 = new Reservation(1,1, new Timestamp(System.currentTimeMillis()), 1, "panda", "133 s spring vallyeRd, Tx, 75240", "3030303030", ReservationStatus.APPROVED);
        reservationList.add(reservation1);
    }
    @Test
    public void getReservationsByCustomerTest() {
        when(userService.getUserById(Mockito.anyInt())).thenReturn(user);
        when(reservationService.getReservationsByCustomer(Mockito.any())).thenReturn(reservationList);
        List<Reservation> result = reservationController.getReservationsByCustomer(12);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getReservationId());
    }
}