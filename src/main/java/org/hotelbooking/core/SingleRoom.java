package org.hotelbooking.core;

public class SingleRoom extends Room implements Connectable{
    SingleRoom(double pricePerNight,int capacity,RoomView view){
        super(pricePerNight,capacity,view);
    }

    @Override
    public void setConnectedRoom(Room x) {
        connectedRoom = x;
    }

    @Override
    public Room getConnectedRoom(Room y) {
        return connectedRoom;
    }
}
