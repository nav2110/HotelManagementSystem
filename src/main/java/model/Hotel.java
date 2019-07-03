package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enums.HotelLocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
//This class uses a builder pattern.
//For practice purposes, I avoided using the lombok.Builder import
public class Hotel implements Serializable {

    private String name;

    private int stars;

    private final int capacity;

    private final HotelLocation location;


    private List<Client> clients = new ArrayList<>();

    private List<HotelEmployee> employees = new ArrayList<>();

    private List<Room> rooms = new ArrayList<>();


    private int uuid;


    private Hotel(Builder builder) {
        this.name = builder.name;
        this.stars = builder.stars;
        this.capacity = builder.capacity;
        this.location = builder.location;

    }

    public int getUuid() {
        return uuid;
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

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public static class Builder {


        private String name;

        private int stars;

        private int capacity;

        private HotelLocation location;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder stars(int stars) {
            this.stars = stars;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder location(HotelLocation location) {
            this.location = location;
            return this;
        }


        public Hotel build() {

            return new Hotel(this);
        }
    }
}