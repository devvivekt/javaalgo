package com.learning.java.algo.alldsa.ll;

public class ReverseLinkedList {

    private Node  first = null;
    ReverseLinkedList(Node node){
        this.first = node;
    }
    public Node reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static class Node {
        int value;
        Node next;
        Node (int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node curr = head;
        while (curr != null){
            System.out.println(curr.toString());
            curr = curr.next;
        }
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList(head);
        Node reversed = reverseLinkedList.reverseLinkedList(head);
        Node priRev = reversed;
        while (priRev != null){
            System.out.println(priRev.toString());
            priRev = priRev.next;
        }
    }
}


