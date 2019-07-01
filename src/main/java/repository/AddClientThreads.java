package repository;

import model.Client;
import model.ClientThread;
import model.HotelThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AddClientThreads {
    private static Logger logger = LogManager.getLogger(AddHotels.class);

    static void addClientsToHotelThread(HotelThread hotel) {

        //Create  a list of clientThreads

        List<ClientThread> clients = new ArrayList<>();

        Client client1 = new Client("Smith Smithson", "77", "43154525");

        ClientThread clientThread1 = new ClientThread(client1, 2);

        clientThread1.start();

        clients.add(clientThread1);

        Client client2 = new Client("Richard Richardson", "12", "8987654");

        ClientThread clientThread2 = new ClientThread(client2, 12);

        clientThread2.start();

        clients.add(clientThread2);


        Client client3 = new Client("Sam Samuels", "2", "8987654");

        ClientThread clientThread3 = new ClientThread(client3, 12);

        clientThread3.start();

        clients.add(clientThread3);


        Client client4 = new Client("Giovanni Becali", "4", "8987654");

        ClientThread clientThread4 = new ClientThread(client4, 1);

        clientThread4.start();

        clients.add(clientThread4);


        hotel.setClients(clients);

        hotel.setName("Marriott");


    }
}
