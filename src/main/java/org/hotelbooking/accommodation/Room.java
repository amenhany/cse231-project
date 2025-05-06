package org.hotelbooking.accommodation;

import org.jetbrains.annotations.Nullable;

public abstract class Room extends Accommodation {
    private RoomView view;
    @Nullable protected Room connectedRoom;


    Room(int roomNumber, double pricePerNight, int capacity, RoomView view) {
        super("RM" + roomNumber, pricePerNight, capacity);
        this.view=view;
    }

    @Override
    public boolean matches(AccommodationTemplate template){
        return false;
    }

    public double getSnackBill(){
        return 0.0;
    }

    public void refillSnacks(){

    }

    @Override
    public void displayInfo(){

    }
}


