package org.hotelbooking.core;

public class SingleRoom extends Room implements Connectable{
    SingleRoom(String accommodationId,double pricePerNight,double discount,int capacity,int roomNumber,RoomView view){
        super(pricePerNight,capacity,roomNumber,view);
    }

    @Override
    public void setConnectedRoom(Room x) {

    }

    @Override
    public void getConnectedRoom(Room y) {

    }
}
