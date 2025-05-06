package org.hotelbooking.accommodation;


public class SingleRoom extends Room implements Connectable {
    SingleRoom(int roomNumber, double pricePerNight, RoomView view){
        super(roomNumber, pricePerNight, 1, view);
    }

    @Override
    public void setConnectedRoom(Room x) {
        connectedRoom = x;
    }

    @Override
    public Room getConnectedRoom() {
        return connectedRoom;
    }
}
