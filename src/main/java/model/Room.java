package model;

import model.enums.RoomType;

import java.io.Serializable;

public class Room implements Serializable {
    //Use private, public and protected access modifiers
    private RoomType type;
    private double price;

    public Room(RoomType type, double price) {
        this.type = type;
        this.price=price;
    }

    public String getType() {
        return type.getRoom();
    }

    public double getPrice() {
        return price;
    }
}
