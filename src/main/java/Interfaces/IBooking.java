package Interfaces;

import Menu.Room;
import People.Client;

/**
 *
 */
public interface IBooking {

    void bookARoom(Client client, Room room, int nights);

    void cancelBooking(Client client);

    double getTotalCosts(Room room, int nights);

}
