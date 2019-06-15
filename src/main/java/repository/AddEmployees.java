package repository;

import model.Hotel;
import model.HotelEmployee;
import model.PartTimeHotelEmployee;
import model.enums.Gender;

import java.util.ArrayList;
import java.util.List;

/*
Static class for Adding employees to a hotel with their name, id, employe nr, job title, gender.
Multiply inherited methods for satisfaction, rating, and comments.
 */
class AddEmployees {

    //Use of Generic wildcard
    static void addEmployees(List<? extends Hotel> hotels) throws Exception {


        HotelEmployee employee1 = new HotelEmployee("Radu Radulescu", "78645", "PN54254256JU", "cleaner", Gender.MALE);


        employee1.isSatisfied(employee1, true);

        //Added a satisfaction of 6 stars to test the custom validationexception class
        employee1.ratesHotel(employee1, 6, hotels.get(0));

        employee1.comments("\"I love cleaning toilets!\"");

        HotelEmployee employee2 = new HotelEmployee("Jean Ionescu", "68645", "joihwr74981754", "receptionist", Gender.MALE);

        employee2.isSatisfied(employee2, false);

        employee2.ratesHotel(employee2, 2, hotels.get(0));

        employee2.comments("\"Pay is not that good.\"");

        HotelEmployee employee3 = new PartTimeHotelEmployee("Paul Pavelescu", "111111", "trwtrw4315", "manager", Gender.MALE, (short) 20);

        List<HotelEmployee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        hotels.get(0).setEmployees(employees);


        HotelEmployee employee21 = new HotelEmployee("Georgiana Georgescu", "58645", "yy098", "cleaner", Gender.FEMALE);
        HotelEmployee employee22 = new HotelEmployee("Vasilica Vasilescu", "48645", "u888", "receptionist", Gender.FEMALE);
        HotelEmployee employee23 = new PartTimeHotelEmployee("Alex Alexandrescu", "000007", "oop1234", "manager", Gender.MALE, (short) 10);

        List<HotelEmployee> employees2 = new ArrayList<>();
        employees2.add(employee21);
        employees2.add(employee22);
        employees2.add(employee23);

        hotels.get(1).setEmployees(employees2);

        HotelEmployee employee31 = new HotelEmployee("Mihaela Mihailescu", "38645", "ohe312", "cleaner", Gender.FEMALE);
        HotelEmployee employee32 = new HotelEmployee("Ioana Ionescu", "38645", "triuwh909", "receptionist", Gender.FEMALE);
        HotelEmployee employee33 = new PartTimeHotelEmployee("Dan Danielescu", "111111", "uu1", "manager", Gender.MALE, (short) 30);

        List<HotelEmployee> employees3 = new ArrayList<>();
        employees3.add(employee31);
        employees3.add(employee32);
        employees3.add(employee33);

        hotels.get(2).setEmployees(employees3);

    }
}