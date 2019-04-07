package HotelManagement;
//HotelManagement Management App
//        HotelManagement Management App
//
//
//
//        a) Concepts to be traced / purpose of the assignment
//
//
//
//
//b) Short description
//
//        - Scoala-Informala HotelManagement is a service that assists ​hotel owners​
//        in managing their business and also helps ​clients​ interact with
//        the hotel in an easy and efficient way.
//
//        d) Requests
//
//        - correct package structure
//
//        - objects that define real life elements (hotel, room, guest / staff)
//
//        - appropriate fields (of most types primitives / wrapper) for each object (or other cases)
//
//        - a well-defined interface / abstract for any of the presented objects' life-cycles
//
//        - overload any method with proper usages
//
//        - encapsulate fields
//
//        - inheritance between at least 2 objects with this / super call
//
//        - composition at least 1 example
//
//        - static (fields / methods) definition in any cases
//
//        - final for at least one field, method or class with explanations
//
//- Javadoc
//
//
//
//        What needs to be done by Thursday (04/04/2019) midnight
//
//        - main package
//
//        - separate packages / class (hotel / room, etc...)
//
//        - HotelManagement, Room, Client, Employee, Owner (minimum of 3 fields)
//
//        - 1 example of inheritance / composition
//
//        - at least one unmodifiable variable
//
//        - constructors (with this and super)
//
//
//
//        What needs to be done by Tuesday (09/04/2019) midnight
//
//        - use at least 2 static elements (field / method / class) - ex: constants
//
//        - all important variables should be private (don't leave unused methods)
//
//        - create an interface / abstract class for a scenario you consider (with 3 methods at least)
//
//        - overload at least 1 constructor
//
//        - implement those methods (override) so that it has purpose
//
//        - create a main method, print some stuff out (hotel / room / at least one type of Person), override toString() from Object
//
//        - use at least 1 collection and 1 array (that makes sense)


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static Scanner scanner=new Scanner(System.in);
    private static int option;

    public static void main(String[] args) {
        List<Hotel> hotels = new ArrayList<Hotel>();

        //Define a printAndReadMenu to get input from the user
        printAndReadMenuOption();

        //Create a main menu where the user can call methods to add, remove, list hotels, add Clients and quit the menu.
        do {
            switch (option) {
                case 1:

                    addHotels(hotels);


                    break;

                case 2:
                    removeHotels(hotels);

                    break;

                case 3:
                    listHotels(hotels);

                    break;

                case 4:listClientsOfAHotel(hotels);
                
                    break;
                    
                case 5:checkHotelsForRoom(hotels);
                break;

                default:
                    printAndReadMenuOption();
                    break;
            }

        } while (option != 0);

    }
    //Creating the rooms for hotels
    private static void addRoomsToAHotel(List<Hotel> hotels) {

        System.out.println("Name of hotel you want to add a room to:");
        String name=scanner.nextLine();

        System.out.println("Location of the hotel you want to add a room to:");
        String location=scanner.nextLine();

        for (Hotel hotel: hotels){
            if(location.equals(hotel.getLocation()) && name.equals(hotel.getName())) {
                hotel.addRooms();
            }
        }

            printAndReadMenuOption();


    }

    /*
    Check which hotels are available.
    Choose a hotel and book a room.
     */
    private static void checkHotelsForRoom(List<Hotel> hotels) {
        for(Hotel hotel :hotels){
            if(hotel.isAvailabe()){
                System.out.println(hotel.getName()+" in "+hotel.getLocation()+"has "+hotel.roomsAvailable()+" availble.");
            } else{
                System.out.println(hotel.getName()+" in "+hotel.getLocation()+" is fully booked");
            }
        }

        if(hotels!=null){

            System.out.println("Would you like to book a room or cancel a reservation? Press 1 for booking, 2" +
                    "for canceling a reservation or 0 to return to the main menu");
            short choice=scanner.nextShort();
            scanner.nextLine();

            //Booking and Cacenlation menu
            while(choice!=0){

                if(choice==1){
                    System.out.println("Name of hotel you want to book a room: ");
                    String nameOfHotel=scanner.nextLine();

                    System.out.println("Location of hotel you want to book a room: ");
                    String locationOfHotel=scanner.nextLine();

                    for(Hotel hotel: hotels){
                        if(nameOfHotel.equals(hotel.getName())&&locationOfHotel.equals(hotel.getLocation())&&hotel.isAvailabe()){
                      hotel.addClients();
                    }

                    }

                }


                System.out.println("Would you like to continue booking?"+
                        "Press 1 for YES or 0 to return to the main menu");
                choice=scanner.nextShort();
                scanner.nextLine();
            }


        }

        printAndReadMenuOption();

    }

    private static void listClientsOfAHotel(List<Hotel> hotels) {
        System.out.println("What is the name of the hotel whose clients you wish to lists?");
        String nameOfHotel=scanner.nextLine();

        System.out.println("What is the location of the hotel whose clients you wish to list? ");
        String locationOfHotel=scanner.nextLine();

        for(Hotel hotel : hotels){

            if(nameOfHotel.equals(hotel.getName())&&locationOfHotel.equals(hotel.getLocation())){

                List<Client> hotelClients=new ArrayList<Client>();

               hotelClients=hotel.getClients();

                /**
                 * We are going to loop through the list of clients, print their names and the last
                 * four digits of their credit card
                 */
               for(Client client: hotelClients){
                   String credit=client.getCreditCard();


                   System.out.println("Name: "+client.getName()+
                           ". Last three digits of their credit card: "+
                           +credit.charAt(credit.length()-3)+
                           credit.charAt(credit.length()-2)+
                           credit.charAt(credit.length()-1));
               }
            }
        }
        printAndReadMenuOption();
    }

    private static void addClientsToAHotel(List<Hotel> hotels) {

        System.out.println("What is the name of the hotel you wish to book your room? ");
        String nameOfHotel=scanner.nextLine();

        System.out.println("What is the location of the hotel you wish to book a room? ");
        String locationOfHotel=scanner.nextLine();

        for(Hotel hotel : hotels){

            if(locationOfHotel.equals(hotel.getLocation())&&nameOfHotel.equals(hotel.getName())){
                int choice=1;
                do {
                    hotel.addClients();
                    System.out.println("Press \"1\" to continue adding clients or \"0\" " +
                            "to return to main menu.");
                    choice=scanner.nextInt();
                    scanner.nextLine();
                } while(choice!=0);
            }

        }
        printAndReadMenuOption();
    }

    private static void printAndReadMenuOption() {

        System.out.println("Introduce \"1\" to add hotels, \"2\" to remove hotels, " +
                "\"3\" to list the hotels,\"4\" to add a client to the hotel, " +
                "\"5\" to list the clients of a hotel \"0\" to quit.");
        option = scanner.nextInt();
        scanner.nextLine();



    }


    private static void listHotels(List<Hotel> hotels) {
        if (hotels.size() == 0) {
            System.out.println("There are no hotels in the list.");
        }

        for (Hotel hotel : hotels) {
            /**
             *  get each hotel's name, location, and number of stars.
             *  Check whether there is a pool
             *  Print the info
             */

            System.out.println(hotel.getName()+" has "+hotel.getStars()+" stars, and is located at "+hotel.getLocation()+".");
            if(hotel.isPool()){
                System.out.println(hotel.getName()+" has a pool.");
            } else{
                System.out.println(hotel.getName()+" does not have a pool.");
            }
        }
        printAndReadMenuOption();

    }

    private static void addHotels(List<Hotel> hotels) {
        //initialize the common fields of any object
        System.out.println("Name of the hotel you want to add ");
        String   name=scanner.nextLine();

        System.out.println("Number of stars of the hotel you want to add ");

        short stars=scanner.nextShort();
        scanner.nextLine();

        System.out.println("Address ");
        String   location=scanner.nextLine();

        System.out.println("Total room capacity ");
        int capacity=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Is the hotel equipped with a pool (true or false)? ");
        boolean pool=scanner.nextBoolean();

        hotels.add(new Hotel(name, stars, location, capacity, pool));



        printAndReadMenuOption();

    }

    private static void removeHotels(List<Hotel> hotels) {
        System.out.println("What is the name of the hotel you want to remove? ");
        String name = scanner.nextLine();

        System.out.println("What is the location of the hotel you want to remove? ");
        String location = scanner.nextLine();

        for (int i=0; i<hotels.size();i++) {

            if (name.equals(hotels.get(i).getName())&&location.equals(hotels.get(i).getLocation())){
                hotels.remove(hotels.get(i));
            }
        }
        printAndReadMenuOption();
    }
}
