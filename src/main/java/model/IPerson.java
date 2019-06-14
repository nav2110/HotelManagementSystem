package model;

import java.util.List;

public interface IPerson {


    String getPersonName();

    String toString();

    void findHotelWherePersonIs(List<Hotel> hotels);

}
