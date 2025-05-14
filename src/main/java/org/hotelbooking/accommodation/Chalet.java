package org.hotelbooking.accommodation;

public class Chalet extends Accommodation implements Offerable {
    private int numberOfRooms;


    public Chalet(int chaletNumber, double pricePerNight, int capacity, int numberOfRooms){
        super("CH" + String.format("%03d", chaletNumber), pricePerNight, capacity);
        this.numberOfRooms = numberOfRooms;
    }

    public  boolean matches(AccommodationTemplate template){
<<<<<<< HEAD
        return (template.getAccommodationType() == AccommodationType.CHALET) && (template.getMinimumNumberOfRooms() <= numberOfRooms);
=======
        return (template.getAccommodationType() == AccommodationType.CHALET) && (template.getMinimumNumberOfRooms() == numberOfRooms);
>>>>>>> ed5ed8c (matches/calculateBill/getExtraFees methods)
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
