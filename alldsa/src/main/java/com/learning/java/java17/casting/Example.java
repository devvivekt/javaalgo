package com.learning.java.java17.casting;

class Base{
    void doBaseStuff(){
        System.out.println("doBaseStuff");
        }
}

class Sub extends Base{
    void doBaseStuff(){
        System.out.println("doBaseStuff");
    }
    void dootherStuff(){
        System.out.println("doOtherStuff");
    }
}

class OddBall extends Sub implements Runnable{

    @Override
    public void run() {

    }
}

sealed class MySealedBase permits MySub, MyOddBall{
    void doBaseStuff(){
        System.out.println("doBaseStuff");
    }
}

final class MySub extends MySealedBase{
    void doBaseStuff(){
        System.out.println("doBaseStuff");
    }
    void dootherStuff(){
        System.out.println("doOtherStuff");
    }
}

final class MyOddBall extends MySealedBase{

}


/**
 * Sealed class will protect against runtime casting exception,
 * which were allowed in older jvm
 */
public class Example {

    public static void main(String[] args) {
        Base b = new Sub();

        // not allowed at runtime , compile time will pass
        ((Runnable) b).run();
        Base b1 = new OddBall();
        ((Runnable) b1).run();

        MySealedBase mySub = new MySub();

        MySealedBase myOddBall = new MyOddBall();
        // not allowed at compile time ((Runnable) myOddBall).run();
    }
}
