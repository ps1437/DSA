package com.syscho.dsa.linkedList;

import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {


        int j = 0;
        int A[] = {1, 8, 3, 0, 2, 0, 1, 10, 13, 0};
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] != 0) {
                A[j] = A[i];
                j = j + 1;
            }
        }
        while (j < n) {
            A[j] = 0;
            j = j + 1;
        }
        Arrays.stream(A).forEach(value -> System.out.println(value));
    }

    private static void swap(int first, int second) {
        int temp = first;
        // value of second is assigned to first
        first = second;
        // value of temp (initial value of first) is assigned to second
        second = temp;
    }

}
