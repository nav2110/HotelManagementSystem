package People;

public class HotelEmployee extends Person {


    private String jobTitle;



    public HotelEmployee(String name, String id, String jobTitle) {
        super(name, id);

        this.jobTitle = jobTitle;
    }


    public String getJobTitle() {
        return jobTitle;

    }


}
