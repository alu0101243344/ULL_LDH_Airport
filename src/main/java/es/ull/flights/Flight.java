/**
 * <p>
 *  This class is used to view the necessary elements of a flight.
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Get the flight number of a flight </li>
 *  <li> Get the passenger number of a passenger </li>
 *  <li> Get the number of seats a flight </li>
 *  <li> Add passengers to a flight </li>
 *  <li> Remove passengers of a flight </li>
 *  </ul>
 *  </p>
 *
 *  @since 20/12/22
 *  @version 1.0
 */

package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

public class Flight {

    private String flightNumber;
    private int seats;
    private Set<Passenger> passengers = new HashSet<>();

    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     *
     * @param flightNumber is a string variable representing the flight number of the flight.
     * @param seats is a integer variable representing the number of seats of the flight.
     */

    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     *
     * @return String - Flight number of the flight
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     *
     * @return Int - Number of the passenger
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     *
     * @return Int - Number of seats
     */
    public int getSeats() {return seats; }

    /**
     *
     * @param passenger is a variable representing a passenger of the flight
     * @return Boolean - True if there are enough seats to add passenger - False otherwise
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     *
     * @param passenger is a variable representing a passenger of the flight
     * @return Boolean - True if the passenger is set on a flight - False otherwise
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}
