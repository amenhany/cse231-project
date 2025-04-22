package org.hotelbooking.core;

public class DoubleRoom extends Room implements Connectable,Offerable{
    private boolean isBedKingSize;

    DoubleRoom(double pricePerNight,int capacity,RoomView view,Boolean isBedKingSize){
        super(pricePerNight,capacity,view);
        this.isBedKingSize=isBedKingSize;
    }

    public boolean isBedKingSize() {
        return isBedKingSize;
    }

    @Override
    public void setConnectedRoom(Room x) {
        connectedRoom = x;
    }

    @Override
    public Room getConnectedRoom(Room y) {
        return connectedRoom;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount=discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
