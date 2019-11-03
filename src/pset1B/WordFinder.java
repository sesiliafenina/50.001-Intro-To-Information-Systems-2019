package pset1B;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    /**
     * Given a String (the haystack) and an array of Strings (the needles),
     * return a Map<String, Integer>, where keys in the map correspond to
     * elements of needles that were found as substrings of haystack, and the
     * value for each key is the lowest index of haystack at which that needle
     * was found. A needle that was not found in the haystack should not be
     * returned in the output map.
     * 
     * @param haystack The string to search into.
     * @param needles The array of strings to search for. This array is not
     *                mutated.
     * @return The list of needles that were found in the haystack.
     */
    public static Map<String, Integer> getSubstrings(String haystack,
                                                     String[] needles) { 
        HashMap<String, Integer> result = new HashMap<>();
        for (String i : needles){
            Pattern pattern = Pattern.compile(i);
            Matcher matcher = pattern.matcher(haystack);
            if (matcher.find()){
                result.put(i,haystack.indexOf(i));
            }
        }
        return result;
    }
}
