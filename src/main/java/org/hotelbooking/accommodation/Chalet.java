package org.hotelbooking.accommodation;

public class Chalet extends Accommodation implements Offerable {
    private int numberOfRooms;


    public Chalet(int chaletNumber, double pricePerNight, int capacity, int numberOfRooms){
        super("CH" + chaletNumber, pricePerNight, capacity);
        this.numberOfRooms = numberOfRooms;
    }

    public  boolean matches(AccommodationTemplate template){
        return (template.getAccommodationType() == AccommodationType.CHALET) && (template.getMinimumNumberOfRooms() <= numberOfRooms);
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Chalet Info:- \nChalet ID: " + getAccommodationId() + "\nNumber of rooms: " + numberOfRooms
                + "\nPrice/Night: " + getPricePerNight());
    }
}
