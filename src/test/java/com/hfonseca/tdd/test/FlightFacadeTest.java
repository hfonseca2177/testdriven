package com.hfonseca.tdd.test;


import com.hfonseca.tdd.business.FlightFacade;
import com.hfonseca.tdd.model.Flight;
import com.hfonseca.tdd.model.Passenger;
import com.hfonseca.tdd.model.PassengerType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Run mvn test to see at
 * /target/site/jacoco/index.html a test coverage report
 */
public class FlightFacadeTest {


    private static List<Passenger> passengers;
    private static int id = 0;

    @BeforeAll
    private static void setUptests(){
        Stream<Passenger> strPassengers = Stream.generate(() ->
        new Passenger(generateId(), "passenger", PassengerType.ECONOMIC)).limit(99);
        passengers = strPassengers.collect(Collectors.toList());
    }

    public static Long generateId(){
        return new Long(++id);
    }

    @Test
    public void testAddPassenger(){
        FlightFacade flightFacade = new FlightFacade();
        Flight flight = new Flight(1l);

        Passenger passenger1 = new Passenger(100l, "Mike", PassengerType.FIRST_CLASS);
        //testing the return of Passenger method
        assertTrue(flightFacade.addPassenger(flight, passenger1));
        //testing trying to add an existing passenger
        assertFalse(flightFacade.addPassenger(flight,passenger1));
        //test max size
        flight.setPassengers(this.passengers);
        flightFacade.addPassenger(flight, passenger1);
        Passenger passengerExtra = new Passenger(101l, "Joe", PassengerType.FIRST_CLASS);
        assertFalse(flightFacade.addPassenger(flight, passengerExtra));


    }

    @Test
    public void testRemovePassenger(){
        FlightFacade flightFacade = new FlightFacade();
        Flight flight = new Flight(1l);
        Passenger passenger1 = new Passenger(1l, "Ted", PassengerType.FIRST_CLASS);
        assertTrue(flightFacade.addPassenger(flight, passenger1));
        //test removing a first class passenger
        assertTrue(flightFacade.removePassenger(flight, passenger1));
        //test removing a economic class passenger
        Passenger passenger2 = new Passenger(2l, "Billy", PassengerType.ECONOMIC);
        assertTrue(flightFacade.addPassenger(flight, passenger2));
        assertFalse(flightFacade.removePassenger(flight, passenger2));
    }
}
