package es.ull.passengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengersTest {

    Passenger passenger1;
    Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Manuel", "ES");
        passenger2 =  new Passenger("2", "Pedro", "LK");
    }

    @Test
    @DisplayName("Getter of Name should work")
    void getName() {
        assertEquals("Manuel", passenger1.getName());
    }

    @Test
    @DisplayName("Getter of Identifier should work")
    void getIdentifier() {
        assertEquals("1", passenger1.getIdentifier());
    }

    @Test
    @DisplayName("Getter of Country should work")
    void getCountryCode() {
        assertEquals("ES", passenger1.getCountryCode());
    }

    @Test
    @DisplayName("Getter of Flight should work")
    void getFlight() {
        assertEquals(null, passenger1.getFlight());
    }

    @Test
    @DisplayName("Setter of Flight should work")
    void setFlight() {
        Flight flight = new Flight("AH001", 1);
        passenger1.setFlight(flight);
        assertEquals(flight, passenger1.getFlight());
    }

    @Test
    @DisplayName("The passenger's constructor must throw an exception because of invalid country.")
    void exceptionNameAndCountryTesting() {
        Throwable exception = assertThrows(RuntimeException.class, () -> new Passenger("1", "Manuel1", "ES1"));
        assertEquals("Invalid country code", exception.getMessage());
    }

    @Test
    @DisplayName("The passenger should join a flight")
    void joinFlight() {
        Flight flight = new Flight("AH001", 1);
        passenger1.joinFlight(flight);
        assertEquals(flight, passenger1.getFlight());
    }

    @Test
    @DisplayName("The passenger should be printed")
    void toStringTesting() {
        assertEquals("Passenger Manuel with identifier: 1 from ES", passenger1.toString());
    }
    
}
