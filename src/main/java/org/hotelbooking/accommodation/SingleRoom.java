package org.hotelbooking.accommodation;


import org.jetbrains.annotations.Nullable;

public class SingleRoom extends Room implements Connectable {


    public SingleRoom(int roomNumber, double pricePerNight, RoomView view){
        super(roomNumber, pricePerNight, 1, view);
    }

    @Override
    public void setConnectedRoom(Room x) {
        connectedRoom = x;
    }

    @Override
    public @Nullable Room getConnectedRoom() {
        return null;
    }


    @Override
    public boolean matches(AccommodationTemplate template) {
        return (template.getAccommodationType() == AccommodationType.SINGLE_ROOM) && (super.matches(template));
    }
}
