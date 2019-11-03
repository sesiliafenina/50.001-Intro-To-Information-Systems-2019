package pset2A;


import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    private final String in;
    private static ArrayList<String> a = new ArrayList<>();
    // additional attribute if needed


    Permutation(final String str){
        in = str;
        // additional initialization if needed

    }

    public void permute(){
        permuteStr(in, "");
    }

    private static void permuteStr(String str, String result){
        if (str.length() == 0){
            a.add(result);
        }
         for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            String r = str.substring(0,i) + str.substring(i+1);

            permuteStr(r,result + c);
         }
    }
    public ArrayList<String> getA(){
        return a;
    }
}

