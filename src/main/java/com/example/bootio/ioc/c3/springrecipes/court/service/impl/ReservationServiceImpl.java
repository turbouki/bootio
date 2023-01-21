package com.example.bootio.ioc.c3.springrecipes.court.service.impl;

import com.example.bootio.ioc.c3.springrecipes.court.model.Player;
import com.example.bootio.ioc.c3.springrecipes.court.model.Reservation;
import com.example.bootio.ioc.c3.springrecipes.court.model.SportType;
import com.example.bootio.ioc.c3.springrecipes.court.service.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {
    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(1, "Soccer");

    public final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16,
                new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20,
                new Player("James", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream().filter(reservation -> Objects.equals(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
