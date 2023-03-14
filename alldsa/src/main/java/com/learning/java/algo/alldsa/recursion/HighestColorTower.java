package com.learning.java.algo.alldsa.recursion;

import lombok.Data;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: Consider n boxes of different widths (w1...n), heights (h1...n),
 * and colors (c1...n). Find the highest tower of boxes that respects the following conditions:
 * You cannot rotate the boxes.
 * You cannot place two successive boxes of the same color.
 * Each box is strictly larger than the box above it in terms of their width and height.
 */
public class HighestColorTower {

    //recursion
    public static int getHighestTower(List<Box> boxes){
        if(boxes == null){
            return -1;
        }
        List<Box> sortedBoxes = boxes.stream().
                sorted(Comparator.comparing(Box::width).reversed()).collect(Collectors.toList());

        sortedBoxes.forEach(System.out::println);

        int maxHeight = 0;
        for(int i=0; i< sortedBoxes.size(); i++){
            int currentHeight = build(sortedBoxes, i);
            maxHeight = Math.max(currentHeight, maxHeight);
        }
        return maxHeight;
    }

    //recursion
    public static int build(List<Box> boxes, int base){
        Box current = boxes.get(base);
        int maxHeight = 0;

        for(int i = base+1; i< boxes.size(); i++){
            if(boxes.get(i).canBeNext(current)){
                int height = build(boxes,i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight = maxHeight + current.height();
        return maxHeight;
    }

    //memo
    public static int getHighestTowerMemo(List<Box> boxes){
        if(boxes == null){
            return -1;
        }
        List<Box> sortedBoxes = boxes.stream().
                sorted(Comparator.comparing(Box::width).reversed()).collect(Collectors.toList());

        sortedBoxes.forEach(System.out::println);

        int maxHeight = 0;
        int[] cache = new int[sortedBoxes.size()];
        for(int i=0; i< sortedBoxes.size(); i++){
            int currentHeight = buildMemo(sortedBoxes, i, cache);
            maxHeight = Math.max(currentHeight, maxHeight);
        }
        return maxHeight;
    }

    //memo
    public static int buildMemo(List<Box> boxes, int base, int[] cache){

        if(base < boxes.size() && cache[base] > 0){
            return cache[base];
        }

        Box current = boxes.get(base);
        int maxHeight = 0;

        for(int i = base+1; i< boxes.size(); i++){
            if(boxes.get(i).canBeNext(current)){
                int height = buildMemo(boxes,i,cache);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight = maxHeight + current.height();
        cache[base] = maxHeight;
        return maxHeight;
    }

    public static void main(String[] args){
        Box b1 = new Box(2,10,"red");
        Box b2 = new Box(10, 15, "green");
        Box b3 = new Box(5, 10, "blue");
        Box b4 = new Box(40, 10, "white");
        Box b5 = new Box(5, 8, "green");
        Box b6 = new Box(11, 14, "red");
        Box b7 = new Box(15, 20, "blue");
        Box b8 = new Box(20,30, "white");
        List<Box> boxes = Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8);
        int height = HighestColorTower.getHighestTower(boxes);
        System.out.println("height--->"+height);
    }

}


record Box(int width, int height, String color) {

    public boolean canBeNext(Box next){
        if(next == null){
            return false;
        }
        return (next.width > this.width && next.height > this.height && !next.color.equalsIgnoreCase(this.color));
    }
}

