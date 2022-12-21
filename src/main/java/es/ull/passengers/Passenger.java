/**
 * <p>
 *  This class is used to view the necessary data of the passengers.
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Get the ID of the passengers </li>
 *  <li> Get the name of the passengers </li>
 *  <li> Get the country code of the passengers </li>
 *  <li> Get the flight of the passenger </li>
 *  <li> Let the passenger join a flight </li>
 *  <li> Let the passenger set a flight </li>
 *  </ul>
 *  </p>
 *
 *  @since 20/12/22
 *  @version 1.0
 */

package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;

import es.ull.flights.Flight;

public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    /**
     *
     * @param identifier is a String variable representing the ID of the passenger
     * @param name is a String variable representing the name of the passenger
     * @param countryCode is a String variable representing the country code of the passenger
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     *
     * @return String - ID of the passenger
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return String - Name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return String - Country code of the passenger
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @return Flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     *
     * @param flight is a variable representing the flight of the passenger
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     *
     * @param flight is a variable representing the flight of the passenger
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     *
     * @return String - A string to verify the data of the passenger
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
