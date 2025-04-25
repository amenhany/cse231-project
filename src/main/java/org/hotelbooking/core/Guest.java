package org.hotelbooking.core;

public class Guest {
    String name ;
    int age ;
    char gender ;
    String email ;
    Guest spouse ;
    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("Email: "+email);
        System.out.println("Name: "+spouse.name);
        System.out.println("Age: "+spouse.age);
        System.out.println("Email: "+spouse.email);
    }
    public Guest getSpouse(){
        return spouse ;
    }
}
