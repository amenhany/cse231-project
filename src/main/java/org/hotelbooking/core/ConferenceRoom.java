package org.hotelbooking.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConferenceRoom extends Room implements ExtraFeeApplicable{
    private double hourlyRate;
    private boolean hasProjector;


    public ConferenceRoom(){};
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
    public  void displayInfo(){
        super.displayInfo();

    }

    @Override
    public double getExtraFees() {
        return 0;
    }
}
