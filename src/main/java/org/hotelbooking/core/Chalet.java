package org.hotelbooking.core;

public class Chalet extends Accommodation implements Offerable{
    private int chaletNumber;
    private int numberOfRooms;

    Chalet(double pricePerNight,int capacity,int chaletNumber,int numberOfRooms){
        super(pricePerNight,capacity);
        this.chaletNumber=chaletNumber;
        this.numberOfRooms=numberOfRooms;
        setAccommodationId("RM"+chaletNumber);
    }

    public  boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Chalet Info:- \n Chalet ID: " +getAccommodationId()+chaletNumber +"\nNumber of rooms: "+numberOfRooms+
                "\nPrice/night: "+getPricePerNight());
    }

    @Override
    public void setDiscount(double discount) {

    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
