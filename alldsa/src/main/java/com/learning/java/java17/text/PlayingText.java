package com.learning.java.java17.text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayingText {

    public static void main(String[] args) {

        String message = """ 
       Hello\
       Java 17 World!""";
        System.out.println(message + "XXX");

        String message2 = """
        Hello
            Java 17 World!""";
        System.out.println(message2 + "XXX");
    }
}
