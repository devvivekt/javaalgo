package com.learning.java.java17.exceptions;

public class AutoClose implements AutoCloseable {
    private String name;
    public AutoClose(String name) { this.name = name; }
    @Override public void close() {
        System.out.print("Closing " + name);
    }
}
class Closing {
    public static void main(String[] args) {
        var ac0 = new AutoClose("zero");
        try (
                //will be closed third
                var ac1 = new AutoClose("one");
                //will be closed second
                var ac2 = new AutoClose("two");
                //will be closed first
                ac0;
        ) {
        }
    }
}


