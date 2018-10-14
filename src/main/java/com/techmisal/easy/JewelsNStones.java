package com.techmisal.easy;



/*

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.


 */

import java.util.HashMap;

public class JewelsNStones {


    public int numJewelsInStones(String J, String S) {

        HashMap<Character, Integer> hmap = new HashMap<>();


        int count = 0;

        for (int i = 0; i < S.length(); i++) {

            if (hmap.containsKey(S.charAt(i))) {
                hmap.put(S.charAt(i), hmap.get(S.charAt(i)) + 1);
            } else {
                hmap.put(S.charAt(i), 1);
            }

        }

        for (int j = 0; j < J.length(); j++) {
            if (hmap.containsKey(J.charAt(j))) {
                count += hmap.get(J.charAt(j));
            }

        }
        return count;
    }



}
