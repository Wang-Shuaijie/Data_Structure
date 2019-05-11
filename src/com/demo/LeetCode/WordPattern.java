package com.demo.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
	/**
	 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
	 */
	public static boolean wordPatter(String pattern, String str) {
		String[] words=str.split(" ");
		if(words.length!=pattern.length()) {
			return false;
		}
		Map<Character, Integer> map=new HashMap<>();
		//set不能存放重复元素
		Set<String> set=new HashSet<>();
		for(int i=0;i<words.length;i++) {
			if(set.contains(words[i]) && !map.containsKey(pattern.charAt(i))) {
				return false;
			}
			if(!set.contains(words[i]) && map.containsKey(pattern.charAt(i))) {
				return false;
			}
			map.put(pattern.charAt(i), i);
			set.add(words[i]);
		}
		return true;
 	}
	
	
	public static void main(String[] args) {
		String pattern="abba";
		String str="dog cat cat dog";
		System.out.println(wordPatter(pattern, str));
	}
}
