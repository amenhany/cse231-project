package org.hotelbooking.core;

public abstract class Room extends Accommodation {
    private int roomNumber;
    RoomView view;
    // snackInventory; snackInventory?? *megamind meme*
    // connectedRoom nullable? What is this sorcery


    Room(String accommodationId,double pricePerNight,double discount,int capacity,int roomNumber,RoomView view)
    {   super(accommodationId, pricePerNight, discount, capacity);
        this.roomNumber=roomNumber;
        this.view=view;
    }
    @Override
    public   boolean matches(AccommodationTemplate template){}  // ALRA7MA YA AMEN

    @Override
    public   void displayInfo(){

    };


    public  double getSnackBill(){};
    public  void refillSnacks(){};
}


