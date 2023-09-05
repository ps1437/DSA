package com;

public class Overriding {

    public static void main(String[] args) {
        Long a = 1000l, b = 1000l;
        byte c = 127;
        byte e = 127;

        System.out.println((a == b));
        System.out.println((c == e));
    }

}

class Rev {

    void reverse(String str) {
        if ((str == null) || (str.length() <= 1))
            System.out.println(str);
        else {
            System.out.print(str.charAt(str.length() - 1));
            reverse(str.substring(0, str.length() - 1));
        }
    }
}


