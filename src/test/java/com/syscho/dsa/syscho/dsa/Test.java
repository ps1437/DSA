package com.syscho.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    // LOCATION_DOMICILES_CACHE  = [location ] [XXXXXXX] XXXXXX
    final static List<String> Monika = new ArrayList<>();
    final static List<String> praveen = new ArrayList<>();

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("dasd");
        list.add("dasdasd");
        list.add("xxxxxxxxxxxxxxxxx");
        System.out.println(list);
        list.add("Hi");
        list.removeAll(List.of("Hi"));
        System.out.println(list);


    }


}
