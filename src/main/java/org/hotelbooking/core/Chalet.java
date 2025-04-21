package org.hotelbooking.core;

import java.time.LocalDateTime;

public class Chalet extends Accommodation implements Offerable{
    private int chaletNumber;
    private int numberOfRooms;

    Chalet(String accommodationId,double pricePerNight,double discount,int capacity,int chaletNumber,int numberOfRooms){
        super(accommodationId,pricePerNight,discount,capacity);
        this.chaletNumber=chaletNumber;
        this.numberOfRooms=numberOfRooms;
    }


    public  boolean matches(AccommodationTemplate template){

    }
    @Override
    public  void displayInfo(){
        System.out.println("Chalet Info:- \n Chalet ID: " +getAccommodationId()+chaletNumber "\nNumber of rooms: "+numberOfRooms+
                "\nPrice/night: "+getPricePerNight());

    }
}
