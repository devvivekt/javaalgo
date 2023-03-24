package com.learning.java.java17.patterns;

import java.util.Collection;
import java.util.List;

public class InstanceOfStuff {

    public static void main(String[] args) {
        Object obj = 99;
        // if (obj instanceof String) {
        //String str = (String) obj;
        if (obj instanceof String str) {
            if (str.length() > 3) {
                System.out.println(str);
            } else {
                System.out.println("Too short");
            }
//    } else {
//      System.out.println("it's not a String " + str);
        }

        if (!(obj instanceof String str) || str.length() > 3) {
            System.out.println("not string, and or not longer than 3 chars");
        } else {
            System.out.println(str);
        }

        /**
        {
            if (!(obj instanceof String str)) throw new IllegalStateException();
            str.length();
        }
         **/

        Object many = List.of(1,2,3);
        if (many instanceof List) {} // OK
        if (many instanceof List<?>) {} // OK
        //    if (many instanceof List<Integer>) {} // NOT OK

        Collection<Integer> ci = (Collection<Integer>)many;
        //    if (ci instanceof List<Integer>) {} // OK, in Java 17
        if (ci instanceof List<Integer> li) {// OK, in Java 17
            Integer i = li.get(0);
        }
    }
}
