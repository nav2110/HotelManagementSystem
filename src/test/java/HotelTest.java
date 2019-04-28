import Hotel.Hotel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;

//    @Before
//    public void setup(){
//        hotel=new Hotel("Alex", (short) 4, "cj", 555, true);
//
//    }

    @Test
    public void getHotelNameTest(){


        assertEquals("Alex", hotel.getName());

    }

    @Test
    public void getHotelStarsTest(){


        assertEquals(4, hotel.getStars());

    }

    @Test
    public void getHotelLocationTest(){

        assertEquals("cj", hotel.getLocation());

    }

    @Test
    public void getHotelCapacityTest(){

        assertEquals(555, hotel.getCapacity());

    }

    @Test
    public void checkIfHotelHasPoolTest(){

        assertEquals(true, hotel.isPool());

    }
}
