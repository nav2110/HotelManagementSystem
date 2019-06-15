package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

//Example for use of lombok
@AllArgsConstructor
@Getter

//Example of two generics for a class
public class Room<X, Y> implements Serializable {

    private X type;
    private Y price;


}
