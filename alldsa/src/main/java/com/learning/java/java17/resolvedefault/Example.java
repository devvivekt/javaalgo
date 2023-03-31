package com.learning.java.java17.resolvedefault;

interface IntX {
    void doStuff();
//  default void doStuff() {
//    System.out.println("IntX.doStuff()");
//  }
}
interface IntY {
    default void doStuff() {
        System.out.println("IntY.doStuff()");
    }
    public static void badIdea2() {}
}
class ClQ implements IntX, IntY {
    @Override
    public void doStuff() {
//    IntX.super.doStuff();
        IntY.super.doStuff();
    }
    public static void badIdea() {}
}

public class Example {
    public static void main(String[] args) {
        ClQ c = new ClQ();
        c.badIdea(); // HORRIBLE IDEA, but legal FOR CLASS statics
//    c.badIdea2(); // not legal for interface static
        IntY.badIdea2();
    }
}