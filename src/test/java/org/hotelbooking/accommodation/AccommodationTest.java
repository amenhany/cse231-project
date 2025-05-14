package org.hotelbooking.accommodation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
