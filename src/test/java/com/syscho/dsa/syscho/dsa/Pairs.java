package com.syscho.dsa;

//Reverse Pairs | Leetcode(HARD)
public class Pairs {

    public static void main(String[] args) {

        int a[] = {40, 25, 19, 12, 9, 6, 2};

        bruteForce(a);//O(n2)

    }

    private static void bruteForce(int[] a) {

        int count = 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length; j++) {

                if (a[i] > 2 * a[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
