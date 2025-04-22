package org.hotelbooking.core;
public abstract class Room extends Accommodation {
    private int roomNumber;
    RoomView view;
    // snackInventory; snackInventory?? *megamind meme*
   Room connectedRoom;

    Room(){

    }

    Room(double pricePerNight,int capacity,int roomNumber,RoomView view)
    {   super(pricePerNight,capacity);
        this.roomNumber=roomNumber;
        this.view=view;
        setAccommodationId("RM"+roomNumber);
    }

    @Override
    public   boolean matches(AccommodationTemplate template){
        return false;
    }

    @Override
    public   void displayInfo(){

    }

    public  double getSnackBill(){
        return 0.0;
    }

    public  void refillSnacks(){

    };
}


