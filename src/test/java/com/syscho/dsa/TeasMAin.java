package com;

public class TeasMAin {
    public static void main(String[] args) {

        int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0}; //10
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count += 1; //5
            }
        }
                          //10-5
        for(int i = 0;i< args.length -count ;i++){
            arr[i] = 0;
        }

        for(int i = args.length-1 - count;i< args.length ;i++){
            arr[i] = 1;
        }

    }
}
