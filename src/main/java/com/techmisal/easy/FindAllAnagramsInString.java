package com.techmisal.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAllAnagramsInString {

	public List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> list = new ArrayList<>();

		if(p.length() > s.length() || s.length() == 0) {
			return list;
		}

		Map<Character, Integer> mapOfP = new HashMap<>();
		Map<Character, Integer> mapOfS = new HashMap<>();
		Set<Character> pChars = mapOfP.keySet();
		
		for (int i = 0; i < p.length(); i++) {
			char chp = p.charAt(i);
			if(mapOfP.containsKey(chp)) {
				mapOfP.put(chp, mapOfP.get(chp) + 1);
			} else {
				mapOfP.put(chp, 1);
			}
			
			char chs = s.charAt(i);
			if(mapOfS.containsKey(chs)) {
				mapOfS.put(chs, mapOfS.get(chs) + 1);
			} else {
				mapOfS.put(chs, 1);
			}
		}

		if(mapOfS.equals(mapOfP)) {
			list.add(0);
		}

		for (int i = p.length(); i < s.length(); i++) {
			
			char chs = s.charAt(i);
			if(mapOfS.containsKey(chs)) {
				mapOfS.put(chs, mapOfS.get(chs) + 1);
			} else {
				mapOfS.put(chs, 1);
			}
			
			char chx = s.charAt(i - p.length());
			if(mapOfS.containsKey(chx)) {
				int freq = mapOfS.get(chx);
				if(freq <= 1) {
					mapOfS.remove(chx);
				} else {
					mapOfS.put(chx, freq - 1);					
				}
			}

			if(pChars.contains(s.charAt(i)) && mapOfS.equals(mapOfP)) {
				list.add(i - p.length() + 1);
			}
		}

		return list;
	}
}