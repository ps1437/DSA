package com.syscho.dsa.bits;

//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
public class UniqueNumbers {

    public static void UniqueNumbers2(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum ^ arr[i]);
        }
        sum = (sum & -sum);
        int sum1 = 0;
        int sum2 = 0;

        // traversing the array again
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & sum) != 0) {
                System.out.println(arr[i]);
                sum1 = (sum1 ^ arr[i]);
            } else {
                sum2 = (sum2 ^ arr[i]);
            }
        }
        System.out.println("The non-repeating elements are "
                + sum1 + " and " + sum2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 9, 11, 2, 3, 11};
        int n = arr.length;
        UniqueNumbers2(arr, n);
    }
}

