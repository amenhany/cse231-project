package org.hotelbooking.core;

public class Suite extends Room implements Connectable,ExtraFeeApplicable,Offerable{
    private boolean hasJacuzzi;
    private boolean hasEnsuiteBathroom;

    public boolean HasJacuzzi() {
        return hasJacuzzi;
    }

    public boolean HasEnsuiteBathroom() {
        return hasEnsuiteBathroom;


    }
}
