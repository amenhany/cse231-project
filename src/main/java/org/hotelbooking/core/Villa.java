package org.hotelbooking.core;

import java.time.LocalDateTime;

public class Villa extends Accommodation implements ExtraFeeApplicable{
    int villaNumber;
    boolean hasPool;

    Villa(String accommodationId,double pricePerNight,double discount,int capacity,int villaNumber,boolean hasPool){
        super(accommodationId, pricePerNight, discount, capacity);
        this.villaNumber=villaNumber;
        this.hasPool=hasPool;
    }

    public  boolean matches(AccommodationTemplate template){}
    @Override
    public  void displayInfo(){
        System.out.println("Villa Info:- \n Villa ID: " +getAccommodationId()+villaNumber + "Pool available: " + hasPool
                "\nPrice/night: "+getPricePerNight());

    }

    public boolean hasPool(){return hasPool;}

}
