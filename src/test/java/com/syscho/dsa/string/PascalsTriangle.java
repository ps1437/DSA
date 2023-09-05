package com.syscho.dsa.string;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public static void main(String[] args) {

        generate(5);

    }
    public static List<List<Integer>> generate(int numRows) {

        int currentValue = 0;
        int sum = 0;
        List<List<Integer>> arrs = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> in = new ArrayList<>();

            for (int j = 1; j <= i ; j++) {
                in.add(j-i+1);
            }

            in.forEach(x -> System.out.print(x+","));
            System.out.println();
            arrs.add(in);

        }
        return arrs;

    }
}