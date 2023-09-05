package com.syscho.dsa.binarysearch;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TestDat {
    public static void main(String[] args) {
        String expected = "2022-09-01T12:00:01Z";

        OffsetDateTime of = OffsetDateTime.of(LocalDateTime.parse(expected), ZoneOffset.UTC);
        System.out.println(of);

    }
}
