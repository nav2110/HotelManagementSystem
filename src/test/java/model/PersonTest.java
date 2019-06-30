package model;

import model.enums.HotelLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person person;
    private List<Hotel> hotels = new ArrayList<>();

    // private static final Logger logger= LogManager.getLogger(PersonTest.class);

    private List<Client> clients = new ArrayList<Client>();
    private Client client;
    private Hotel hotel;

    @Before
    public void setup() {


        person = new Person("Alex", "786165");

        hotel = new Hotel.Builder().name("Hilton").stars(4).location(HotelLocation.CLUJNAPOCA)
                .capacity(12).build();


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
    public void findHotelWherePersonIsTest() {
        client.findHotelWherePersonIs(hotels);
        assertEquals("Hilton", hotel.getName());
    }

    @Test
    public void getPersonNameTest() {

        String name = person.getPersonName();
        assertEquals("Alex", name);
    }

    @Ignore
    public void isSatisfiedTest() {
        person.isSatisfied(person, false);

    }

    @Test
    public void commentsTest() {
        String comments = person.comments("Me love");
        Assert.assertNotNull(comments);
    }

    @Ignore
    public void ratesHotelTest() {
        person.ratesHotel(person, 6, hotel);

    }


}