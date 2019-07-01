package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelThread {
    String name;
    List<ClientThread> clients;

}
