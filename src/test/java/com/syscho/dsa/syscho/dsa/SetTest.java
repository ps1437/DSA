package com.syscho.dsa;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(22);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(1);
        set.add(1);
        set.add(22);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(1);
        set.add(22);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.forEach(integer -> {
            System.out.println(integer);
        });


    }
}
