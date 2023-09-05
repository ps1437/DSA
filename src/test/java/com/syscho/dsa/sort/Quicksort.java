package com.syscho.dsa.sort;

public class Quicksort {

    // method to find the partition position
    static int partition(int array[], int low, int high) {

        int pivot = array[high];

        int i = (low - 1);


        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {22, 21, -15, 45, 33, 56, 13, 87, -20};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}

