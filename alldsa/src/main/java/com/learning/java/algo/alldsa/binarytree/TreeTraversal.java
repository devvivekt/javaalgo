package com.learning.java.algo.alldsa.binarytree;

import lombok.Data;

@Data
class Node{
    int data;
    Node left;
    Node right;

}
public class TreeTraversal {


    public void preOrderTraverse(Node node){
        if(node != null) {
            System.out.println(node.getData());
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }
    public void inOrderTraverse(Node node){
        if(node != null) {
            inOrderTraverse(node.left);
            System.out.println(node.getData());
            inOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node){
        if(node != null) {
            inOrderTraverse(node.left);
            inOrderTraverse(node.right);
            System.out.println(node.getData());
        }
    }

    public static void main(String[] args) {

    }

}
