package com.syscho.dsa.string;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargetELement {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"3", "4", "1", "5", "11", "33", "51", "234"}, 1));

        System.out.println(findKthLargest(new int[]{3, 4, 1, 5, 11, 33, 51, 234}, 1));
        System.out.println(findKthSmallest(new int[]{3, 4, 1, 5, 11, 33, 51, 234}, 2));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        if (nums == null || nums.length == 0)
            return "";
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() == s2.length())
                return s1.compareTo(s2);
            else
                return Integer.compare(s1.length(), s2.length());
        });
        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());

        for (int v : nums) {
            integers.add(v);

            if (integers.size() > k) {
                integers.poll();
            }
        }

        return integers.peek();
    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();

        for (int v : nums) {

            integers.offer(v);

            if (integers.size() > k) {
                integers.poll();
            }
        }

        return integers.peek();
    }
}
