package Menu;
/*
The hotel management app allows the used to add and remove a list of hotels,
add and list clients and employees to a hotel, find hotels that have available rooms,
get the total costs of a room for a particular client.
 */


import Enums.Gender;
import Enums.HotelLocation;
import Enums.RoomType;
import Hotel.Hotel;
import People.Client;
import People.HotelEmployee;
import People.PartTimeHotelEmployee;
import People.Person;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {


    private static final Logger logger = Logger.getLogger(MainMenu.class.getName());

    protected static Information information;

    public static void main(String[] args) throws Exception {
        /*
        The exception is handled in the client class for the method getTotalCosts for
        the case in which the users enters by mistake a negative number of nights.
         */

        BasicConfigurator.configure();

        List<Hotel> hotels = new ArrayList<Hotel>();


        addHotels(hotels);

        addEmployees(hotels);

        addClientsAndRooms(hotels);

        removeHotels(hotels);

        listHotels(hotels);

        listClientsOfAHotel(hotels);

        listEmployeesOfAHotel(hotels);

        information = new Information(hotels);
        information.findHotelRoom();

    }

    private static void addClientsAndRooms(List<Hotel> hotels) throws Exception {
        //Distinguish between clients with and without rented cars, and use the appropriate overloaded constructor
        //Adds three types of rooms and prices to each hotel.

        Client client1 = new Client("Marcel Proust", "111", "111111111");

        Room singleRoom1 = new Room(RoomType.SINGLE, 49.99);

        client1.bookARoom(client1, singleRoom1, 11);

        client1.isSatisfied(client1, true);

        client1.ratesHotel(client1, 4, hotels.get(0));

        client1.comments("\"Food was great.\"");

        Client client2 = new Client("Gustave Flaubert", "222", "222222");

        Room doubleRoom1 = new Room(RoomType.DOUBLE, 75.69);

        client2.bookARoom(client2, doubleRoom1, 2);


        Client client3 = new Client("Jules Verne", "333", "333333", "IF01FUN");

        Room tripleRoom1 = new Room(RoomType.TRIPLE, 99.99);

        client3.bookARoom(client3, tripleRoom1, 5);

        List<Client> clients1 = new ArrayList<Client>();
        clients1.add(client1);
        clients1.add(client2);
        clients1.add(client3);

        hotels.get(0).setClients(clients1);

        List<Room> rooms1 = new ArrayList<Room>();

        rooms1.add(singleRoom1);
        rooms1.add(doubleRoom1);
        rooms1.add(tripleRoom1);

        hotels.get(0).setRooms(rooms1);


        Client client21 = new Client("Charles Baudelaire", "001", "211111111");

        Room singleRoom2 = new Room(RoomType.SINGLE, 79.99);

        client21.bookARoom(client21, singleRoom1, 3);

        client21.isSatisfied(client21, false);

        client21.ratesHotel(client21, 2, hotels.get(1));

        client21.comments("\"Food was lousy!!!!\"");


        Client client22 = new Client("Arthur Rimbaud", "002", "322222");

        Room doubleRoom2 = new Room(RoomType.DOUBLE, 175.69);

        client22.bookARoom(client22, doubleRoom2, 7);

        Client client23 = new Client("Paul Verlaine", "003", "43333", "NT33ZEU");

        Room tripleRoom2 = new Room(RoomType.TRIPLE, 199.99);

        client23.bookARoom(client23, tripleRoom2, 1);

        List<Client> clients2 = new ArrayList<Client>();
        clients2.add(client21);
        clients2.add(client22);
        clients2.add(client23);

        hotels.get(1).setClients(clients2);

        //Add an additional non-booked room
        Room quadrupleRoom1 = new Room(RoomType.QUADRUPLE, 223);
        List<Room> rooms2 = new ArrayList<Room>();

        rooms2.add(singleRoom2);
        rooms2.add(doubleRoom2);
        rooms2.add(tripleRoom2);
        rooms2.add(quadrupleRoom1);

        hotels.get(1).setRooms(rooms2);


        Client client31 = new Client("Pierre Corneille", "010", "5444");

        Room singleRoom3 = new Room(RoomType.SINGLE, 249.99);

        client31.bookARoom(client31, singleRoom1, 10);

        Client client32 = new Client("Jean Racine", "020", "65555");

        Room doubleRoom3 = new Room(RoomType.DOUBLE, 375.69);

        client32.bookARoom(client23, doubleRoom3, 12);

        Client client33 = new Client("Molière", "030", "75555", "CJ69PSD");

        Room tripleRoom3 = new Room(RoomType.TRIPLE, 499.99);

        client33.bookARoom(client3, tripleRoom3, 12);

        client33.cancelBooking(client33);

        List<Client> clients3 = new ArrayList<Client>();
        clients3.add(client31);
        clients3.add(client32);
        clients3.add(client33);

        hotels.get(2).setClients(clients3);


        Room quadrupleRoom2 = new Room(RoomType.QUADRUPLE, 555);
        Room kingRoom1 = new Room(RoomType.KING, 679);

        List<Room> rooms3 = new ArrayList<Room>();

        rooms3.add(singleRoom3);
        rooms3.add(doubleRoom3);
        rooms3.add(tripleRoom3);
        rooms3.add(quadrupleRoom2);
        rooms3.add(kingRoom1);

        hotels.get(2).setRooms(rooms3);


    }


    private static void addHotels(List<Hotel> hotels) {


        //Create a list of hotels
        Hotel hotel1 = new Hotel("Dacia", 3, HotelLocation.SATUMARE, 3);

        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Grand Hotel Italia", 5, HotelLocation.CLUJNAPOCA, 4);

        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Continental", 4, HotelLocation.BUCURESTI, 5);

        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Grand Hotel Pata Rat", 0, HotelLocation.PATA, 1000);

        hotels.add(hotel4);
    }


    private static void listEmployeesOfAHotel(List<Hotel> hotels) {


        for (Hotel hotel : hotels) {

            logger.info(hotel.getName() + " has the following employees: ");

            List<HotelEmployee> hotelEmployees = hotel.getHotelEmployees();

            /**
             * We are going to loop through the list of HotelEmployees, print their names,
             * hotel where they work, and their
             * job title
             **/

            for (HotelEmployee employee : hotelEmployees) {

                logger.info(employee.getPersonName() +
                        " works for " + hotel.getName() +
                        " as a " + employee.getJobTitle() + ". " + employee.toString() +
                        ". Gender: " + employee.getGender() + "." + "\n");


                boolean isInstance = employee instanceof PartTimeHotelEmployee;

                // Example of casting and supresswarning annotation
                if (isInstance) {

                    @SuppressWarnings("checked cast")
                    PartTimeHotelEmployee partTimeHotelEmployee = (PartTimeHotelEmployee) employee;

                    logger.info(partTimeHotelEmployee.getPersonName() + " works part-time for a " +
                            "total of " + partTimeHotelEmployee.getNrOfWorkingHours()
                            + " hours/week");

                }
            }
        }
    }


    private static void listClientsOfAHotel(List<Hotel> hotels) {
        //Loop through the list of hotels and print out the names of the clients.

        for (Hotel hotel : hotels) {

            List<Client> clients = hotel.getClients();

            logger.info(hotel.getName() + " has the following clients: ");

            for (Client client : clients) {
                logger.info(client.getPersonName() + "\n" + client.toString() + "\n");

            }

        }

        logger.info("Check where Charles Baudelaire is staying:");
        Person person = new Person("Charles Baudelaire", "001");


        //the method has been deprecated and replaced with listClientsOfAHotel
        person.findHotelWherePersonIs(hotels);
    }


    private static void addEmployees(List<Hotel> hotels) throws Exception {


        HotelEmployee employee1 = new HotelEmployee("Radu Radulescu", "78645", "PN54254256JU", "cleaner", Gender.MALE);

        employee1.isSatisfied(employee1, true);

        //Added a satisfaction of 6 stars to test the custom validationexception class
        employee1.ratesHotel(employee1, 6, hotels.get(0));

        employee1.comments("\"I love cleaning toilets!\"");

        HotelEmployee employee2 = new HotelEmployee("Jean Ionescu", "68645", "joihwr74981754", "receptionist", Gender.MALE);

        employee2.isSatisfied(employee2, false);

        employee2.ratesHotel(employee2, 2, hotels.get(0));

        employee2.comments("\"Pay is not that good.\"");

        HotelEmployee employee3 = new PartTimeHotelEmployee("Paul Pavelescu", "111111", "trwtrw4315", "manager", Gender.MALE, (short) 20);

        List<HotelEmployee> employees = new ArrayList<HotelEmployee>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        hotels.get(0).setEmployees(employees);


        HotelEmployee employee21 = new HotelEmployee("Georgiana Georgescu", "58645", "yy098", "cleaner", Gender.FEMALE);
        HotelEmployee employee22 = new HotelEmployee("Vasilica Vasilescu", "48645", "u888", "receptionist", Gender.FEMALE);
        HotelEmployee employee23 = new PartTimeHotelEmployee("Alex Alexandrescu", "000007", "oop1234", "manager", Gender.MALE, (short) 10);

        List<HotelEmployee> employees2 = new ArrayList<HotelEmployee>();
        employees2.add(employee21);
        employees2.add(employee22);
        employees2.add(employee23);

        hotels.get(1).setEmployees(employees2);

        HotelEmployee employee31 = new HotelEmployee("Mihaela Mihailescu", "38645", "ohe312", "cleaner", Gender.FEMALE);
        HotelEmployee employee32 = new HotelEmployee("Ioana Ionescu", "38645", "triuwh909", "receptionist", Gender.FEMALE);
        HotelEmployee employee33 = new PartTimeHotelEmployee("Dan Danielescu", "111111", "uu1", "manager", Gender.MALE, (short) 30);

        List<HotelEmployee> employees3 = new ArrayList<HotelEmployee>();
        employees3.add(employee31);
        employees3.add(employee32);
        employees3.add(employee33);

        hotels.get(2).setEmployees(employees3);

    }


    private static void listHotels(List<Hotel> hotels) {
        if (hotels == null) {
            logger.info("The list of hotels is empty");
            throw new NullPointerException();
        }

        for (Hotel hotel : hotels) {
            /**
             *  Get each hotel's name, location, and number of stars.
             *  Print the information
             */

            logger.info(hotel.getName() + " has " + hotel.getStars() + " stars, and is located in " + hotel.getLocation() + ".");

        }


    }


    private static void removeHotels(List<Hotel> hotels) {
        //Removes hotel Grand Hotel Pata Rat from the list of hotels

        String name = "Grand Hotel Pata Rat";

        for (int i = 0; i < hotels.size(); i++) {

            if (name.equals(hotels.get(i).getName())) {

                logger.info(hotels.get(i).getName() +
                        " situated in " + hotels.get(i).getLocation() +
                        " has been removed from the list of hotels.");
                hotels.remove(hotels.get(i));
            }
        }
    }
}
