package com.gryffindor.project2.services;

import com.gryffindor.models.Reservation;
import com.gryffindor.models.User;
import com.gryffindor.repositories.ReservationRepository;
import com.gryffindor.services.ReservationService;
import com.gryffindor.types.ReservationStatus;
import com.gryffindor.types.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.support.Repositories;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;
    @Mock
    ReservationRepository reservationRepository;
    private List<Reservation> reservationList = new ArrayList<>();;
    private List<Reservation> reservationApproveList = new ArrayList<>();;
    private Reservation reservation1;
    private User user;
    @BeforeEach
    public void run() {
        user = new User(12,"john","Cary","jon@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        reservation1 = new Reservation(1,1, new Timestamp(System.currentTimeMillis()), 1, "panda", "133 s spring vallyeRd, Tx, 75240", "3030303030", ReservationStatus.APPROVED);
        Reservation reservation2 = new Reservation(2,1, new Timestamp(System.currentTimeMillis()), 2, "Lalibel", "145 s spring vallyeRd, Tx, 75240", "2020202", ReservationStatus.PENDING);
        reservationApproveList.add(reservation1);
        reservationList.add(reservation1);
        reservationList.add(reservation2);
    }

    @Test
    public void getAllReservations () {
        when(reservationRepository.findAll()).thenReturn(reservationList);
        List<Reservation> result = reservationService.getAllReservations();
        assertEquals(2, result.size());
    }

    @Test
    public void getReservationsByCustomerTest() {
        when(reservationRepository.getReservationsByCustomer(Mockito.any())).thenReturn(reservationList);
        List<Reservation> result = reservationService.getReservationsByCustomer(user.getUserId());
        assertEquals(2, result.size());
    }

    @Test
    public void getReservationByIdTest() {
        when(reservationRepository.getById(Mockito.anyInt())).thenReturn(reservation1);
        Reservation result = reservationService.getReservationById(1);
        assertNotNull(result);
        assertEquals(1, reservation1.getReservationId());

    }

    @Test
    public void deleteReservationTest() {
        doNothing().when(reservationRepository).delete(reservation1);
        reservationService.deleteReservation(reservation1);
        verify(reservationRepository,times(1)).delete(reservation1);
    }

}