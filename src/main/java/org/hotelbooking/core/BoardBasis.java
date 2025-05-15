package org.hotelbooking.core;

public enum BoardBasis {
    ROOM_ONLY(0),
    BED_AND_BREAKFAST(100),
    HALF_BOARD(200),
    FULL_BOARD(300),
    ALL_INCLUSIVE(350);

    private final double price;

    private BoardBasis(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name().substring(0, 1) +
                name().substring(1).toLowerCase().replace('_', ' ');
    }
  }
