package org.hotelbooking.accommodation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConferenceRoom extends Accommodation implements ExtraFeeApplicable {
    private double hourlyRate;
    private boolean hasProjector;


    public ConferenceRoom(int conferenceRoomNumber, double hourlyRate,boolean hasProjector){
        super("CO"+ String.format("%03d", conferenceRoomNumber), 0, 100);
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

    public boolean matches(AccommodationTemplate template){
        return (template.getAccommodationType() == AccommodationType.CONFERENCE_ROOM) && (template.hasProjector() == hasProjector) ;
    }

    @Override
    public double getExtraFees() {
        if(hasProjector) return 40.0;
        return 0.0;
    }

    @Override
    public  void displayInfo(){
        System.out.println("Conference Room Info:\nAccommodation ID: " + getAccommodationId() + "\nHourly Rate:  " +
                hourlyRate);
    }
}
