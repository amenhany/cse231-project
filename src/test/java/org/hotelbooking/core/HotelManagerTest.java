package org.hotelbooking.core;

import org.hotelbooking.accommodation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelManagerTest {

    HotelManager hotel = new HotelManager();

    /* #################### addAccommodation Tests #################### */

    @Test
    @DisplayName("Adding an accommodation with a duplicate ID should be refused")
    public void testDuplicateAccommodation() {
        hotel.addAccommodation(new SingleRoom(0, 10, RoomView.GARDEN_VIEW));
        assertThrows(IllegalArgumentException.class, () -> hotel.addAccommodation(new SingleRoom(0, 15, RoomView.POOL_VIEW)));
    }

    @Test
    @DisplayName("Accommodations with a negative price should not be added")
    public void testNegativePricedAccommodation() {
        HotelManager hotel = new HotelManager();
        assertThrows(IllegalArgumentException.class, () -> hotel.addAccommodation(new SingleRoom(0, -15, RoomView.POOL_VIEW)));
    }


    @Nested
    @DisplayName("Tests with a populated hotel")
    class PopulatedTests {


        /* ######################## checkin Tests ######################## */

        AccommodationTemplate desiredAccommodation;
        Booking booking1;

        Guest user1 = new Guest("Ahmad");
        Guest user2 = new Guest("Mohamed");
        Guest user3 = new Guest("Sarah");
        Guest user4 = new Guest("Laila");

        @BeforeEach
        public void populateHotel() {
            hotel = new HotelManager();
            hotel.addAccommodation(new Villa(1, 20, 3, false));
            hotel.addAccommodation(new Villa(0, 30, 5, false));
            hotel.addAccommodation(new DoubleRoom(1, 10, RoomView.GARDEN_VIEW, true));
            hotel.addAccommodation(new SingleRoom(2, 15, RoomView.CITY_VIEW));
            hotel.addAccommodation(new DoubleRoom(0, 5, RoomView.GARDEN_VIEW, false));

            desiredAccommodation = new AccommodationTemplate(AccommodationType.DOUBLE_ROOM);
            desiredAccommodation.setView(RoomView.GARDEN_VIEW);
            desiredAccommodation.setIsBedKingSize(true);

            booking1 = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 2, 13, 0), LocalDateTime.of(2025, 5, 4, 11, 0), PaymentMethod.CASH);
            booking1.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            hotel.checkin(booking1);
        }

        @Test
        @DisplayName("Check-in should return the Accommodation with the desired traits")
        public void testCheckin() {
            assertEquals("RM001", booking1.getAccommodation().getAccommodationId());
        }

        @Test
        @DisplayName("An IllegalStateException will be thrown if the accommodation is taken during the specified time")
        public void testCheckinDateConflict() {
            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 3, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            assertThrows(IllegalStateException.class, () -> hotel.checkin(booking));
        }

        @Test
        @DisplayName("Edge case of check-in with the same start date")
        public void testCheckinEdgeStart() {
            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 2, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            assertThrows(IllegalStateException.class, () -> hotel.checkin(booking));
        }

        @Test
        @DisplayName("Edge case of check-in with the same end date")
        public void testCheckinEdgeEnd() {
            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 1, 13, 0), LocalDateTime.of(2025, 5, 4, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            assertThrows(IllegalStateException.class, () -> hotel.checkin(booking));
        }

        @Test
        @DisplayName("Checking in the same day as check-out of another booking should be fine")
        public void testCheckinSameDayOfCheckout() {
            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 4, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            hotel.checkin(booking);
            assertEquals("RM001", booking.getAccommodation().getAccommodationId());
        }

        @Test
        @DisplayName("You should not be able to check in with the same booking twice")
        public void testCheckinTwice() {
            assertThrows(IllegalArgumentException.class, () -> hotel.checkin(booking1));
        }

        @Test
        @DisplayName("checkin should look for an available accommodation if it found the first one unavailable")
        public void testCheckinAfterUnavailable() {
            hotel.addAccommodation(new DoubleRoom(3, 12, RoomView.GARDEN_VIEW, true));

            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 3, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            hotel.checkin(booking);
            assertEquals("RM003", booking.getAccommodation().getAccommodationId());
        }

        @Test
        @DisplayName("checkin should look for an available accommodation with the least capacity overflow")
        public void testCheckinForMinCapacity() {
            AccommodationTemplate template = new AccommodationTemplate(AccommodationType.VILLA);
            Booking booking = new Booking(template, BoardBasis.FULL_BOARD, new Guest[]{user1, user2, user3},
                    LocalDateTime.of(2025, 5, 3, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            // VL000 comes before VL001 but VL001 will be chosen as it has a smaller capacity that still fits our guests
            hotel.checkin(booking);
            assertEquals("VL001", booking.getAccommodation().getAccommodationId());
        }

        @Test
        @DisplayName("checkin should look for an available accommodation that can fit all the guests")
        public void testCheckinForManyGuests() {
            AccommodationTemplate template = new AccommodationTemplate(AccommodationType.VILLA);
            Booking booking = new Booking(template, BoardBasis.FULL_BOARD, new Guest[]{user1, user2, user3, user4},
                    LocalDateTime.of(2025, 5, 3, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            hotel.checkin(booking);
            assertEquals("VL000", booking.getAccommodation().getAccommodationId());
        }


        /* ######################## checkout Tests ######################## */

        @Test
        @DisplayName("Checkout should return a receipt with the correct total bill, remove the booking and reset the snacks")
        public void testCheckout() {
            ((Room)booking1.getAccommodation()).consumeSnack("Chocolate");
            ((Room)booking1.getAccommodation()).consumeSnack("Chips");
//            assertEquals(1, hotel.bookings.size());
            assertEquals(14, hotel.checkout(booking1).getTotal());
//            assertEquals(0, hotel.bookings.size());


            Booking booking = new Booking(desiredAccommodation, BoardBasis.FULL_BOARD, new Guest[]{user1, user2},
                    LocalDateTime.of(2025, 5, 4, 13, 0), LocalDateTime.of(2025, 5, 6, 11, 0), PaymentMethod.CASH);
            booking.setStatus(BookingStatus.CONFIRMED_PAYMENT);

            hotel.checkin(booking);
            assertEquals(10, hotel.checkout(booking).getTotal());
        }
    }
}