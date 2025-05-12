package org.hotelbooking.accommodation;

import static org.hotelbooking.accommodation.AccommodationType.*;

public class AccommodationTemplate {
   private AccommodationType accommodationType;
   private RoomView view;
   private boolean isBedKingSize;
   private boolean hasJacuzzi;
   private boolean hasEnsuiteBathroom;
   private boolean hasProjector;
   private boolean hasPool;
   private int minimumNumberOfRooms;


    public AccommodationTemplate(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setView(RoomView view) { this.view = view;}

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

    public boolean hasBedKingSize() {
        return isBedKingSize;
    }

    public void setHasEnsuiteBathroom(boolean EnsuiteBathroom) {

                if (accommodationType == SUITE) {
                hasEnsuiteBathroom = EnsuiteBathroom;
            } else {
                System.out.println("Accommodation type must be Suite.");
            }

    }

    public boolean hasEnsuiteBathroom() {
        return hasEnsuiteBathroom;
    }

    public void setHasJacuzzi(boolean jacuzzi) {

            if (accommodationType == SUITE) {
                hasJacuzzi = jacuzzi;
            } else {
                System.out.println("Accommodation type must be Suite.");
            }

    }

    public boolean hasJacuzzi() {
        return hasJacuzzi;
    }


    public void setHasProjector(boolean projector) {

            if (accommodationType == CONFERENCE_ROOM) {
                hasProjector = projector;
            } else {
                System.out.println("Accommodation type must be Conference Room.");
            }

    }

    public boolean hasProjector() {
        return hasProjector;
    }


    public void setHasPool(boolean pool) {

            if (accommodationType == VILLA) {
                hasPool = pool;
            } else {
                System.out.println("Accommodation type must be Villa.");
            }

    }

    public boolean hasPool() {
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
