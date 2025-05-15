package org.hotelbooking.core;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class Guest {
    private final String name;
    private String email;
    private LocalDate birthdate;

    public Guest(String name) {
        this.name = name;
    }

    public Guest(String name, String email, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nDate of Birth: "+ birthdate +"\nEmail: "+email;
    }

    public void displayInfo() {
        System.out.println(this);
    }
}



