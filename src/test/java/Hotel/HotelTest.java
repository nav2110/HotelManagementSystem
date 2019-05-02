package Hotel;

import Enums.HotelLocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setup() {
        hotel = new Hotel("Hilton", 4, HotelLocation.CLUJNAPOCA, 12);

    }

    @Test
    public void getNameTest() {

        String expected = "Hilton";
        String actual = hotel.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getStarsTest() {

        int expected = 4;
        int actual = hotel.getStars();

        assertEquals(expected, actual);


    }

    @Test
    public void getLocationTest() {
        String expected = "Cluj-Napoca" +
                ", zip code: " +
                "400483" +
                ", phone Number: " +
                "0364 111 333";
        String actual = hotel.getLocation();

        assertEquals(expected, actual);
    }

    @Test
    public void setRoomsTest() {
    }

    @Test
    public void getHotelEmployeesTest() {
    }

    @Test
    public void roomsAvailableTest() {
    }

    @Test
    public void getClientsTest() {
    }

    @Test
    public void setEmployeesTest() {
    }
}