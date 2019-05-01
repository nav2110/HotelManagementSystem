package Menu;

import Enums.RoomType;

public class Room {
    //Use private, public and protected access modifiers
    private RoomType type;
    private double price;

    protected Room(RoomType type, double price) {
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
