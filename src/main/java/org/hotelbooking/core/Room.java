package org.hotelbooking.core;
public abstract class Room extends Accommodation {
    static private int numberOfRooms=0;
    private RoomView view;
    // snackInventory; snackInventory?? *megamind meme*
   protected Room connectedRoom;



    Room(double pricePerNight,int capacity,RoomView view)
    {   super(pricePerNight,capacity,"RM"+ ++numberOfRooms);
        this.view=view;
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


