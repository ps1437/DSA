package com.syscho.dsa.binarysearch;

//conditions
// Sorted think about BS
// https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5

import java.util.Arrays;

public class BinarySearchFirstLastOccurance {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 10, 10, 10, 11};
        int searchValue = 10;
        int res[] = new int[2];

        res[0] = binarySearchFirstIndex(arr, 0, arr.length, searchValue);
        res[1] = binarySearchFirstLastIndex(arr, 0, arr.length, searchValue);
        System.out.println(Arrays.toString(res));
    }

    private static int binarySearchFirstLastIndex(int[] a, int fromIndex, int toIndex,
                                                  int key) {
        if (a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return a[0];
        }


        int low = fromIndex;
        int high = toIndex - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];


            if (midVal <= key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;

            if (midVal == key) {
                index = mid;
            }
        }
        return index;  // key not found.
    }

    private static int binarySearchFirstIndex(int[] a, int fromIndex, int toIndex,
                                              int key) {
        if (a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return a[0];
        }


        int low = fromIndex;
        int high = toIndex - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];


            if (midVal < key)
                low = mid + 1;
            else if (midVal >= key)
                high = mid - 1;

            if (midVal == key) {
                index = mid;
            }
        }
        return index;  // key not found.
    }
}
