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

    /**
     *1-2-3-4-5-6-7 start=3,end=5
     * traget 1-2-5-4-3-6-7stat
     * resule
     * @param head
     * @param start
     * @param end
     * @return
     */
    public Node reverseLL(Node head, int start, int end){
        Node begin = head;
        Node currNode = head;
        int currPos = 1;
        while(currNode != null && currPos < start){
            begin = currNode;
            currNode = currNode.next;
            currPos++;
        }
        Node newList = null;
        Node tail = currNode;
        while(currNode != null && currPos >= start && currPos <= end){
            Node next = currNode.next;
            currNode.next = newList;
            newList = currNode;
            currNode = next;
            currPos++;
        }
        begin.next = newList;
        tail.next = currNode;
        if(start > 1){
            return head;
        }else{
            return newList;
        }
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

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        curr = head;
        while (curr != null){
            System.out.println(curr.toString());
            curr = curr.next;
        }

        reverseLinkedList = new ReverseLinkedList(head);
        reversed = reverseLinkedList.reverseLL(head, 3, 5);
        priRev = reversed;
        while (priRev != null){
            System.out.println(priRev.toString());
            priRev = priRev.next;
        }
    }
}


