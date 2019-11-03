package com.company;

public class Main {
    public static void main(String[] args) {

        rectangle2 re = new rectangle2(1,1,5,5);
        rectangle2 re2 = new rectangle2(1,1,4,4);
        System.out.println(re.contains(re2));
        MyRectangle2D r = new MyRectangle2D(1,1,5,5);
        MyRectangle2D r2 = new MyRectangle2D(1,1,4,4);
        System.out.println(r.contains(r2));
    }
}