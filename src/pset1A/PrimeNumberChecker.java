package com.company;

import java.util.Date;

public class PrimeNumberChecker{

    private Boolean sad = true;
    public static int isPrime(int num){
        for(int i =2; i<num; i++){
            if (num % i == 0){
                System.out.println(i);
                return 0;
            }
        }
        return num;
    }
}
