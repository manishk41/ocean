package com.ocean.multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Immutable Class
public final class Employee {

    private final String name;
    private final int age;
    private final List<String> skills;
    private final Date dateOfBirth; // mutable field

    public Employee(String name, int age, List<String> skills, Date dateOfBirth) {
        this.name = name;
        this.age = age;

        // Defensive copy to avoid external modification
        this.skills = new ArrayList<>(skills);

        // Defensive copy to avoid external modification
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        // Return a defensive copy, not internal list
        return new ArrayList<>(skills);
    }

    public Date getDateOfBirth() {
        // Return a defensive copy, never expose the original
        return new Date(dateOfBirth.getTime());
    }

    public static void main(String[] args) {

        Date dob = new Date();
        List<String> skills = List.of("A");
        Employee p = new Employee("John", 17, skills, dob);

        System.out.println("Original DOB: " + p.getDateOfBirth());

        // Try to mutate the original Date object
        dob.setTime(0);
        System.out.println("After modifying input Date: " + p.getDateOfBirth());

        // Try to mutate via getter
        p.getDateOfBirth().setTime(0);
        System.out.println("After modifying getter Date: " + p.getDateOfBirth());
    }
}
