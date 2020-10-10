package com.nehs.antares.utils.reflect;

public class reflectObject {
    private String value;

    public reflectObject() {
        value = "neHs";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
