package People;

public class PartTimeHotelEmployee extends HotelEmployee {
    private short nrOfWorkingHours;

    public PartTimeHotelEmployee(String name, String id, String jobTitle, short nrOfWorkingHours) {

        super(name, id, jobTitle);

        this.nrOfWorkingHours = nrOfWorkingHours;
    }
}
