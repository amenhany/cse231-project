package org.hotelbooking.core;

public class SingleRoom extends Room implements Connectable{
    SingleRoom(String accommodationId,double pricePerNight,double discount,int capacity,int roomNumber,RoomView view){
        super(accommodationId, pricePerNight, discount, capacity,roomNumber,view);
    }


}
