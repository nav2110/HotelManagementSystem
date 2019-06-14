package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

//Example for use of lombok
@AllArgsConstructor
@Getter

//Exampe of two generics for a class
public class Room<X, Y> implements Serializable {
    //Use private, public and protected access modifiers
    private X type;
    private Y price;


}
