package model;


import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.MainMenu;

import java.util.Date;
import java.util.Random;

@Getter
public class ClientThread extends Thread {
    Random random = new Random();
    private Client client;
    private int nOfPeople;
    private Logger logger = LogManager.getLogger(MainMenu.class);
    private CheckInData checkInData;

    public ClientThread(Client client, int nOfPeople) {
        this.client = client;
        this.nOfPeople = nOfPeople;
    }

    @Override
    public void run() {

        try {
            checkInData = new CheckInData(new Date());
            Thread.sleep(random.nextInt(3000));
            logger.debug("Thread " + Thread.currentThread().getId()
                    + " for client " + client.getPersonName() +
                    " is running. Check in date is being created.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
