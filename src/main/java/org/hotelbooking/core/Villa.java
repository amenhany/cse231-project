package org.hotelbooking.core;

public class Villa extends Accommodation implements ExtraFeeApplicable{
    private static int numberOfVillas=0;
    private boolean hasPool;

    Villa(double pricePerNight,int capacity,boolean hasPool){
        super(pricePerNight,capacity,"VL"+ ++numberOfVillas);
        this.hasPool=hasPool;
    }

    public  boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Villa Info:- \n Villa ID: " +getAccommodationId() + "Pool available: " + hasPool
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
