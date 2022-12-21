/**
 * <p>
 *  This class is used to test the different data of the passengers.
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Test and verify the passengers ID </li>
 *  <li> Test and verify the passengers country code </li>
 *  <li> Test and verify the passengers name </li>
 *  <li> Test and verify all the passengers data </li>
 *  </ul>
 *  </p>
 *
 *  @since 20/12/22
 *  @version 1.0
 */

package Passengers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import es.ull.passengers.Passenger;
import es.ull.flights.Flight;


public class passengerstest {

    private Passenger kevin;
    private Passenger andres;

    @BeforeEach
    public void setup(){

        kevin = new Passenger("AA011", "kevin", "ES");
        andres = new Passenger("AA012", "andres", "ES");

    }

    //Test correcto
    @DisplayName("Passengers ID")
    @Test
    public void passengersid(){

        assertAll("Verifica ID de los pasajeros",() -> assertEquals("AA011",kevin.getIdentifier()), () -> assertEquals("AA012",andres.getIdentifier()));

    }

    //Test no correcto (fallido)
    /**
    @DisplayName("Passengers Country Code")
    @Test
    public void passengerscountrycode(){

        assertAll("Verifica Country Code de los pasajeros", () -> assertEquals("ES", kevin.getCountryCode()), () -> assertEquals("GER", andres.getCountryCode()));

    }
    **/

    //Test correcto
    @DisplayName("Verify all data")
    @Test
    public void alldata(){

        assertAll("Verifica todos los datos del pasajero kevin", () -> assertEquals("AA011", kevin.getIdentifier()), () -> assertEquals("kevin", kevin.getName()), () -> assertEquals("ES", kevin.getCountryCode()));

    }

    //Test no correcto (fallido)
    /**
    @DisplayName("Verify all data 2")
    @Test
    public void alldata2(){

        assertAll("Verifica todos los datos del pasajero andres", () -> assertEquals("AA012", andres.getIdentifier()), () -> assertEquals("Dagoberto", andres.getName()), () -> assertEquals("ES", andres.getCountryCode()));

    }
    **/

    //Test correcto
    @DisplayName("To String")
    @Test
    public void tostring(){

        assertEquals("Passenger kevin with identifier: AA011 from ES", kevin.toString());

    }


    //Test no correcto (fallido)
    /**
    @DisplayName("To string 2")
    @Test
    public void tostring2(){

        assertAll("Verifica todos los datos del pasajero kevin", () -> assertEquals("AA011", kevin.getIdentifier()), () -> assertEquals("kevin", kevin.getName()), () -> assertEquals("ES", kevin.getCountryCode()), () -> assertEquals("Passenger Dagoberto with identifier: AA013 from GER", kevin.toString()));

    }
    */

}
