package com.demo.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	/**
	 * 给定一个字符串S和T，在S中找到一个最小的子串包含T中的所有字符，时间复杂度为O(n)。
	 * 举例,
S = "ADOBECODEBANC"
T = "ABC"
最小子串是"BANC".
	 */
	
	public static String minWindow(String s, String t) {
//我们最开始先扫描一遍T，把对应的字符及其出现的次数存到HashMap中。
//然后开始遍历S，就把遍历到的字母对应的HashMap中的value减一，如果减1后仍大于等于0，cnt自增1。
//如果cnt等于T串长度时，开始循环，纪录一个字串并更新最小字串值。然后将子窗口的左边界向右移，如果某个移除掉的字母是T串中不可缺少的字母，那么cnt自减1，表示此时T串并没有完全匹配。
		if(s==null || t==null) return "";
		Map<Character, Integer> map=new HashMap<>();
		int left=0,right=0,min=Integer.MAX_VALUE,start=-1,count=0;
		
		for(int i=0;i<t.length();i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i))+1);
			}else{
				map.put(t.charAt(i), 1);
			}
		}
		
		while(right<s.length()) {
			if(!map.containsKey(s.charAt(right))) {
				right++;
				continue;
			}
			map.put(s.charAt(right), map.get(s.charAt(right))-1);
			if(map.get(s.charAt(right))==0) count++;
			while(count==map.size()) {
				int curlen=right-left+1;
				if(curlen<min) {
					start=left;
					min=curlen;
				}
				if(map.containsKey(s.charAt(left))) {
					map.put(s.charAt(left), map.get(s.charAt(left))+1);
					if(map.get(s.charAt(left))>0) {
						count--;
					}
				}
				left++;
			}
			right++;
		}
		if(start==-1) return "";
		return s.substring(start, start+min);
	}
	
	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t="ABC";
		System.out.println(minWindow(s, t));
	}
}
