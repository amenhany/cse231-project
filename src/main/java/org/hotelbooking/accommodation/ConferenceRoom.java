package org.hotelbooking.accommodation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConferenceRoom extends Accommodation implements ExtraFeeApplicable{
    private static int numberOfConferenceRooms=0;
    private double hourlyRate;
    private boolean hasProjector;


    public ConferenceRoom(double hourlyRate,boolean hasProjector){
        super("CO"+ ++numberOfConferenceRooms, 0, 100);
        this.hourlyRate= hourlyRate;
        this.hasProjector= hasProjector;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculatePrice(LocalDateTime startDate, LocalDateTime endDate) {
        long hours = ChronoUnit.HOURS.between(startDate, endDate);
        return hours*hourlyRate;
    }

    public  boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public double getExtraFees() {
        return 0;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Conference Room Info:\nAccommodation ID: " + getAccommodationId() + "\nHourly Rate:  " +
                hourlyRate);
    }
}
