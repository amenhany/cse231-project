package org.hotelbooking.core;
//Hazem Wins
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Accommodation implements Comparable<Accommodation>{
    final private String accommodationId;
    private double pricePerNight;
    protected double discount;
    private int capacity;

    Accommodation(String accommodationId){
    this.accommodationId=accommodationId;
    }

    Accommodation(double pricePerNight,int capacity,String accommodationId){
        this.pricePerNight=pricePerNight;
        this.capacity=capacity;
        this.accommodationId= accommodationId;
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
    public int compareTo(Accommodation o){
        return 0;
    }
}