package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

示例 2:

输入: s = "rat", t = "car"
输出: false
	 */
	public boolean isAnagram(String s, String t) {
		//先判断s,t的长度是否相等
		if(s.length()!=t.length()) return false;
		char[] s_arr=s.toCharArray();
		Arrays.sort(s_arr);
		char[] t_arr=t.toCharArray();
		Arrays.sort(t_arr);
		for(int i=0;i<s.length();i++) {
			if(s_arr[i]!=t_arr[i]) {
				return false;
			}
		}
		return true;
	}
}
