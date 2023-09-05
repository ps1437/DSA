package com.syscho.dsa.heap;

class Solution {

    public static void main(String[] args) {
        int arr[][] = {{1}, {1}};
        System.out.println(searchMatrix(arr, 2));
    }

    public static boolean searchMatrix(int[][] mat, int x) {

        // set indexes for top right
        int n = mat[0].length;
        int i = 0, j = n - 1;
        // element

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {

                return true;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        return false;


    }
}