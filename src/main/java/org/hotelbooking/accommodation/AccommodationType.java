package org.hotelbooking.accommodation;

public enum AccommodationType {

    SINGLE_ROOM,
    DOUBLE_ROOM,
    SUITE,
    CONFERENCE_ROOM,
    CHALET,
    VILLA;

    @Override
    public String toString() {
        return name().substring(0, 1) +
                name().substring(1).toLowerCase().replace('_', ' ');
    }
}
