package com.learning.java.java17.switches;

/**
 * -> and : are new features , with , we can use either -> or :
 */
public class Example {

    public static void main(String[] args) {
        String s = "Hello";
        switch (s) {
      case "Hello" -> {
        System.out.print("Bonjour "); // line n1
        System.out.print("Guten Tag ");
      }
      case "Goodbye" -> {
        int x = (int)Math.random();
      }

/*      case "Hello" ->
          System.out.print("Bonjour "); // line n1
          //System.out.print("Guten Tag ");
          default -> System.out.print("Bye");*/
        }

        switch(s) {
        //      case "Hello":
        //      case "Goodbye":
            case "Hello", "Goodbye":
                int x = 99;
        //        break;
            default:
                x = 100;
                System.out.println(x);
        }

        short val = 8;
        System.out.println(switch (val) { // line n1
            // line n2
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> {
                System.out.println("smallis number found");
                yield "It's 1 to 9";
            }
            default -> "It's something else";// default must be declared for all input possibilities
//      case 8 -> "It's something else";
//      default -> throw new IllegalStateException();
        });

        System.out.println("-----------------------");

        String message = switch (val) {
            case 1,2,3,4,5,6,7,8,9:
                yield "1 to 9";
            default:
                yield "Something else";
        };
        System.out.println("Message is " + message);
    }

}
