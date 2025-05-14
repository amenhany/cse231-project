package org.hotelbooking.accommodation;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class Room extends Accommodation {

    private double snackBill = 0;
    public static final Map<Snack, Integer> DEFAULT_ROOM_INVENTORY = Map.of(
            new Snack("Chocolate", 3.00), 10,
            new Snack("Gummy Bears", 5.00), 5,
            new Snack("Chips", 1.00), 5
    );

    private Map<Snack, Integer> snackInventory;
    private RoomView view;
    @Nullable protected Room connectedRoom;


    protected Room(int roomNumber, double pricePerNight, int capacity, RoomView view) {
        super("RM" + roomNumber, pricePerNight, capacity);
        this.view=view;
        snackInventory = new HashMap<>(DEFAULT_ROOM_INVENTORY);
    }

    @Override
    public boolean matches(AccommodationTemplate template){
      return template.getView() == view;
    }

    public double getSnackBill(){
        return snackBill;
    }

    public void refillSnacks() {
        snackInventory = new HashMap<>(DEFAULT_ROOM_INVENTORY);
    }

    public void consumeSnack(String snackName) throws IllegalArgumentException, IllegalStateException {
        for (Map.Entry<Snack, Integer> entry : snackInventory.entrySet()) {
            if (snackName.equals(entry.getKey().name())) {
                if (entry.getValue() <= 0) throw new IllegalStateException("Snack \"" + snackName + "\" is out of stock.");
                else {
                    entry.setValue(entry.getValue() - 1);
                    snackBill += entry.getKey().pricePerUnit();
                }
                return;
            }
        }
        throw new IllegalArgumentException("Snack \"" + snackName + "\" could not be found.");
    }

    @Override
    public void displayInfo(){

    }


    private record Snack(String name, double pricePerUnit) {}

}
