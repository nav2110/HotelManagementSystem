package model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ClientsService;
import service.ISatisfaction;

import java.io.Serializable;
import java.util.List;

import static model.ValidationException.validRate;


//example of multiple inheritance
public class Person implements IPerson, ISatisfaction, Serializable {


    private static final Logger logger = LogManager.getLogger(ClientsService.class);

    private String name;

    private String idNrOrCreditCard;

    public Person(String name, String idNrOrCreditCard) {
        this.name=name;
        this.idNrOrCreditCard = idNrOrCreditCard;
    }

    public String toString() {
        String lastFourDigits = "";

        if (idNrOrCreditCard.length() > 4) {
            lastFourDigits = idNrOrCreditCard.substring(idNrOrCreditCard.length() - 4);
        } else {
            lastFourDigits = idNrOrCreditCard;
        }
        return "Last four digits of credit card or employee number: " + lastFourDigits;
    }

    public String getNumber() {
        return idNrOrCreditCard;
    }

    /*
    There are two static methods listing employees and clients in the main class
    that perform the same task.
    */

    @Deprecated
    public void findHotelWherePersonIs(List<Hotel> hotels) {


        //Loop through hotels
        for(Hotel hotel: hotels){

            //loop first through clients list to see whether the person is a client of the hotel
            List<Client> clients= hotel.getClients();
            for(Client client: clients){
                if (name.equals(client.getPersonName()) && idNrOrCreditCard.equals(client.getNumber())) {
                    logger.debug(client.getPersonName() + " is a client of the hotel " + hotel.getName());
                    break;
                }
            }

            //loop then through the employee lists to see if the client is not actually an employee
            List<HotelEmployee> employees= hotel.getHotelEmployees();
            for(HotelEmployee employee: employees){
                if (name.equals(employee.getPersonName()) && idNrOrCreditCard.equals(employee.getNumber())) {
                    logger.debug(employee.getPersonName() + " is an employee of the hotel " + hotel.getName());
                    break;
                }
            }

        }


    }

    public String getPersonName() {
        return name;
    }


    public void isSatisfied(Person person, Boolean yes) {
        if (yes) {
            logger.debug(person.getPersonName() + " is satisfied. ");
        } else {
            logger.debug(person.getPersonName() + " is not satisfied. ");
        }
    }

    public String comments(String message) {
        logger.debug("Satisfaction comments: " + message);
        return message;
    }

    //Use custom ValidationException in case the user rates wrongly the hotel
    public void ratesHotel(Person person, int rating, Hotel hotel) {
        try {
            validRate(rating);
            logger.debug(person.getPersonName() + " rates " + hotel.getName() + " at " + rating + " stars");


        } catch (ValidationException e) {
            logger.debug("Invalid rating argument: " + e.getMessage());
        }

    }
}
