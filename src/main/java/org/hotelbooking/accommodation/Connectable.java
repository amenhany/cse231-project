package org.hotelbooking.accommodation;

import org.jetbrains.annotations.Nullable;

public interface Connectable {
   void setConnectedRoom(Room x);
   @Nullable Room getConnectedRoom();
}
