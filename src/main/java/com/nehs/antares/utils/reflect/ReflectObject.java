package com.nehs.antares.utils.reflect;

/**
 * @author neHs
 */
public class ReflectObject {
    private String value;

    public ReflectObject() {
        value = "neHs";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
