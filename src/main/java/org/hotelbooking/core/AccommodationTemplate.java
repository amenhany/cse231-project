package org.hotelbooking.core;

import static org.hotelbooking.core.AccommodationType.*;

public class AccommodationTemplate {

    AccommodationType accommodationType;
    RoomView view;
    boolean isBedKingSize;
    boolean hasJacuzzi;
    boolean hasEnsuiteBathroom;
    boolean hasProjector;
    boolean hasPool;
    int minimumNumberOfRooms;

    AccommodationTemplate(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public void setView(RoomView view) {
        this.view = view;
    }

    public RoomView getView() {
        return view;
    }

    public void setIsBedKingSize(boolean bedKingSize) {
        if (accommodationType == DOUBLE_ROOM) {
            isBedKingSize = bedKingSize;
        } else {
            System.out.println("Accommodation type must be Double Room.");
        }
    }

    public boolean getIssBedKingSize() {
        return isBedKingSize;
    }

    public void setHasEnsuiteBathroom(boolean EnsuiteBathroom) {

            if (accommodationType == SUITE) {
                hasEnsuiteBathroom = EnsuiteBathroom;
            } else {
                System.out.println("Accommodation type must be Suite.");
            }

    }

    public boolean getHasEnsuiteBathroom() {
        return hasEnsuiteBathroom;
    }

    public void setHasJacuzzi(boolean jacuzzi) {

            if (accommodationType == SUITE) {
                hasJacuzzi = jacuzzi;
            } else {
                System.out.println("Accommodation type must be Suite.");
            }

    }

    public boolean getHasJacuzzi() {
        return hasJacuzzi;
    }


    public void setHasProjector(boolean projector) {

            if (accommodationType == CONFERENCE_ROOM) {
                hasProjector = projector;
            } else {
                System.out.println("Accommodation type must be Conference Room.");
            }

    }

    public boolean getHasProjector() {
        return hasProjector;
    }


    public void setHasPool(boolean pool) {

            if (accommodationType == VILLA) {
                hasPool = pool;
            } else {
                System.out.println("Accommodation type must be Villa.");
            }

    }

    public boolean getHasPool() {
        return hasPool;
    }


    public void setMinimumNumberOfRooms(int minimumNumberOfRooms) {

            if (accommodationType == CHALET) {
                this.minimumNumberOfRooms = minimumNumberOfRooms;
            } else {
                System.out.println("Accommodation type must be Chalet.");
            }

    }

    public int getMinimumNumberOfRooms() {
        return minimumNumberOfRooms;
    }

}
