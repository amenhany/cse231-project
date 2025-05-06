package org.hotelbooking.accommodation;


import org.jetbrains.annotations.Nullable;

public class Suite extends Room implements Connectable, ExtraFeeApplicable, Offerable{
    private boolean hasJacuzzi;
    private boolean hasEnsuiteBathroom;


    public Suite(int roomNumber, double pricePerNight, int capacity, RoomView view, boolean hasJacuzzi, boolean hasEnsuiteBathroom) {
        super(roomNumber, pricePerNight, capacity, view);
        this.hasJacuzzi=hasJacuzzi;
        this.hasEnsuiteBathroom=hasEnsuiteBathroom;
    }

    public boolean hasJacuzzi() {
        return hasJacuzzi;
    }

    public boolean hasEnsuiteBathroom() {
        return hasEnsuiteBathroom;
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
    public double getExtraFees() {
        return 0;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
