package com.gryffindor.services;

import com.gryffindor.models.Reservation;
import com.gryffindor.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ReservationService {

    private ReservationRepository rr;

    public ReservationService() {
    }

    @Autowired
    public ReservationService(ReservationRepository rr) {
        this.rr = rr;
    }

    //public create()

    public List<Reservation> getAll(){
        return rr.findAll();
    }

    public void update(Reservation reservation){
        rr.save(reservation);
    }

    public void delete(Reservation reservation){
        rr.delete(reservation);
    }
}
