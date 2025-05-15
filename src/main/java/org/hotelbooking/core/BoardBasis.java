package org.hotelbooking.core;

public enum BoardBasis {
    ROOM_ONLY,
    BED_AND_BREAKFAST,
    FULL_BOARD,
    HALF_BOARD,
    ALL_INCLUSIVE;

    @Override
    public String toString() {
        return name().substring(0, 1) +
                name().substring(1).toLowerCase().replace('_', ' ');
    }
  }
