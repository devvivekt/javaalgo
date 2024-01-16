package com.learning.java.algo.alldsa.ll;

public class FlattenDllWithChild {

    private ListNode listNode;
    public FlattenDllWithChild(ListNode listNode){
        this.listNode = listNode;
    }

    public ListNode flattenDLL(ListNode head){
        if(head == null){
            return head;
        }
        ListNode currNode = head;
        while(currNode != null){
            if(currNode.child == null){
                currNode = currNode.next;
            } else {
                ListNode tail = currNode.child;
                while(tail.next != null){
                    tail = tail.next;
                }
                tail.next = currNode.next;
                if(tail.next != null){
                    tail.next.prev = tail;
                }
                currNode.next = currNode.child;
                currNode.next.prev = currNode;
                currNode.child = null;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.prev = listNode1;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        listNode3.prev = listNode2;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.prev = listNode3;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode5.prev = listNode4;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        listNode6.prev = listNode5;
        ListNode listNode7 = new ListNode(7);
        listNode2.child = listNode7;
        listNode7.prev = listNode2;
        ListNode listNode8 = new ListNode(8);
        listNode7.next = listNode8;
        listNode8.prev = listNode7;
        ListNode listNode9 = new ListNode(9);
        listNode8.next = listNode9;
        listNode9.prev = listNode8;
        ListNode listNode10 = new ListNode(10);
        listNode8.child = listNode10;
        listNode10.prev = listNode8;
        ListNode listNode11 = new ListNode(11);
        listNode10.next = listNode11;
        listNode11.prev = listNode10;
        ListNode listNode12 = new ListNode(12);
        listNode5.child = listNode12;
        listNode12.prev = listNode5;
        ListNode listNode13 = new ListNode(13);
        listNode12.next = listNode13;
        listNode13.prev = listNode12;

        FlattenDllWithChild flattenDllWithChild = new FlattenDllWithChild(listNode1);
        ListNode head = flattenDllWithChild.flattenDLL(listNode1);
        ListNode curr = head;
        while(curr != null){
            System.out.println(curr);
            curr = curr.next;
        }




    }

    static class ListNode{
         int val;
         ListNode next;
         ListNode prev;
         ListNode child;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
