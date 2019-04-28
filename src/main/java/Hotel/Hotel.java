package Hotel;

import People.Client;
import People.HotelEmployee;

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


    public void setRooms(List<Room> rooms) {
        this.rooms=rooms;
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

    public void setEmployees(List<HotelEmployee> employees) {
        this.employees=employees;
    }

    public void setClients(List<Client> clients) {
        this.clients=clients;
    }
}