package com.demo.LeetCode;

public class FirstUniqueCharacterinaString {
	/**
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

	 */
	public int firstUniqChar(String s) {
		//用一个数组存放每个字符出现的次数
		int[] nums=new int[256];
		for(int i=0;i<s.length();i++) {
			nums[s.charAt(i)-'a']++;
		}
		for(int i=0;i<s.length();i++) {
			if(nums[s.charAt(i)-'a']==1) {
				return i;
			}
		}
		return -1;
	}
}
