package com.syscho.dsa.binarysearch;

//conditions
// Sorted think about BS
// https://www.youtube.com/watch?v=QNGL_t_o_QA&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=2

import java.util.stream.IntStream;

//Sorted array
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 10).toArray();

        int searchValue = 32312;

        System.out.println(binarySearch0(arr, 0, arr.length, searchValue));
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

            if (midVal == key) {
                return key;
            }
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;

        }
        return -1;  // key not found.
    }
}
