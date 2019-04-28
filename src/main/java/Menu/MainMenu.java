package Menu;
/*
The hotel management app allows the used to add and remove a list of hotels,
add and list clients and employees to a hotel, find a hotel that has rooms available,
get the total costs of a room for a specific client.
 */


import Hotel.Hotel;
import People.Client;
import People.HotelEmployee;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {


    private static final Logger logger=Logger.getLogger(MainMenu.class.getName());
    public static void main(String[] args) {



        List<Hotel> hotels = new ArrayList<Hotel>();

        addHotels(hotels);

        removeHotels(hotels);

        listHotels(hotels);

        listClientsOfAHotel(hotels);

        listEmployeesOfAHotel(hotels);







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


                List<HotelEmployee> hotelEmployees = hotel.getHotelEmployees();

                /**
                 * We are going to loop through the list of HotelEmployees, print their names,
                 * hotel where they work, and their
                 * job title
                 **/

                for (HotelEmployee employee : hotelEmployees) {

                    logger.info("Name: " + employee.getPersonName() +
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

            System.out.println(hotel.getName() + " has " + hotel.getStars() + " stars, and is located in " + hotel.getLocation() + ".");

        }


    }



    private static void removeHotels(List<Hotel> hotels) {
        //Let's remove hotel Grand Hotel Pata Rat from our list

        String name = "Grand Hotel Pata Rat";

        for (int i = 0; i < hotels.size(); i++) {

            if (name.equals(hotels.get(i).getName())) {
                hotels.remove(hotels.get(i));
                System.out.println(hotels.get(i).getName() + " has been removed from the list of hotels.");
            }
        }
    }
}
