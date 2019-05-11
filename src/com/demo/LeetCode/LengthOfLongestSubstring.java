package com.demo.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	/**
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 * 输入: "abcabcbb"输出: 3 
	 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 */

	public int lengthOfLongestSubstring(String s) {
		//判断字符串是否为空
		if(s == null || s.length() == 0) return 0;
		HashMap<Character, Integer> map=new HashMap<>();
		int res=0;
		//i是遍历数，j表示重复的起点
		/*
		 * a b c a b c 
		 * i=0,j=0
		 * i=1,j=0
		 * i=2,j=0
		 * i=3,j=1
		 * i=4,j=2
		 * i=5,j=3
		 */
		for (int i=0,j=0;i<s.length();i++) {
			//如果查找到相同元素，取出该元素所在下标，并+1
			if(map.containsKey(s.charAt(i))) {
				j=Math.max(j, map.get(s.charAt(i))+1);
			}
			//把遍历过的字符放在hashmap中
			map.put(s.charAt(i), i);	
			res=Math.max(res, i-j+1);
		}
		return res;
	}
	
	//HashSet<E>写法
	public static int lengthOfLongestSubstring2(String s) {
		//判断字符串是否为空
		if(s == null || s.length() == 0) return 0;
		int res=0;
		HashSet<Character> set=new HashSet<>();
		
		int i=0,j=0;
		/*把出现过的字符都放入set中，遇到set中没有的字符就加入set中并更新结果res，
		 * 如果遇到重复的，则从左边开始删字符，直到删到重复的字符停止
		 */
		while(i<s.length()&&j<s.length()) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(j));
				j++;
			}else {
				set.add(s.charAt(i));
				i++;
				res=Math.max(res,set.size());
			}
		}
		
		return res;
	}
	

	public static void main(String[] args) {
		String s="abcbb";
		System.out.println(lengthOfLongestSubstring2(s));
	}

}
