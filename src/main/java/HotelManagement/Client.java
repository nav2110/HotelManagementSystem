package HotelManagement;



public class Client implements iBooking{


    private String name;


    private String creditCard;

    private double clientPayments=0;


    public Client(String name, String creditCard) {
        this.name = name;
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void cancelBooking() {

        System.out.println("Room was cancelled");
        clientPayments=0;
    }



    public double payRoom(double roomCost, int nights) {
        return clientPayments+=(roomCost*(double)nights);
    }





}
