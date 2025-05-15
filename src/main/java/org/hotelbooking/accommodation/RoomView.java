package org.hotelbooking.accommodation;

public enum RoomView {

    SEA_VIEW,
    PARTIAL_SEA_VIEW,
    MOUNTAIN_VIEW,
    GARDEN_VIEW,
    CITY_VIEW,
    POOL_VIEW;

    @Override
    public String toString() {
        return name().substring(0, 1) +
                name().substring(1).toLowerCase().replace('_', ' ');
    }
}
