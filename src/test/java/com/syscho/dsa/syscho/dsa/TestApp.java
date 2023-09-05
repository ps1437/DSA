package com.syscho.dsa;

import java.util.Collections;
import java.util.Optional;

public class TestApp {
    public static void main(String[] args) {

  Collections.emptyList().stream().filter(o -> true).findFirst().ifPresentOrElse(o -> {},()->{
            System.out.println("not prese");
        });


    }

    private static int expernd(String t, int begin, int end) {

        while(begin >=0 && end <t.length() && t.charAt(begin) == t.charAt(end)){
            begin--;
            end++;
        }
        return end -begin - 1;
    }
}
