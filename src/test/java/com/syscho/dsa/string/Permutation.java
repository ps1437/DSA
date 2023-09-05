package com.syscho.dsa.string;

import java.util.HashSet;

//How do you find all the permutations of a string?
public class Permutation {


    static HashSet<String> perms = new HashSet<>();

    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String ans) {
        System.out.print(str + "->");
        if (str.isEmpty()) {
            System.out.print(ans + " ");
            perms.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            String mid = str.substring(0, i) + str.substring(i + 1);//ab
            permutation(mid, ans + charAt);
        }

    }

    public static void main(String[] args) {
        //ABC  ->a ,ab,ac ,b,ba,bc ,c,ca,cb
        permutation("abc"); // O(n2) space O(N)-Recusrion
    }
}

