package service;

import model.Client;
import model.Hotel;
import model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class ClientsService {

    public static final Logger logger = LogManager.getLogger(ClientsService.class);


    public static void listClientsOfAHotel(List<Hotel> hotels) {
        //Loop through the list of hotels and print out the names of the clients.

        for (Hotel hotel : hotels) {

            List<Client> clients = hotel.getClients();

            if (clients.size() == 0) logger.info(hotel.getName() + " has no clients.");

            else {


                logger.info(hotel.getName() + " has the following clients: ");

                for (Client client : clients) {
                    logger.info(client.getPersonName() + "\n" + client.toString() + "\n");

                }

            }


        }

        logger.info("Check where Charles Baudelaire is staying:");
        Person person = new Person("Charles Baudelaire", "001");


        //the method has been deprecated and replaced with listClientsOfAHotel
        person.findHotelWherePersonIs(hotels);
    }
}