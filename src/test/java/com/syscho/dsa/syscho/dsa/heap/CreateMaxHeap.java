package com.syscho.dsa.heap;

public class CreateMaxHeap {

    public static void main(String[] args) {
        int arr[] = {20, 10, 30, 5, 50, 40};
        createHeap(arr);
    }

    private static void createHeap(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(10);
        for (int a : arr) {
            maxHeap.insert(a);
        }
        maxHeap.print();
    }
}


class MaxHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    public void insert(int element) {
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }


    void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + heap[i]);

            if (leftChild(i)
                    < size) // if the child is out of the bound
                // of the array
                System.out.print(" Left Child Node: "
                        + heap[leftChild(i)]);

            if (rightChild(i)
                    < size) // if the right child index must not
                // be out of the index of the array
                System.out.print(" Right Child Node: "
                        + heap[rightChild(i)]);

            System.out.println(); // for new line
        }
    }

    // Method 1
    // Returning position of parent
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Method 2
    // Returning left children
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // Method 3
    // Returning right children
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }


    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }
}