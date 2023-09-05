package com.syscho.dsa.binary;

class Solution {
    public int search(int[] nums, int key) {

        int low = 0;
        int hi = nums.length - 1;

        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (key == nums[mid]) {
                return mid;
            }

            if (nums[low] < nums[mid]) {
                if (key >= nums[low] && key < nums[mid]) {
                    hi = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {

                 if (key >nums[mid] && key <= nums[hi]) {
                    low = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
  int nums[] ={3,1};
  int key = 1;

        System.out.println(solution.search(nums,key));
    }
}