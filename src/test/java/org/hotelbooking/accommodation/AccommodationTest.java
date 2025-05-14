package org.hotelbooking.accommodation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccommodationTest {

    int oneNum(int num) {
        if (num < 0) return -1;
        else if (num > 0) return 1;
        else return 0;
    }

    @Test
    @DisplayName("Accommodation numbers should be prepended with 0s until 3 digits")
    public void testAccId (){
        Accommodation acc1 = new SingleRoom(1,1000,RoomView.SEA_VIEW);
        assertEquals("RM001", acc1.getAccommodationId());


        Accommodation acc2 = new SingleRoom(10,1000,RoomView.SEA_VIEW);
        assertEquals("RM010", acc2.getAccommodationId());
    }

    @Test
    @DisplayName("Accommodation numbers should be sorted ascendingly")
    public void testCompareTo (){
        Accommodation acc1 = new SingleRoom(1,1000,RoomView.SEA_VIEW);
        Accommodation acc2 = new SingleRoom(11,1000, RoomView.SEA_VIEW);

        assertEquals(-1, acc1.compareTo(acc2));
    }

    @Nested
    class ArrayTests {

        List<Accommodation> hotel = new ArrayList<>();

        @BeforeEach
        public void populateArray() {
            hotel.add(new Villa(1, 20, 3, false));                           // 4
            hotel.add(new Villa(0, 35, 5, true));                            // 3
            hotel.add(new DoubleRoom(1, 10, RoomView.GARDEN_VIEW, true));       // 1
            hotel.add(new SingleRoom(2, 15, RoomView.CITY_VIEW));                           // 2
            hotel.add(new DoubleRoom(0, 5, RoomView.GARDEN_VIEW, false));       // 0
            hotel.add(new Chalet(5, 25, 3, 2));
            hotel.add(new Chalet(2, 30, 4, 3));
            hotel.sort(null);
        }

        @Test
        public void testSort() {
            assertEquals("CH002", hotel.get(0).getAccommodationId());
            assertEquals("CH005", hotel.get(1).getAccommodationId());
            assertEquals("RM000", hotel.get(2).getAccommodationId());
            assertEquals("RM001", hotel.get(3).getAccommodationId());
            assertEquals("RM002", hotel.get(4).getAccommodationId());
            assertEquals("VL000", hotel.get(5).getAccommodationId());
            assertEquals("VL001", hotel.get(6).getAccommodationId());
        }

        @Test
        @DisplayName("matches method should return true if the accommodation has the same specifications")
        public void testMatches(){
            AccommodationTemplate template = new AccommodationTemplate(AccommodationType.DOUBLE_ROOM);
            template.setView(RoomView.GARDEN_VIEW);
            assertTrue(hotel.get(2).matches(template));
            assertFalse(hotel.get(3).matches(template));
            assertFalse(hotel.get(4).matches(template));

            template.setIsBedKingSize(true);
            assertFalse(hotel.get(2).matches(template));
            assertTrue(hotel.get(3).matches(template));
            assertFalse(hotel.get(4).matches(template));
        }
    }

}
