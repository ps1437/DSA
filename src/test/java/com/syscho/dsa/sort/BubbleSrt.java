package com.syscho.dsa.sort;

public class BubbleSrt {
    public static void main(String[] args) {
        int arr[] = {22, 21, -15, 45, 33, 56, 13, 87, -20};

        sort(arr);

        for (int i : arr) {
            System.out.print(i + ",");
        }

    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 8
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) { // 22<21
                    int t = arr[i];  // 22
                    arr[i] = arr[j]; //21 =22
                    arr[j] = t;       //22 =21
                }
            }
        }
    }
}
