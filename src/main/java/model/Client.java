package model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.IBooking;
import service.OverloadConstructor;

import java.util.Objects;


public class Client extends Person implements IBooking {

    private static final Logger logger = LogManager.getLogger(Client.class);

    private String creditCard;

    private double costs = 0;

    private String plateNumber;


    public Client(String name, String id, String creditCard) {
        super(name, id);
        this.creditCard = creditCard;
    }

    /*
    Constructor overload for clients who rent cars and incur
    additional costs. Create custom annotation
     */
    @OverloadConstructor
    public Client(String name, String id, String creditCard, String plateNumber) {
        super(name, id);
        this.creditCard = creditCard;
        this.plateNumber = plateNumber;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void cancelBooking(Client client) {

        logger.debug(client.getPersonName() + " has cancelled the booking.");
        costs = 0;
    }


    public void bookARoom(Client client, Room room, int nights) {

        logger.debug(client.getPersonName() + " has booked a " + room.getType() +
                " room at the price of "
                + room.getPrice() + " per night.");

        logger.debug("The total costs for " + nights + " nights is " + client.getTotalCosts(room, nights) + ".");

    }


    public double getTotalCosts(Room room, int nights) {

        //Throw an exception in case the user enters a negative number of nights

        if (nights < 0) throw new IllegalArgumentException("Client cannot have a negative number of nights.");
        else {
            double price = (double) room.getPrice();
            costs = price * nights;

                /*
                If the client did not rent a car then the plateNumber should be null.
                Otherwise add the cost to total.
                Let's set the price of a car/day at 39.99$
                */
            if (plateNumber != null) {


                double priceOfRentedCar = 39.99;

                costs *= priceOfRentedCar * (double) nights;
            }

        }
        return costs;
    }


    //Override the method from the Person class for the last four digits of the creditcard
    @Override
    public String toString() {
        String lastFourDigits = "";

        if (creditCard.length() > 4) {
            lastFourDigits = creditCard.substring(creditCard.length() - 4);
        } else {
            lastFourDigits = creditCard;
        }
        return "Last four digits of the credit card= " + lastFourDigits;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return creditCard.equals(client.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCard);
    }


}
