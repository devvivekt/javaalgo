package com.learning.java.java17.nested;

public class Outer1 {
        //  public Outer1(Outer1 this) {}
        // javap -cp <my class path> -c nested.Outer1
        public void doStuff(Outer1 this, int x) {}

class Inner1 {
    public Inner1(Outer1 Outer1.this) {
        System.out.println(this);
    }
    //    private int x = 99;
    private int y = 100;
    // line n1
//    static Inner1 makeOne() { return /*Outer1.this.*/new Inner1(); }
//    void showX() {
//      System.out.println("x is " + x);
//    }
}
    private int x = 99;
    Inner1 makeOne() { return new Outer1().new Inner1(); }
    // line n2
//  void showAnotherY(Inner1 another) { sop("y is " + another.y); }
//  void showY() {
//    System.out.println("y is " + y);
//  }
}


//  and these method proposals:
//    void showX() { sop("x is " + x); }
//    void showY() { sop("y is " + y); }
//    void showAnotherY(Inner1 another) { sop("y is " + another.y); }
//static Inner1 makeOne() { return new Inner1(); }

//A) showX can be added at line n1
//    B) showY can be added at line n2
//    C) showAnotherY can be added at line n2
//    D) makeOne can be added at line n1
//    E) makeOne can be added at line n2
