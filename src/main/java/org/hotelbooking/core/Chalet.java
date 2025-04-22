package org.hotelbooking.core;

public class Chalet extends Accommodation implements Offerable{
    private static int numberOfChalets=0;
    private int numberOfRooms;

    Chalet(double pricePerNight,int capacity,int numberOfRooms){
        super(pricePerNight,capacity,"CH"+ ++numberOfChalets);
        this.numberOfRooms=numberOfRooms;
    }

    public  boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Chalet Info:- \n Chalet ID: " + getAccommodationId() + "\nNumber of rooms: "+numberOfRooms+
                "\nPrice/night: "+getPricePerNight());
    }

    @Override
    public void setDiscount(double discount) {
        this.discount=discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
