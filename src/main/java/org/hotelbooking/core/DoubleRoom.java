package org.hotelbooking.core;

public class DoubleRoom extends Room implements Connectable,Offerable{
    private boolean isBedKingSize;

    public boolean isBedKingSize() {
        return isBedKingSize;
    }

    @Override
    public void setConnectedRoom(Room x) {

    }

    @Override
    public void getConnectedRoom(Room y) {

    }

    @Override
    public void setDiscount(double discount) {

    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
