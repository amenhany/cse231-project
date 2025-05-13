package org.hotelbooking.accommodation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {
    Room room;

    @BeforeEach
    void setup() {
        room = new SingleRoom(0, 10.0, RoomView.CITY_VIEW);
    }

    @Test
    @DisplayName("The string provided should be found within the snack inventory map key and consumed by 1, then add its price to the snack bill")
    public void testConsumeSnack() {
        room.consumeSnack("Chocolate");
        assertEquals(3.0, room.getSnackBill());
    }

    @Test
    @DisplayName("Snack bill should keep count even after refilling snacks")
    public void testRefillSnack() {
        room.consumeSnack("Chips");
        room.consumeSnack("Chips");
        room.consumeSnack("Chips");
        room.consumeSnack("Chips");
        room.consumeSnack("Chips");
        assertEquals(5.0, room.getSnackBill(), "Before refill");
        assertEquals("Snack \"Chips\" is out of stock.",
                assertThrows(IllegalStateException.class, () -> room.consumeSnack("Chips")).getMessage());
        room.refillSnacks();
        assertEquals(5.0, room.getSnackBill(), "After refill");
        room.consumeSnack("Chips");
        assertEquals(6.0, room.getSnackBill(), "After refill and more consumption");
    }

    @Test
    @DisplayName("consumeSnack should throw an illegal argument exception if the snack is not from the default inventory")
    public void testConsumeInvalidSnack() {
        assertEquals("Snack \"Chip\" could not be found.",
                assertThrows(IllegalArgumentException.class, () -> room.consumeSnack("Chip")).getMessage());
    }
}
