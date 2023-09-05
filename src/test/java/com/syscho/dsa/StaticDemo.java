package com;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StaticDemo {


    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Static aStatic
                = new Static();
        System.out.println(aStatic.access());
    }
}


class Static {


    public int access() {
        try {
            throw new FileNotFoundException("DASd");
        } catch (IOException | IndexOutOfBoundsException | IllegalMonitorStateException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
return 121;
    }
}
