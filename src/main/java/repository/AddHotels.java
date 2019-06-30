package repository;

import model.Hotel;
import model.enums.HotelLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class AddHotels {
    private static Logger logger = LogManager.getLogger(AddHotels.class);

    //Use of Generic wildcard
    static void addHotels(List<Hotel> hotels) {


        //Create a list of hotels using the Builder pattern
        //Comment out old constructor Hotel hotel1 = new Hotel("Dacia", 3, HotelLocation.SATUMARE, 3);
        Hotel hotel1 = new Hotel.Builder().name("Dacia").stars(5).
                location(HotelLocation.CLUJNAPOCA).capacity(4).build();

        hotels.add(hotel1);


        Hotel hotel2 = new Hotel.Builder().name("Grand Hodel Italia").stars(5)
                .capacity(4).location(HotelLocation.CLUJNAPOCA).build();

        Hotel hotel3 = new Hotel.Builder().name("Continental").stars(4)
                .capacity(5).location(HotelLocation.BUCURESTI).build();

        //Hotel hotel3 = new Hotel("Continental", 4, HotelLocation.BUCURESTI, 5);

        hotels.add(hotel3);

        Hotel hotel4 = new Hotel.Builder()
                .name("Grand Hodel Pata Rat")
                .stars(0)
                .location(HotelLocation.PATA)
                .build();
        //Hotel hotel4 = new Hotel("Grand Hodel Pata Rat", 0, HotelLocation.PATA, 1000);

        hotels.add(hotel4);
    }

}

