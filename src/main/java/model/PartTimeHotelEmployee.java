package model;

import model.enums.Gender;

public class PartTimeHotelEmployee extends HotelEmployee {
    private short nrOfWorkingHours;

    public PartTimeHotelEmployee(String name, String id, String employeeNr, String jobTitle, Gender gender, short nrOfWorkingHours) {

        super(name, id, employeeNr, jobTitle, gender);

        this.nrOfWorkingHours = nrOfWorkingHours;
    }

    public short getNrOfWorkingHours() {
        return nrOfWorkingHours;
    }
}
