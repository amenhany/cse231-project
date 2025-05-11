package org.hotelbooking.accommodation;


import org.jetbrains.annotations.Nullable;

public class DoubleRoom extends Room implements Connectable,Offerable{
    private boolean isBedKingSize;


    public DoubleRoom(int roomNumber, double pricePerNight, RoomView view, boolean isBedKingSize){
        super(roomNumber, pricePerNight, 2, view);
        this.isBedKingSize = isBedKingSize;
    }

    public boolean isBedKingSize() {
        return isBedKingSize;
    }

    @Override
    public void setConnectedRoom(Room x) {
        connectedRoom = x;
    }

    @Override
    public @Nullable Room getConnectedRoom() {
        return connectedRoom;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean matches(AccommodationTemplate template) {
        return (template.getAccommodationType() == AccommodationType.DOUBLE_ROOM) && (template.hasBedKingSize() == isBedKingSize) && (super.matches(template));
    }
}
