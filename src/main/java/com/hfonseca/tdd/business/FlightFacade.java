package com.hfonseca.tdd.business;

import com.hfonseca.tdd.model.Flight;
import com.hfonseca.tdd.model.Passenger;
import com.hfonseca.tdd.model.PassengerType;

public class FlightFacade {

    public final int MAX_PASSENGERS = 100;

    public boolean addPassenger(Flight flight, Passenger passenger) {
        boolean success = false;
        if (flight.getPassengers().size() < MAX_PASSENGERS && !flight.getPassengers().contains(passenger)) {
            flight.getPassengers().add(passenger);
            success = true;
        }
        return success;
    }

    public boolean removePassenger(Flight flight, Passenger passenger) {
        boolean success = false;
        if (PassengerType.FIRST_CLASS.equals(passenger.getType())) {
            flight.getPassengers().remove(passenger);
            success = true;
        }
        return success;
    }
}
