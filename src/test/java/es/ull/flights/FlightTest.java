package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Manuel", "ES");
        passenger2 =  new Passenger("2", "Pedro", "LK");
        flight = new Flight("AH001", 30);
    }


    @Test
    @DisplayName("Getters of the flight class should work")
    void groupGettersAssertions() {
        assertAll("Flight",
                () -> assertEquals("AH001", flight.getFlightNumber()),
                () -> assertEquals(0, flight.getNumberOfPassengers())
        );
    }

    @Test
    @DisplayName("Add passenger to one flight")
    void addPassenger() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getNumberOfPassengers());
    }
    
    @Test
    @DisplayName("The flight should allow add a passenger into the aircraft.")
    void addPassengerTesting() {
        assertEquals(true, flight.addPassenger(passenger1));
    }

    @Test
    @DisplayName("The flight's constructor must throw an exception because of invalid flight number.")
    void exceptionFlightNumberTesting() {
        Throwable exception = assertThrows(RuntimeException.class, () -> new Flight("A1", 1));
        assertEquals("Invalid flight number", exception.getMessage());
    }

    @Test
    @DisplayName("The flight must throw an exception if there is no seat for the passenger.")
    void exceptionPassengerTesting() {
        Flight flight = new Flight("AA0000", 1);
        flight.addPassenger(passenger1);

        Throwable exception = assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));
        assertEquals("Not enough seats for flight AA0000" , exception.getMessage());
    }

    @Test
    @DisplayName("The flight should allow us to remove a passenger.")
    void successfulRemoveTesting(){
        flight.addPassenger(passenger1);
        assertEquals(true,flight.removePassenger(passenger1));
    }

    @Test
    @DisplayName("The flight shouldn't allow us to remove an non existent passenger.")
    void failRemoveTesting(){
        flight.addPassenger(passenger1);
        assertEquals(false,flight.removePassenger(passenger2));
    }

  
}
