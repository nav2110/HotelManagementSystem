package service;


import model.ClientThread;
import model.HotelThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.MainMenu;

import java.util.List;

public class HotelStatisticsThread extends Thread {

    private HotelThread hotel;
    private Logger logger = LogManager.getLogger(MainMenu.class);

    public HotelStatisticsThread(HotelThread hotel) {
        this.hotel = hotel;
    }

    public void run() {
        try {
            List<ClientThread> clients = hotel.getClients();
            logger.debug("Try block of HotelStatiticsThread with Check-in info" +
                    " from the clientThreads:");

            for (ClientThread clientThread : clients) {


                logger.debug(clientThread.getClient().getName() +
                        " has booked a room for " + clientThread.getNOfPeople() +
                        " at the following date: " + clientThread.getCheckInData());
            }
            Thread.sleep(5000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
