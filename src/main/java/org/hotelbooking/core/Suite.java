package org.hotelbooking.core;

public class Suite extends Room implements Connectable,ExtraFeeApplicable,Offerable{
    private boolean hasJacuzzi;
    private boolean hasEnsuiteBathroom;

    public boolean hasJacuzzi() {
        return hasJacuzzi;
    }

    public boolean hasEnsuiteBathroom() {
        return hasEnsuiteBathroom;
    }

    @Override
    public void setConnectedRoom(Room x) {

    }

    @Override
    public void getConnectedRoom(Room y) {

    }

    @Override
    public double getExtraFees() {
        return 0;
    }

    @Override
    public void setDiscount(double discount) {

    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
