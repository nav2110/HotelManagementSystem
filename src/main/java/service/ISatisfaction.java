package service;

import model.Hotel;
import model.Person;

public interface ISatisfaction {
    /*
    This interface is implemented by both clients and employees. When the methods are implemented
    the type Person needs to be downcasted to the subclass types.
     */
    void isSatisfied(Person person, Boolean yes);

    void ratesHotel(Person person, int rating, Hotel hotel) throws Exception;

    String comments(String message);

}
