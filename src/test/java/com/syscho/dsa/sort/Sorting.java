package com.syscho.dsa.sort;

public class Sorting {
    public static void main(String[] args) {
        int a[] = {22, 21, -15, 45, 33, 56, 13, 87, -20};

        int[] ints = sortArrays(a);
        for (int i : ints) {
            System.out.print(i + ",");
        }

    }

    public static int[] sortArrays(int[] arr) {

        // Finding the length of array 'arr'
        int length = arr.length;

        // Sorting using a single loop
        for (int j = 0; j < length - 1; j++) {

            // Checking the condition for two
            // simultaneous elements of the array
            if (arr[j] > arr[j + 1]) {

                // Swapping the elements.
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                // updating the value of j = -1
                // so after getting updated for j++
                // in the loop it becomes 0 and
                // the loop begins from the start.
                j = -1;
            }
        }

        return arr;
    }
}
