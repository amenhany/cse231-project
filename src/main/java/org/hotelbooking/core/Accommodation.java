package org.hotelbooking.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Accommodation implements Comparable<Accommodation>{
    private String accommodationId;
    private double pricePerNight;
    private double discount;
    private int capacity;

    Accommodation(String accommodationId,double pricePerNight,double discount,int capacity){
        this.accommodationId=accommodationId;
        this.pricePerNight=pricePerNight;
        this.discount=discount;
        this.capacity=capacity;
    }

    public  double getPricePerNight(){return pricePerNight;}
    public  String getAccommodationId(){return accommodationId;}
    public  double calculatePrice(LocalDateTime startDate,LocalDateTime endDate){
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return daysBetween*pricePerNight;
    }
    public  abstract boolean matches(AccommodationTemplate template);
    public  abstract void displayInfo();

    @Override
    public abstract int compareTo(Accommodation o);
}