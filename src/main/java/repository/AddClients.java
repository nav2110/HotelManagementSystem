package repository;

import model.Client;
import model.Hotel;
import model.Room;
import model.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

/**
 * The static method populates hotels with clients. It contains a method for adding the clients
 * and assigning them rooms.
 * Static class for Adding employees to a hotel with their name, id, employe nr, job title, gender.
 * Multiply inherited methods for satisfaction, rating, and comments.
 */
public class AddClients {

    //Use of generic wildcards for a hotel list that cannot be modified.

    protected static void addClientsAndRooms(List<? extends Hotel> hotels) throws Exception {
        //Distinguish between clients with and without rented cars, and use the appropriate overloaded constructor
        //Adds three types of rooms and prices to each hotel.

        Client client1 = new Client("Marcel Proust", "111", "111111111");


     Room singleRoom1 = new Room(RoomType.SINGLE, 49.99);


        client1.bookARoom(client1, singleRoom1, 11);

        client1.isSatisfied(client1, true);

        client1.ratesHotel(client1, 4, hotels.get(0));

        client1.comments("\"Food was great.\"");

        Client client2 = new Client("Gustave Flaubert", "222", "222222");

        Room doubleRoom1 = new Room(RoomType.DOUBLE, 75.69);

        client2.bookARoom(client2, doubleRoom1, 2);


        Client client3 = new Client("Jules Verne", "333", "333333", "IF01FUN");

        Room tripleRoom1 = new Room(RoomType.TRIPLE, 99.99);

        client3.bookARoom(client3, tripleRoom1, 5);

        List<Client> clients1 = new ArrayList<Client>();
        clients1.add(client1);
        clients1.add(client2);
        clients1.add(client3);

        hotels.get(0).setClients(clients1);

        List<Room> rooms1 = new ArrayList<>();

        rooms1.add(singleRoom1);
        rooms1.add(doubleRoom1);
        rooms1.add(tripleRoom1);

        hotels.get(0).setRooms(rooms1);


        Client client21 = new Client("Charles Baudelaire", "001", "211111111");

        Room singleRoom2 = new Room(RoomType.SINGLE, 79.99);

        client21.bookARoom(client21, singleRoom1, 3);

        client21.isSatisfied(client21, false);

        client21.ratesHotel(client21, 2, hotels.get(1));

        client21.comments("\"Food was lousy!!!!\"");


        Client client22 = new Client("Arthur Rimbaud", "002", "322222");

        Room doubleRoom2 = new Room(RoomType.DOUBLE, 175.69);

        client22.bookARoom(client22, doubleRoom2, 7);

        Client client23 = new Client("Paul Verlaine", "003", "43333", "NT33ZEU");

        Room tripleRoom2 = new Room(RoomType.TRIPLE, 199.99);

        client23.bookARoom(client23, tripleRoom2, 1);

        List<Client> clients2 = new ArrayList<Client>();
        clients2.add(client21);
        clients2.add(client22);
        clients2.add(client23);

        hotels.get(1).setClients(clients2);

        //Add an additional non-booked room
        Room quadrupleRoom1 = new Room(RoomType.QUADRUPLE, 223);
        List<Room> rooms2 = new ArrayList<Room>();

        rooms2.add(singleRoom2);
        rooms2.add(doubleRoom2);
        rooms2.add(tripleRoom2);
        rooms2.add(quadrupleRoom1);

        hotels.get(1).setRooms(rooms2);


        Client client31 = new Client("Pierre Corneille", "010", "5444");

        Room singleRoom3 = new Room(RoomType.SINGLE, 249.99);

        client31.bookARoom(client31, singleRoom1, 10);

        Client client32 = new Client("Jean Racine", "020", "65555");

        Room doubleRoom3 = new Room(RoomType.DOUBLE, 375.69);

        client32.bookARoom(client23, doubleRoom3, 12);

        Client client33 = new Client("Molière", "030", "75555", "CJ69PSD");

        Room tripleRoom3 = new Room(RoomType.TRIPLE, 499.99);

        client33.bookARoom(client3, tripleRoom3, 12);

        client33.cancelBooking(client33);

        List<Client> clients3 = new ArrayList<Client>();
        clients3.add(client31);
        clients3.add(client32);
        clients3.add(client33);

        hotels.get(2).setClients(clients3);


        Room quadrupleRoom2 = new Room(RoomType.QUADRUPLE, 555);
        Room kingRoom1 = new Room(RoomType.KING, 679);

        List<Room> rooms3 = new ArrayList<Room>();

        rooms3.add(singleRoom3);
        rooms3.add(doubleRoom3);
        rooms3.add(tripleRoom3);
        rooms3.add(quadrupleRoom2);
        rooms3.add(kingRoom1);

        hotels.get(2).setRooms(rooms3);


    }
}