package service;

import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/*
The class, constructor and method have default modifiers
 */
public class Information {
    private static final Logger logger = LogManager.getLogger(Information.class);

    private List<Hotel> hotels;

    public Information(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public void findHotelRoom() {


        for (Hotel hotel : hotels) {

            int nrOfAvailableRooms = hotel.roomsAvailable();

            logger.debug("Number of available rooms at " + hotel.getName() + " is " + nrOfAvailableRooms + ".");


        }


    }


}
