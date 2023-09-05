package com.syscho.dsa.binarysearch;

//conditions
// Sorted think about BS
// https://www.youtube.com/watch?v=QNGL_t_o_QA&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=2

import java.util.Arrays;
import java.util.stream.IntStream;

//Sorted array
public class BinarySearchRecursion {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 10).toArray();

        int searchValue = 4;
        System.out.println(binarySearch0(arr, 0, arr.length-1, searchValue));
    }

    private static int binarySearch0(int[] arr, int start, int end,
                                     int key) {

        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/ 2;


        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return binarySearch0(arr, start, mid - 1, key);
        }
        return binarySearch0(arr, mid + 1, end, key);
    }
}
