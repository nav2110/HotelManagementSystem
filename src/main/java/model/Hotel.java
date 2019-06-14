package model;

import lombok.Getter;
import model.enums.HotelLocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Hotel implements Serializable {

    private String name;

    private int stars;

    private final HotelLocation location;

    private final int capacity;

    private List<Client> clients = new ArrayList<>();

    private List<HotelEmployee> employees = new ArrayList<>();

    private List<Room> rooms = new ArrayList<>();

    private Long uuid;


    public Hotel(String name, int stars, HotelLocation location, int capacity) {
        this.name = name;
        this.stars = stars;
        this.capacity = capacity;
        this.location = location;

    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }


    public int getStars() {
        return stars;
    }

    public String getLocation() {

        return location.getCityName() +
                ", zip code: " +
                location.getZipCode() +
                ", phone Number: " +
                location.getPhoneNo();
    }


    public List<HotelEmployee> getHotelEmployees() {
        return employees;
    }

    public List<Client> getClients() {
        return clients;
    }

    public int roomsAvailable() {


        return capacity - clients.size();
    }


    public void setEmployees(List<HotelEmployee> employees) {
        this.employees = employees;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}