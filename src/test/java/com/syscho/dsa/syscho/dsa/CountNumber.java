package com.syscho.dsa;

public class CountNumber {
    public static void main(String[] args) {


        int num = 0;
        System.out.println(count(9820812, 0, 2));
    }

    private static int count(int n, int c, int target) {
        if (n == 0) {
            return c;
        }
        int rem = n % 10;

        if (rem == target) {
            return count(n / 10, c + 1, target);
        }
        return count(n / 10, c, target);
    }
}
