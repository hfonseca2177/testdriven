package com.hfonseca.tdd.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {


    public Flight(Long id) {
        this.id = id;
        if(passengers == null){
            passengers = new ArrayList<Passenger>();
        }
    }

    private Long id;
    private List<Passenger> passengers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
