package People;

import Enums.HotelLocation;
import Hotel.Hotel;
import org.apache.log4j.varia.NullAppender;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person person;
    private List<Hotel> hotels = new ArrayList<Hotel>();
    ;
    private List<Client> clients = new ArrayList<Client>();
    private Client client;
    private Hotel hotel;

    @Before
    public void setup() {
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        person = new Person("Alex", "786165");

        hotel = new Hotel("Hilton", 5, HotelLocation.BUCURESTI, 12);

        client = new Client("Gigi", "11111", "222222");

        clients.add(client);

        hotel.setClients(clients);

        hotels.add(hotel);


    }

    @Test
    public void toStringTest() {
        String lastFourDigits = person.toString();
        assertEquals("Last four digits of credit card or employee number: 6165", lastFourDigits);
    }

    @Test
    public void getNumberTest() {

        String number = person.getNumber();
        assertEquals("786165", number);

    }

    @Test
    public void findHotelWherePersonIs() {
        client.findHotelWherePersonIs(hotels);
    }

    @Test
    public void getPersonNameTest() {

        String name = person.getPersonName();
        assertEquals("Alex", name);
    }

    @Test
    public void isSatisfied() {
        person.isSatisfied(person, false);
    }

    @Test
    public void commentsTest() {
        person.comments("Me love");
    }

    @Test
    public void ratesHotel() {
        person.ratesHotel(person, 3, hotel);
    }


}