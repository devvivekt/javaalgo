package com.learning.java.java17.intern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StringInterning {

    static String greet = "Hello";
    int x = 98;

    public static void  showIt(){
        int x = 99;
        System.out.println("value of x is "+x);
    }
    public static void main(String[] args) {
        String s1 = "Hello";

        StringInterning.showIt();


        String s2 = "He";
        // creates a new string even though we know it's a duplicate!!
        s2 = s2 + "llo";
        System.out.println(s2);
        System.out.println("Hello" == s2);
        System.out.println("Hello" == s1);
        // If you will have lots of duplicates, then there is benefit
        // to pooling identical values as a single object
        // do this with "intern()"
        // if s2 finds a match (equals) in the constant pool,
        // intern returns that pooled object
        String s3 = s2.intern();
        System.out.println("Hello" == s3);

        String x1 = "He";
        x1 = x1 + "llo World!";
        String x2 = x1.intern();
        System.out.println("x1 == x2? " + (x1 == x2));

        StringBuilder d = new StringBuilder("Hello");
        StringBuilder s = new StringBuilder("He");
        s.append("llo");
        System.out.println("StringBuilderequals"+d.equals(s));

        List<String> ls = List.of("Java","Python");
        List<String> ls2 = new ArrayList<>(ls);
        System.out.println("listquuals"+ls.equals(ls2));

        LocalDate ld = LocalDate.of(2023,3,23);
        LocalDate ld2 = LocalDate.of(2023,3,23);
        System.out.println("localDateEquals"+ld.equals(ld2));

        //bitwiase -1 is all bit 11111
        int x = -1;
        System.out.println(x & 5);


        //short circuit operation
        System.out.println(v1() || v2() );
        System.out.println(v2() || v1() );

    }

    public static boolean v1(){
        return true;
    }

    public static boolean v2(){
        throw new RuntimeException();
    }
}
