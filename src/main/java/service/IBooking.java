package service;

import model.Client;
import model.Room;

/**
 *
 */
public interface IBooking {

    void bookARoom(Client client, Room room, int nights);

    void cancelBooking(Client client);

    double getTotalCosts(Room room, int nights);

}
