package com.syscho.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergInterval {
    public int[][] merge(int[][] intervals) {


        List<int[]> ar = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {

            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                ar.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ar.add(new int[]{start, end});
        return ar.toArray(new int[0][]);
    }
}