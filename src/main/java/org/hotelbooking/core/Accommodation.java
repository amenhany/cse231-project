package org.hotelbooking.core;
//Hazem Wins
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Accommodation implements Comparable<Accommodation>{
    private String accommodationId;
    private double pricePerNight;
    private double discount;
    private int capacity;

    Accommodation(){

    }

    Accommodation(double pricePerNight,int capacity){
        this.pricePerNight=pricePerNight;
        this.capacity=capacity;
    }

    public double getPricePerNight(){
        return pricePerNight;
    }

    public String getAccommodationId(){
        return accommodationId;
    }

    public void setAccommodationId(String x){
        accommodationId=x;
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