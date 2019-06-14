package model;

import model.enums.Gender;
import model.enums.HotelLocation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HotelTest {
    private Hotel hotel;
    private List<HotelEmployee> employeeList;

    @Before
    public void setup() {
        hotel = new Hotel("Hilton", 4, HotelLocation.CLUJNAPOCA, 12);

        employeeList = new ArrayList<>();

        employeeList.add(new HotelEmployee("Mishu", "007", "1", "HR", Gender.MALE));

        hotel.setEmployees(employeeList);
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
    public void getHotelEmployeesTest() {
        assertThat(hotel.getHotelEmployees(), is(employeeList));
    }

    @Ignore
    public void setRoomsTest() {
    }


    @Ignore
    public void roomsAvailableTest() {
    }

    @Ignore
    public void getClientsTest() {
    }

    @Ignore
    public void setEmployeesTest() {
    }
}