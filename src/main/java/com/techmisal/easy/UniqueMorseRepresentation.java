package com.techmisal.easy;


/*

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").

 We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

*/


import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentation {


    public int uniqueMorseRepresentations(String[] words) {


        String[] morseCodeArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> result = new HashSet<>();

        StringBuilder sb = null;


        for (String x : words) {

            char[] charArray = x.toCharArray();

            sb = new StringBuilder("");

            for (int i = 0; i < charArray.length; i++) {

                sb.append(morseCodeArray[charArray[i] - 'a']);

            }

            result.add(sb.toString());


        }


        return result.size();


    }


}
