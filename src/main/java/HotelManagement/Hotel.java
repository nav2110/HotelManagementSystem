package HotelManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private String name;

    private short stars;

    private final String location;

    private final int capacity;

    private boolean pool;

    private List<Client> clients = new ArrayList<Client>();

    private List<Room> rooms=new ArrayList<Room>();

    private Scanner scanner = new Scanner(System.in);


    public Hotel(String name, short stars, String location, int capacity, boolean pool) {
        this.name = name;
        this.stars = stars;
        this.capacity = capacity;
        this.location = location;
        this.pool = pool;
    }

    public String getName() {
        return name;
    }

    public short getStars() {
        return stars;
    }

    public String getLocation() {
        return location;
    }


    public boolean isPool() {
        return pool;
    }


    public void addClients() {

        System.out.println("Name of client: ");
        String name = scanner.nextLine();

        System.out.println("Credit Card no");
        String creditCardNo = scanner.nextLine();

        Client client=new Client(name, creditCardNo);

        System.out.println("What type of room would you like to book (single, double, triple)?");
        String type=scanner.nextLine();

        System.out.println("How many nights will you be staying?");
        int nights=scanner.nextInt();

        //To shorthen he exercice, let's hardcode three prices.
        double total;
        if(type.equals("single")){
           total=client.payRoom(50,nights);
        }else if (type.equals("double")){
              total=client.payRoom(80,nights);
        }else {
            total=client.payRoom(120, nights);
        }

        System.out.println("Your total is "+total);
    }

    public void removeClients(){
        System.out.println("Name of the client you wish to remove from the list");
        String clientsName=scanner.nextLine();

        System.out.println(clientsName+"Credit card number:");
        String creditCardNo = scanner.nextLine();

        for (Client client:clients){

            if(client.getName()==clientsName&&client.getCreditCard()==creditCardNo){
                clients.remove(client);
                System.out.println(clientsName+" has been successfully removed.");
            }
        }
    }

    public boolean isAvailabe(){
        if(roomsAvailable()>0){
            return true;
        }  else {
            return false;
        }

    }
    public int roomsAvailable() {


        return capacity - clients.size();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addRooms() {
         short choice;
        do {
            System.out.println("Type of the room you (\"single\", \"double\", or \"triple\")");
            String type = scanner.nextLine();

            System.out.println("Price of the " + type + " room");
            double price = scanner.nextDouble();
            scanner.nextDouble();

            rooms.add(new Room(type, price));
            System.out.println("To continue adding rooms press 1. Otherwise press 0.");

            choice=scanner.nextShort();
        } while (choice!=0);
    }
}