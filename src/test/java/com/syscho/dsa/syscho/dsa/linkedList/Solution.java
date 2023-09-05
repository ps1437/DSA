package com.syscho.dsa.linkedList;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(22);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("(((((("+slow.val);
        return slow;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }

    static public boolean isPalindrome(ListNode head) {

        if (null == head) {
            return false;
        }

        ListNode middleNode = middleNode(head);

        ListNode reverse = reverse(middleNode);
        ListNode currentNode = head;

        while (null != reverse) {
            if (currentNode.val != reverse.val) {
                return false;
            }
            reverse =reverse.next;
            currentNode =currentNode.next;


        }

        return true;
    }
}
