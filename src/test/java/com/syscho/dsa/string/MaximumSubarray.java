package com.syscho.dsa.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/maximum-subarray/submissions/839310075/
public class MaximumSubarray {
    @Test
    public static void main(String[] args) {
        int nums[] =
                {
                        -2, 1, -3, 4, -1, 2, 1, -5, 4
                };

        int actual = maxSubarry(nums);
        System.out.println(actual);
        Assertions.assertEquals(6, actual);
    }

    private static int maxSubarry(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int curr = 0;
        for (int i : nums) {

            if (curr < 0) {
                curr = 0;
            }
            curr += i;

            maxSum = Math.max(curr, maxSum);

        }
        return maxSum;
    }
}
