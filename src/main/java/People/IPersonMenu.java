package People;

import Hotel.Hotel;

import java.util.List;

public interface IPersonMenu {

    String getPersonName();

    String getId();

    void findHotelWherePersonIs(List<Hotel> hotels);

}
