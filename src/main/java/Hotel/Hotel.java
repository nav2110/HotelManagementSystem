package Hotel;

import People.Client;
import People.HotelEmployee;
import People.PartTimeHotelEmployee;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;

    private int stars;

    private final String location;

    private final int capacity;


    private List<Client> clients = new ArrayList<Client>();

    private List<HotelEmployee> employees = new ArrayList<HotelEmployee>();

    private List<Room> rooms = new ArrayList<Room>();



    public Hotel(String name, int stars, String location, int capacity){
        this.name=name;
        this.stars = stars;
        this.capacity = capacity;
        this.location = location;

    }



    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStars() {
        return stars;
    }

    public String getLocation() {
        return location;
    }

    public void setEmployees(List<Hotel> hotels){

        for (Hotel hotel: hotels){

            if ("Dacia".equals(hotel.getName())) {
                HotelEmployee employee1 = new HotelEmployee("Radu Radulescu", "78645", "cleaner");
                HotelEmployee employee2 = new HotelEmployee("Jean Ionescu", "68645", "receptionist");
                HotelEmployee employee3 = new PartTimeHotelEmployee("Paul Pavelescu", "1", "manager", (short) 20);

                List<HotelEmployee> employees = new ArrayList<HotelEmployee>();
                employees.add(employee1);
                employees.add(employee2);
                employees.add(employee3);
            } else if ("Grand Hotel Italia".equals(hotel.getName())) {
                HotelEmployee employee21 = new HotelEmployee("George Georgescu", "58645", "cleaner");
                HotelEmployee employee22 = new HotelEmployee("Vasile Vasilescu", "48645", "receptionist");
                HotelEmployee employee23 = new PartTimeHotelEmployee("Paul Pavelescu", "007", "manager", (short) 10);

                List<HotelEmployee> employees2 = new ArrayList<HotelEmployee>();
                employees2.add(employee21);
                employees2.add(employee22);
                employees2.add(employee23);
            } else if ("Continental".equals(hotel.getName())) {
                HotelEmployee employee31 = new HotelEmployee("Mihai Mihailescu", "38645", "cleaner");
                HotelEmployee employee32 = new HotelEmployee("Jean Ionescu", "38645", "receptionist");
                HotelEmployee employee33 = new PartTimeHotelEmployee("Paul Pavelescu", "111", "manager", (short) 30);

                List<HotelEmployee> employees3 = new ArrayList<HotelEmployee>();
                employees3.add(employee31);
                employees3.add(employee32);
                employees3.add(employee33);
            }
        }
    }

    public List<HotelEmployee> getEmployees() {
        return employees;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    public List<HotelEmployee> getHotelEmployees() {
        return employees;
    }


    public boolean isAvailabe() {
        if (roomsAvailable() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public int roomsAvailable() {


        return capacity - clients.size();
    }

    public List<Client> getClients() {
        return clients;
    }

    }