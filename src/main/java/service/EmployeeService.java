package service;

import model.Hotel;
import model.HotelEmployee;
import model.PartTimeHotelEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeService {

    public static final Logger logger = LogManager.getLogger(EmployeeService.class);

    public static void listEmployeesOfAHotel(List<Hotel> hotels) {


        for (Hotel hotel : hotels) {
            List<HotelEmployee> hotelEmployees = hotel.getHotelEmployees();

            if (hotelEmployees.size() == 0) {

                logger.debug(hotel.getName() + " has no employees.");

            } else {

                logger.debug(hotel.getName() + " has the following employees: ");


                /**
                 * We are going to loop through the list of HotelEmployees, print their names,
                 * hotel where they work, and their
                 * job title
                 **/

                for (HotelEmployee employee : hotelEmployees) {

                    logger.debug(employee.getPersonName() +
                            " works for " + hotel.getName() +
                            " as a " + employee.getJobTitle() + ". " + employee.toString() +
                            ". Gender: " + employee.getGender() + "." + "\n");


                    boolean isInstance = employee instanceof PartTimeHotelEmployee;

                    // Example of casting and supresswarning annotation
                    if (isInstance) {

                        @SuppressWarnings("checked cast")
                        PartTimeHotelEmployee partTimeHotelEmployee = (PartTimeHotelEmployee) employee;

                        logger.debug(partTimeHotelEmployee.getPersonName() + " works part-time for a " +
                                "total of " + partTimeHotelEmployee.getNrOfWorkingHours()
                                + " hours/week");

                    }
                }
            }
        }
    }
}