package com.company;

public class PiGenerator {
    public static int powerMod(int a, int b, int m) {
        System.out.println(Math.pow(a,b));
        if (a < 0 && b%2!=0){
            return -((int)Math.pow(a,b)) % m;
        }

        if (b<0){
            /*
            int d = (1%m)/a;
            System.out.println(d);
            return ((int)Math.pow(d,-b)) % m;*/
            return -1;
        }
        return ((int)Math.pow(a,b)) % m;
    }
}