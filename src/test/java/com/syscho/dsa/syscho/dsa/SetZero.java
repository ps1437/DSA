package com.syscho.dsa;

//https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems/
public class SetZero {

    public static void main(String[] args) {


        int arr[][] = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
