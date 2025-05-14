package org.hotelbooking.core;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class Guest {
    private final String name;
    private final String email;
    private final LocalDate birthdate;
    private final char gender;
    @Nullable private Guest spouse;


    public Guest(String name, String email, LocalDate birthdate, char gender) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Nullable public Guest getSpouse(){
        return spouse ;
    }

    public char getGender() {
        return gender;
    }


    public void setSpouse(@Nullable Guest spouse) {
        // If there was already a spouse, it will clear that person's spouse (so we do not get a love triangle)
        if (this.spouse != null) {
            this.spouse.spouse = null;
        }

        // Set our instance's spouse to the passed in Guest
        this.spouse = spouse;

        // Set the passed in Guest's spouse to be this instance
        if (spouse != null) {
            spouse.spouse = this;
        }
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nDate of Birth: "+ birthdate +"\nGender: "+gender+"\nEmail: "+email;
    }

    public void displayInfo() {
        System.out.println(this);
        if (spouse != null) {
            System.out.println("Spouse Info:");
            System.out.println(spouse);
        }
    }
}



