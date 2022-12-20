package Flight;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import es.ull.flights.Flight;
import es.ull.passengers.Passenger;

public class FlightTest {

    private Flight vuelo1;
    private Flight vuelo2;

    @BeforeEach
    void setup() {
        vuelo1 = new Flight("AA001", 50);
        vuelo2 = new Flight("AA002", 1);
    }

    //Test correcto
    @DisplayName("Flight and passengers number")
    @Test
    public void getnumbers(){
        assertAll("Verifica numeros de pasajero y de vuelo",() -> assertEquals("AA001",vuelo1.getFlightNumber()), () -> assertEquals(0,vuelo1.getNumberOfPassengers()));

    }

    //Test no correcto
    @DisplayName("Incorrect flight number")
    @Test
    public void NoFlightNumber(){

        assertAll("Verifica numeros de vuelo",() -> assertEquals("AA001",vuelo1.getFlightNumber()), () -> assertEquals("AA003",vuelo2.getFlightNumber()));
    }

    //Test correcto
    @DisplayName("Number of seats")
    @Test
    public void NumberSeats(){
        assertEquals(50, vuelo1.getSeats());
        assertNotEquals(0,vuelo1.getSeats());
    }

    //Test no correcto
    @DisplayName("Incorrect number of seats")
    @Test
    public void NoNumberSeats(){
        assertEquals(5, vuelo2.getSeats());
        assertNotEquals(0,vuelo2.getSeats());
    }

}
