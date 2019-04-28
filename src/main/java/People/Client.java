package People;


import Hotel.Room;
import Hotel.iBooking;

public class Client extends Person implements iBooking {


    private String creditCard;

    private double costs = 0;

    private String plateNumber;

    public Client(String name, String id, String creditCard) {
        super(name, id);
        this.creditCard = creditCard;
    }

    public Client(String name, String id, String creditCard, String plateNumber) {
        super(name, id);
        this.creditCard = creditCard;
        this.plateNumber = plateNumber;
    }


    public String getCreditCard() {
        return creditCard;
    }

    public void cancelBooking() {

        System.out.println("Room was cancelled");
        costs = 0;
    }


    public void calculateCosts(Room room, int nights) {

        double roomCost=room.getPrice();


                /*
                If the client did not rent a car then the plateNumber should be null.
                Otherwise add the cost to total.
                Let's set the price of a car/day at 39.99$
                */
        if (plateNumber != null) {


            double priceOfRentedCar = 39.99;

            costs += (roomCost * priceOfRentedCar * (double) nights);
        }

        costs += (roomCost * (double) nights);
    }

    public double getTotalCosts() {
        return costs;
    }

    public boolean rentACar() {

        return true;
    }


}
