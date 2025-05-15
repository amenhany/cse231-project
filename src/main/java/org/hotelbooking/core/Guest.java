package org.hotelbooking.core;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class Guest {
    private final String name;
    private String email;


    public Guest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nEmail: "+email;
    }

    public void displayInfo() {
        System.out.println(this);
    }
}



