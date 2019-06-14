package model;

import model.enums.RoomType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class RoomTest {

    private Room room;


    @Before
    public void setup() {
        room = new Room(RoomType.TRIPLE, 22.22);
    }

    @Test
    public void getType() {

        assertNotNull(room.getType());

    }

    @Test
    public void getPrice() {
        double actual = (double) room.getPrice();
        assertEquals(22.22, actual);
    }
}