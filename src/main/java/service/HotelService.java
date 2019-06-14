package service;

import model.Hotel;

import java.util.List;

public class HotelService {

    public static void listHotels(List<Hotel> hotels) {
        if (hotels == null) {
            EmployeeService.logger.info("The list of hotels is empty");
            throw new NullPointerException();
        }

        for (Hotel hotel : hotels) {
            /**
             *  Get each hotel's name, location, and number of stars.
             *  Print the information
             */

            EmployeeService.logger.info(hotel.getName() + " has " + hotel.getStars() + " stars, and is located in " + hotel.getLocation() + ".");

        }


    }
}