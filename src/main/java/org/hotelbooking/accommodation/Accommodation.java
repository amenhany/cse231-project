package org.hotelbooking.accommodation;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Accommodation implements Comparable<Accommodation> {
    final private String accommodationId;
    private double pricePerNight;
    protected double discount;
    private int capacity;


    Accommodation(String accommodationId, double pricePerNight, int capacity) {
        this.accommodationId = accommodationId;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    public double getPricePerNight(){
        return pricePerNight;
    }

    public String getAccommodationId(){
        return accommodationId;
    }

    public double calculatePrice(LocalDateTime startDate,LocalDateTime endDate){
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return daysBetween*pricePerNight;
    }

    public abstract boolean matches(AccommodationTemplate template);
    public abstract void displayInfo();

    @Override
    public int compareTo(@NotNull Accommodation o){
        return 0;
    }
}