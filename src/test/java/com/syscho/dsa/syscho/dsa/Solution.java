package com.syscho.dsa;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = findFirstIndex(nums, target);
        res[1] = findLastIndex(nums, target);

        return res;

    }

    int findLastIndex(int[] nums, int target) {
        int low = 0;
        int hi = nums.length - 1;
        int index = -1;
        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (target == nums[mid]) {
                index = mid;
            }

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return index;
    }

    int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int hi = nums.length - 1;
        int index = -1;
        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (target == nums[mid]) {
                index = mid;
            }

            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return index;
    }
}