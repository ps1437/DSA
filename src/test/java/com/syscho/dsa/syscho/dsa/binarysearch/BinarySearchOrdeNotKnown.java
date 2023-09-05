package com.syscho.dsa.binarysearch;

//https://www.youtube.com/watch?v=gY2b-Q6wDEM&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=4

import java.util.stream.IntStream;

//Sorted but not sure in asc or in dsc
public class BinarySearchOrdeNotKnown {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 10).toArray();
        int[] descArr = {10, 9, 8, 7, 6, 4, 3, 2};

        int searchValue = 72;

        System.out.println("ASC :: " + checkOrderAndExecute(arr, searchValue));
        System.out.println("DESC :: " + checkOrderAndExecute(descArr, searchValue));
    }

    private static int checkOrderAndExecute(int[] arr, int searchValue) {

        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length > 2) {

            if (arr[0] < arr[1]) {
                return binarySearchAsc(arr, 0, arr.length, searchValue);
            } else {
                return binarySearchDesc(arr, 0, arr.length, searchValue);

            }
        }
        return -1;
    }

    private static int binarySearchAsc(int[] a, int fromIndex, int toIndex,
                                       int key) {


        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found.
    }

    private static int binarySearchDesc(int[] a, int fromIndex, int toIndex,
                                        int key) {

        if (a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return a[0];
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found.
    }
}
