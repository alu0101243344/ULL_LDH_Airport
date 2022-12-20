package FlightPassengers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import es.ull.flights.Flight;
import es.ull.passengers.Passenger;

public class flightpassengerstest {

    private Flight vuelo1;
    private Flight vuelo2;
    private Passenger kevin;
    private Passenger andres;

    @BeforeEach
    void setup() {
        vuelo1 = new Flight("AA001", 50);
        vuelo2 = new Flight("AA002", 1);
        kevin = new Passenger("AA011", "kevin", "ES");
        andres = new Passenger("AA012", "andres", "ES");
}
    //Test correcto
    @DisplayName("Add passenger")
    @Test
    public void addpassenger(){

        assertTrue(vuelo1.addPassenger(kevin));

    }

    @DisplayName("Add passenger no seats")
    @Test
    public void addpassenger2(){

        vuelo2.addPassenger(kevin);
        assertThrows(RuntimeException.class,()->{vuelo2.addPassenger(andres);} );
    }

    //Test correcto
    @DisplayName("Remove passenger")
    @Test
    public void removepassenger(){

        vuelo1.addPassenger(kevin);
        vuelo1.addPassenger(andres);
        assertEquals(2, vuelo1.getNumberOfPassengers());

        vuelo1.removePassenger(kevin);
        assertEquals(1, vuelo1.getNumberOfPassengers());

    }

    //Test correcto
    @DisplayName("Set and Get flight")
    @Test
    public void setgetflight(){

        kevin.setFlight(vuelo2);
        assertEquals("AA002", kevin.getFlight().getFlightNumber());
        assertEquals(0, kevin.getFlight().getNumberOfPassengers());

    }

    //Test correcto
    @DisplayName("Join flight")
    @Test
    public void joinflight(){

        kevin.joinFlight(vuelo1);
        assertEquals("AA001", kevin.getFlight().getFlightNumber());

    }

    //Test no correcto
    @DisplayName("Join flight 2")
    @Test
    public void joinflight2(){

        kevin.joinFlight(vuelo2);
        assertEquals("AA001", kevin.getFlight().getFlightNumber());

        kevin.joinFlight(vuelo1);
        assertEquals("AA002", kevin.getFlight().getFlightNumber());

    }
}
