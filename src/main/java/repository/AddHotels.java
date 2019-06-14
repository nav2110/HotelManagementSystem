package repository;

import model.Hotel;
import model.enums.HotelLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class AddHotels {
    private static Logger logger = LogManager.getLogger(AddHotels.class);

    static void addHotels(List<Hotel> hotels) {


        //Create a list of hotels
        Hotel hotel1 = new Hotel("Dacia", 3, HotelLocation.SATUMARE, 3);

        hotels.add(hotel1);


        Hotel hotel2 = new Hotel("Grand Hodel Italia", 5, HotelLocation.CLUJNAPOCA, 4);

        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Continental", 4, HotelLocation.BUCURESTI, 5);

        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Grand Hodel Pata Rat", 0, HotelLocation.PATA, 1000);

        hotels.add(hotel4);
    }

}

