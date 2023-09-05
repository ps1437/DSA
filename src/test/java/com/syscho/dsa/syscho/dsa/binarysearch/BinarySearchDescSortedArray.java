package com.syscho.dsa.binarysearch;

//conditions
// Sorted think about BS
// https://www.youtube.com/watch?v=YbkELwnGRdo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=4

//descending Sorted array
public class BinarySearchDescSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 4, 3, 2};

        int key = 52227;
        System.out.println(binarySearch0(arr, 0, arr.length, key));

    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
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
                high = mid - 1;
            else if (midVal > key)
                low = mid + 1;
            else
                return mid; // key found
        }
        return -1;  // key not found.
    }
}
