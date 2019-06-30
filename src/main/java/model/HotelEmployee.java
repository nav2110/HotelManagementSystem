package model;

import model.enums.Gender;

public class HotelEmployee extends Person {

    private String employeeNr;

    private final Gender gender;
    private String jobTitle;


    public HotelEmployee(String name, String id, String employeeNr, String jobTitle, Gender gender) {
        super(name, id);
        this.employeeNr = employeeNr;
        this.jobTitle = jobTitle;
        this.gender = gender;
    }


    public String getJobTitle() {
        return jobTitle;

    }

    public Gender getGender() {
        return gender;
    }


    //Override the method from the Person class for the last four digits of the employer number
    @Override
    public String toString() {
        String lastFourDigits = "";

        if (employeeNr.length() > 4) {
            lastFourDigits = employeeNr.substring(employeeNr.length() - 4);
        } else {
            lastFourDigits = employeeNr;
        }
        return "Last four characters of the employee id= " + lastFourDigits;
    }


}
