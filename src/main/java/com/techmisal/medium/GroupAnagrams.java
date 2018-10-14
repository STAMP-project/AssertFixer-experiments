package com.techmisal.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, group anagrams together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<Map<Character, Integer>, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			Map<Character, Integer> mapOfS = getFreqMap(strs[i]);
			if(map.containsKey(mapOfS)) {
				ArrayList<String> value = map.get(mapOfS);
				value.add(strs[i]);
				map.put(mapOfS, value);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(mapOfS, list);
			}
		}
		return Arrays.asList(map.values().toArray(new ArrayList[0]));
	}

	public Map<Character, Integer> getFreqMap(String s) {
		Map<Character, Integer> mapOfS = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char chs = s.charAt(i);
			if (mapOfS.containsKey(chs)) {
				mapOfS.put(chs, mapOfS.get(chs) + 1);
			} else {
				mapOfS.put(chs, 1);
			}

		}
		return mapOfS;
	}
}