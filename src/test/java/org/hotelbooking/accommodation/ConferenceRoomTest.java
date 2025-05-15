package org.hotelbooking.accommodation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConferenceRoomTest {
    Accommodation[] rooms = {
            new SingleRoom(0, 10.0, RoomView.CITY_VIEW),
            new ConferenceRoom(0, 10.0, 100, true)
    };

    @Test
    @DisplayName("Calculate price should multiply the price per night by the number of days for normal accommodations")
    public void testCalculatePrice() {
        assertEquals(40.0 ,rooms[0].calculatePrice(LocalDateTime.of(2025, 5, 1, 16, 0),
                LocalDateTime.of(2025, 5, 4, 16, 0)));
    }

    @Test
    @DisplayName("Calculate price should multiply the hourly rate by the number of hours for conference rooms")
    public void testCalculateConferenceRoomPrice() {
        assertEquals(40.0 ,rooms[1].calculatePrice(LocalDateTime.of(2025, 5, 1, 16, 0),
                LocalDateTime.of(2025, 5, 1, 20, 0)));
    }
}
