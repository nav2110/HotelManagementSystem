package repository;
/*
The hotel management app adds and removes a list of hotels,
add and list clients and employees to a hotel, find hotels that have available rooms,
get the total costs of a room for a particular client.
 */


import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.*;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {

    private static Logger logger = LogManager.getLogger(MainMenu.class);



    public static void main(String[] args) throws Exception {
        /*
        The exception is handled in the client class (model package)
        for the method getTotalCosts for
        the case in which the users enters by mistake a negative number of nights.
         */

        logger.debug("Test for log4j");

        //Creating a list of hotels that will be passed to all the static methods in the service repository,
        List<Hotel> hotels = new ArrayList<>();

        //Adding hotels to the hotel list
        AddHotels.addHotels(hotels);


        AddEmployees.addEmployees(hotels);


        AddClients.addClientsAndRooms(hotels);

        removeHotels(hotels);

        HotelService.listHotels(hotels);

        ClientsService.listClientsOfAHotel(hotels);

        EmployeeService.listEmployeesOfAHotel(hotels);

        Information information = new Information(hotels);
        information.findHotelRoom();

        IOExamples.readAndWriteFile();

        IOExamples.tryWithResources();

        IOExamples.writeAndReadHotelObject(hotels);


    }


    protected static void removeHotels(List<Hotel> hotels) {
        //Removes hotel Grand model Pata Rat from the list of hotels

        String name = "Grand model Pata Rat";

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
