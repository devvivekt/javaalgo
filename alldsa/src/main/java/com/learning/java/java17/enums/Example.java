package com.learning.java.java17.enums;

//extends not allowed, implicitly extends java.lang.Enum
//constructor must be private
enum X {
    A, B;
    int x;
    public void incrementX() {
        x++;
    }
    // line n1
//  public String toString() { return name().toUpperCase(); }
//  @Override public String toString() { return name().toLowerCase(); }
//  public String name() { return super.name().toUpperCase(); }
//  public static String name() { return "x.name().toUpperCase()"; }
}
public class Example {

    public static void main(String[] args) {
        System.out.println(X.A);
        System.out.println(X.A.name());

        X anX = X.valueOf("A");
        System.out.println(anX);
    }
}
