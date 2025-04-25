package org.hotelbooking.core;

public class Guest {
    private String name ;
    private int age ;
    private char gender ;
    private String email ;
    private Guest spouse ;

        @Override
        public String toString() {
            return "Name: "+name+"\nAge: "+age+"\nGender: "+gender+"\nEmail: "+email;
        }
    public void displayInfo() {
        System.out.println(this);
        if (spouse != null) {
            System.out.println("Spouse Info:");
            System.out.println(spouse.toString());
        }
        }
    public Guest getSpouse(){
        return spouse ;
    }
    }



