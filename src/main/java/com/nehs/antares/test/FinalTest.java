package com.nehs.antares.test;

import com.nehs.antares.entity.Employees;

public class FinalTest {
    private static final String finalString = "finalString";

    static final Employees employees = new Employees(123, "first", "last", "M");


    public static void main(String[] args) {
        System.out.println(finalString);
        employees.setLastName("modify123");
        employees.setFirstName("modify321");
        System.out.println(employees);
    }

}
