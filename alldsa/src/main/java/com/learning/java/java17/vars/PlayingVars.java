package com.learning.java.java17.vars;

public class PlayingVars {

    //not allowed
    //var x = 99;

    //not allowed
    //void doStuff(var x){}

    //not allowed
    void doStuff(){
       //var x;
       // x = 100;
    }

    void doStuffnew(){
        var x = 100;

    }

    //type inference not allowed
    void dozStuffs(){
        //var x = {1,2,3,4}; //no double inferences
        var x = new int[]{1,2,3,4};
        //var v = null; cannot infer type
        for(var y = 0; y < 3; y++){
            System.out.println(y);
        }
    }
}
