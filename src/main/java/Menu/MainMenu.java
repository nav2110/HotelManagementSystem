package Menu;
/*
The hotel management app allows the used to add and remove a list of hotels,
add and list clients and employees to a hotel, find a hotel that has rooms available,
get the total costs of a room for a specific client.
 */


import Hotel.Hotel;
import People.Client;
import People.HotelEmployee;
import People.PartTimeHotelEmployee;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {


    private static final Logger logger=Logger.getLogger(MainMenu.class.getName());
    public static void main(String[] args) {

        BasicConfigurator.configure();

        List<Hotel> hotels = new ArrayList<Hotel>();

        addHotels(hotels);

        addEmployees(hotels);

        addClients(hotels);

        addRooms(hotels);

        removeHotels(hotels);

        listHotels(hotels);

        listClientsOfAHotel(hotels);

        listEmployeesOfAHotel(hotels);

    }

    private static void addRooms(List<Hotel> hotels) {
    List<Room> rooms=new Room();
    }

    private static void addClients(List<Hotel> hotels) {

        //Distinguish between clients with and without rented cars, and use the appropriate overloaded constructor
        Client client1= new Client("Marcel Proust", "111", "111111111");
        Client client2 = new Client("Gustave Flaubert", "222", "222222");
        Client client3 = new Client("Jules Verne", "333", "333333", "IF01FUN");

        List<Client> clients1 = new ArrayList<Client>();
        clients1.add(client1);
        clients1.add(client2);
        clients1.add(client3);

        hotels.get(0).setClients(clients1);


        Client client21= new Client("Charles Baudelaire", "001", "211111111");
        Client client22 = new Client("Arthur Rimbaud", "002", "322222");
        Client client23 = new Client("Paul Verlaine", "003", "43333", "NT33ZEU");

        List<Client> clients2 = new ArrayList<Client>();
        clients2.add(client21);
        clients2.add(client22);
        clients2.add(client23);

        hotels.get(1).setClients(clients2);

        Client client31 = new Client("Pierre Corneille", "010", "5444");
        Client client32 = new Client("Jean Racine", "020", "65555");
        Client client33 = new Client("Molière", "030", "75555", "CJ69PSD");

        List<Client> clients3 = new ArrayList<Client>();
        clients3.add(client31);
        clients3.add(client32);
        clients3.add(client33);

        hotels.get(2).setClients(clients3);
    }

    private static void addHotels(List<Hotel> hotels) {


        //Create a list of hotels
          Hotel hotel1 = new Hotel("Dacia", 3, "Satu Mare", 245);

        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Grand Hotel Italia", 5, "Cluj Napoca", 333);

        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Continental", 4, "Bucuresti", 1000);

        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Grand Hotel Pata Rat", 0, "Pata", 1000);

        hotels.add(hotel4);
    }


    private static void listEmployeesOfAHotel(List<Hotel> hotels) {


        for (Hotel hotel : hotels) {

                logger.info(hotel.getName()+" has the following employees: ");

                List<HotelEmployee> hotelEmployees = hotel.getHotelEmployees();

                /**
                 * We are going to loop through the list of HotelEmployees, print their names,
                 * hotel where they work, and their
                 * job title
                 **/

                for (HotelEmployee employee : hotelEmployees) {

                    logger.info(employee.getPersonName() +
                            " works for " + hotel.getName() +
                            " as a " + employee.getJobTitle());


                }
            }
        }






    private static void listClientsOfAHotel(List<Hotel> hotels) {
        //Loop through the list of hotels and print out the names of the clients.

        for (Hotel hotel : hotels) {

            List<Client> clients=hotel.getClients();

           logger.info (hotel.getName()+ " has the following clients: ");

            for(Client client: clients){
                logger.info(client.getPersonName()+"\n");
            }

        }
    }


    private static void addEmployees(List<Hotel> hotels){


                HotelEmployee employee1 = new HotelEmployee("Radu Radulescu", "78645", "cleaner");
                HotelEmployee employee2 = new HotelEmployee("Jean Ionescu", "68645", "receptionist");
                HotelEmployee employee3 = new PartTimeHotelEmployee("Paul Pavelescu", "1", "manager", (short) 20);

                List<HotelEmployee> employees = new ArrayList<HotelEmployee>();
                employees.add(employee1);
                employees.add(employee2);
                employees.add(employee3);

                hotels.get(0).setEmployees(employees);


                HotelEmployee employee21 = new HotelEmployee("George Georgescu", "58645", "cleaner");
                HotelEmployee employee22 = new HotelEmployee("Vasile Vasilescu", "48645", "receptionist");
                HotelEmployee employee23 = new PartTimeHotelEmployee("Paul Pavelescu", "007", "manager", (short) 10);

                List<HotelEmployee> employees2 = new ArrayList<HotelEmployee>();
                employees2.add(employee21);
                employees2.add(employee22);
                employees2.add(employee23);

                hotels.get(1).setEmployees(employees2);

                HotelEmployee employee31 = new HotelEmployee("Mihai Mihailescu", "38645", "cleaner");
                HotelEmployee employee32 = new HotelEmployee("Jean Ionescu", "38645", "receptionist");
                HotelEmployee employee33 = new PartTimeHotelEmployee("Paul Pavelescu", "111", "manager", (short) 30);

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
        //Let's remove hotel Grand Hotel Pata Rat from our list

        String name = "Grand Hotel Pata Rat";

        for (int i = 0; i < hotels.size(); i++) {

            if (name.equals(hotels.get(i).getName())) {

                logger.info(hotels.get(i).getName() + " has been removed from the list of hotels.");
                hotels.remove(hotels.get(i));
            }
        }
    }
}
