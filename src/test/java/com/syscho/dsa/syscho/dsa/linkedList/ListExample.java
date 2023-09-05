package com.syscho.dsa.linkedList;


import java.util.LinkedList;

class MyList<E> {

    Node<E> head;
    private int size;

    public void addFirst(E data) {
        Node newNode = new Node<E>(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(E data) {
        Node newNode = new Node<E>(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("empty list nothing to delete");
            return;
        }
        size--;
        head = this.head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("empty list nothing to delete");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node currNode = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;
    }

    public E removeIndex(int index) {
        if (index > size || index < 0) {
            System.out.println("ind out of bound");
            return null;
        }

        Node currentNode = head;

        if (index == 0) {
            head = currentNode.next;
            return (E) currentNode.data;
        }

        Node temp = null;
        for (int i = 1; i <= index; i++) {
            temp = currentNode;
            currentNode = currentNode.next;
        }

        if (null != currentNode) {
            temp.next = currentNode.next;
            return (E) currentNode.data;
        }
        size--;
        return (E) temp.data;
    }

    public E peek() {
        final Node<E> f = head;
        return (f == null) ? null : f.data;
    }


    public Node reverse() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return null;
    }

    public void printIndex(int index) {

        if (index > size || index < 0) {
            System.out.println("ind out of bound");
            return;
        }

        Node currentNode = head;

        if (index == 0) {
            System.out.println(head.data);
        }

        Node temp = null;
        for (int i = 1; i <= index; i++) {
            temp = currentNode;
            currentNode = currentNode.next;
        }
        if (null != currentNode.next) {
            temp.next = currentNode.next;
        }
        System.out.println(currentNode.data);
    }

    class Node<T> {
        T data;
        Node<T> next;
        Node(){}
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    void print() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public Node removeNthFromEnd(Node head, int n) {
        //12345 -4
        Node start = new Node();
        start.next = head;  //1
        Node fast = start; //1
        Node slow = start;    //1

        for(int i = 1; i <= n; ++i)
            fast = fast.next; // 4

        while(fast.next != null)
        {
            fast = fast.next; //5,6
            slow = slow.next;//123
        }
        //5
        slow.next = slow.next.next;

        return start.next;
    }
}

public class ListExample {
    public static void main(String[] args) {
        MyList list = new MyList<String>();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        list.printIndex(0);
    }


}
