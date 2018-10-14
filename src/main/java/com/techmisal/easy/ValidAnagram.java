package com.techmisal.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length())
			return false;
		
		Map<Character, Integer> mapOfS = new HashMap<>();
		Map<Character, Integer> mapOfT = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char chs = s.charAt(i);
			if(mapOfS.containsKey(chs)) {
				mapOfS.put(chs, mapOfS.get(chs) + 1);
			} else {
				mapOfS.put(chs, 1);
			}
			
			char cht = t.charAt(i);
			if(mapOfT.containsKey(cht)) {
				mapOfT.put(cht, mapOfT.get(cht) + 1);
			} else {
				mapOfT.put(cht, 1);
			}
		}
		
		return mapOfS.equals(mapOfT);
	}
}