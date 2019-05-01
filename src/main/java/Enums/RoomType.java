package Enums;

public enum RoomType {

    SINGLE("single"), DOUBLE("double"), TRIPLE("triple"),
    QUADRUPLE("quadruple"), KING("king");

    private String room;

    RoomType(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }
}
