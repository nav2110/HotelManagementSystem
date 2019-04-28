package Hotel;

public class Room {
    String type;
    double price;

    public Room(String type, double price) {
        this.type = type;
        this.price=price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
