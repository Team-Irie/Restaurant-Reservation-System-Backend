package com.gryffindor.services;

import com.gryffindor.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationService {

    private ReservationRepository rr;

    public ReservationService() {
    }

    @Autowired
    public ReservationService(ReservationRepository rr) {
        this.rr = rr;
    }
}
