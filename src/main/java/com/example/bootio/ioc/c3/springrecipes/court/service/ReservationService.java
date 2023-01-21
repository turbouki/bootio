package com.example.bootio.ioc.c3.springrecipes.court.service;

import com.example.bootio.ioc.c3.springrecipes.court.model.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courtName);
}
