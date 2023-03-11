package com.learning.java.algo.alldsa.recursion;

/**
 * Consider an amount of n cents. Count the ways you can change this amount
 * using any number of quarters (25 cents), dimes (10 cents),
 * nickels (5 cents), and pennies (1 cent).
 */
public class Coins {

    //recursion
    public static int calculateChange(int n){
        if(n <= 0){
            return -1;
        }
        int[] coins = {25, 10, 5, 1};
        return calculateChange(n, coins, 0);
    }

    private static int calculateChange(int amount, int[] coins, int position) {

        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChange(remaining, coins, position + 1);
        }

        return count;
    }
}
