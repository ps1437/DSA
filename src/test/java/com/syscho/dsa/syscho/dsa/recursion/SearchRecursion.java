package com.syscho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SearchRecursion {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 8, 8, 1, 2};
        int target = 8;
        System.out.println(ElementExist(arr, 0, target));
        System.out.println(findFirstIndex(arr, 0, target));
        System.out.println(findLastIndex(arr, arr.length - 1, target));
        ArrayList<Integer> arrayList = new ArrayList<>();
        findBothIndex(arr, 0, target, arrayList);
        System.out.println(arrayList);
    }

    private static boolean ElementExist(int[] arr, int index, int target) {

        if (index == arr.length) {
            return false;
        }

        return (arr[index] == target) || ElementExist(arr, index + 1, target);
    }

    private static int findFirstIndex(int[] arr, int index, int target) {

        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findFirstIndex(arr, index + 1, target);
    }

    private static void findBothIndex(int[] arr, int index, int target, List<Integer> all) {

        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            all.add(index);
        }
        findBothIndex(arr, index + 1, target, all);
    }

    private List<Integer> findAllIndex(int[] arr, int index, int target, List<Integer> all) {

        if (index == arr.length) {
            return all;
        }
        if (arr[index] == target) {
            all.add(index);
        }
        return findAllIndex(arr, index + 1, target, all);
    }

    private static int findLastIndex(int[] arr, int index, int target) {

        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findLastIndex(arr, index - 1, target);
    }
}
