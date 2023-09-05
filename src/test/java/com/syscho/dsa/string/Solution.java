package com.syscho.dsa.string;

class Solution {
    public int[] productExceptSelf(int[] nums) {


        int[] productArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int product = 1;


            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                }

            }
            productArray[i] = product;
        }
        return productArray;
    }

    public static void main(String[] args) {

    }
}
