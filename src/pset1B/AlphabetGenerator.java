package pset1B;

import java.util.HashMap;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * 
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     * 
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (29 As, indexes 0-28),
     *                "b", "b", ... (46 Bs, indexes 29-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     * 
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *   
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * 
     * If base < 0, return null.
     * 
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     * 
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
        if (base <0){
            return null;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Float> hashMap2 = new HashMap<>();

        for (String i : trainingData){
            for (char c : i.toCharArray()) {
                if ((c >= 'a' && c <= 'z')) {
                    if (!hashMap.containsKey(c)) {
                        hashMap.put(c, 1);
                    } else {
                        int value = hashMap.get(c) + 1;
                        hashMap.put(c, value);
                    }
                }
            }
        }
        int total_num = 0;
        float counter = 0f;
        for (int i : hashMap.values()){
            total_num += i;
        }
        for (char c : hashMap.keySet()){
            int value = hashMap.get(c);
            counter += ((double)value)/total_num;
            //System.out.println(counter * base);
            hashMap2.put(c, counter * base);
        }
        char[] result = new char[base];
        int con = 0;
        int a = 0;
        for (char c : hashMap2.keySet()){
            int roundDown = (int)Math.floor(hashMap2.get(c)) - a;
            System.out.println(roundDown);
            a += roundDown;
            for (int count = 0; count < roundDown; count++) {
                result[con] = c;
                con++;
                }
        }
        //System.out.println(result);
        return result;
        // trainingData = {"a", "a", "a", "b", "c", "d", "e", "f"}; and base 4 the output is a a c e
    }
}
