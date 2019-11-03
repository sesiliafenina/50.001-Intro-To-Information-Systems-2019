package com.company;

import java.util.*;

public class Pset2 {
    public static boolean isAllCharacterUnique(String sIn) {
        HashSet hashSet = new HashSet();
        char[] ch = sIn.toCharArray();
        for (char c : ch){
            if (!hashSet.add(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        List<String> ch1 = new ArrayList<>(Arrays.asList(sIn1.split("")));
        List<String> ch2 = new ArrayList<>(Arrays.asList(sIn2.split("")));
        Collections.sort(ch1);
        Collections.sort(ch2);
        System.out.println(ch1);
        System.out.println(ch2);
        for(int i = 0; i<ch1.size(); i++){
            if(!(ch1.get(i).equals(ch2.get(i)))){
                return false;
            }
        }
        return true;
    }
}
