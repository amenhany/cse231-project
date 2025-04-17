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

    public void setIsBedKingSize(boolean bedKingSize) throws Exception {
        if (accommodationType == DOUBLE_ROOM) {
            isBedKingSize = bedKingSize;
        } else {
            throw new Exception("Accommodation type must be Double Room.");
        }
    }

    public boolean getIssBedKingSize() {
        return isBedKingSize;
    }

    public void setHasEnsuiteBathroom(boolean EnsuiteBathroom) throws Exception {

            if (accommodationType == SUITE) {
                hasEnsuiteBathroom = EnsuiteBathroom;
            } else {
                throw new Exception("Accommodation type must be Suite.");
            }


    }

    public boolean getHasEnsuiteBathroom() {
        return hasEnsuiteBathroom;
    }


    public void setHasJacuzzi(boolean jacuzzi) throws Exception {

            if (accommodationType == SUITE) {
                hasJacuzzi = jacuzzi;
            } else {
                throw new Exception("Accommodation type must be Suite.");
            }

    }

    public boolean getHasJacuzzi() {
        return hasJacuzzi;
    }


    public void setHasProjector(boolean projector) throws Exception{

            if (accommodationType == CONFERENCE_ROOM) {
                hasProjector = projector;
            } else {
                throw new Exception("Accommodation type must be Conference Room.");
            }


    }

    public boolean getHasProjector() {
        return hasProjector;
    }


    public void setHasPool(boolean pool) throws Exception {

            if (accommodationType == VILLA) {
                hasPool = pool;
            } else {
                throw new Exception("Accommodation type must be Villa.");
            }


    }

    public boolean getHasPool() {
        return hasPool;
    }


    public void setMinimumNumberOfRooms(int minimumNumberOfRooms) throws Exception{

            if (accommodationType == CHALET) {
                this.minimumNumberOfRooms = minimumNumberOfRooms;
            } else {
                throw new Exception("Accommodation type must be Chalet.");
            }

    }

    public int getMinimumNumberOfRooms() {
        return minimumNumberOfRooms;
    }

}
