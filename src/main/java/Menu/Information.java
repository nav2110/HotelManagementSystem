package Menu;

import Hotel.Hotel;
import org.apache.log4j.Logger;

import java.util.List;

/*
The class, constructor and method have default modifiers
 */
class Information {
    private static final Logger logger = Logger.getLogger(Information.class.getName());

    private List<Hotel> hotels;

    Information(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    void findHotelRoom() {


        for (Hotel hotel : hotels) {

            int nrOfAvailbleRooms = hotel.roomsAvailable();

            logger.debug("Number of available rooms at " + hotel.getName() + " is " + nrOfAvailbleRooms + ".");


        }


    }


}
