package org.hotelbooking.core;

import java.time.LocalDateTime;

public class Villa extends Accommodation implements ExtraFeeApplicable{
    int villaNumber;
    boolean hasPool;

    Villa(double pricePerNight,int capacity,int villaNumber,boolean hasPool){
        super(pricePerNight,capacity);
        this.villaNumber=villaNumber;
        this.hasPool=hasPool;
        setAccommodationId("VL" + villaNumber);
    }

    public  boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Villa Info:- \n Villa ID: " +getAccommodationId()+villaNumber + "Pool available: " + hasPool
            +"\nPrice/night: "+getPricePerNight());
    }

    public boolean hasPool(){
        return hasPool;
    }

    @Override
    public double getExtraFees() {
        return 0;
    }
}
