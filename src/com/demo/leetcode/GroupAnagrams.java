package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	/**
	 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
	 */
	//time:O(n*n*logn) space:O(n)
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> res=new ArrayList<>();
		if(strs==null || strs.length==0) return res;
		HashMap<String, Integer> map=new HashMap<>();
		for(String str:strs) {
			char[] ch=str.toCharArray();
			Arrays.sort(ch);
			String s=new String(ch);
			if(map.containsKey(s)) {
				List<String> list=res.get(map.get(s));
				list.add(str);
			}else {
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(s, res.size());
				res.add(list);
			}
		}
		return res;
	}
	//time:O(n*n) space:O(n)
	public static List<List<String>> groupAnagrams2(String[] strs){
		HashMap<String, List<String>> map=new HashMap<>();
		for(String str:strs) {
			int[] count=new int[26];
			for(Character ch:str.toCharArray()) {
				count[ch-'a']++;
			}
			String s="";
			for(int i=0;i<count.length;i++) {
				if(count[i]!=0) {
					s+=String.valueOf(count[i])+String.valueOf((char)i+'a');
				}
			}
			if(map.containsKey(s)) {
				List<String> list=map.get(s);
				list.add(str);
			}else {
				List<String> list=new ArrayList<>();
				list.add(str);
				map.put(s, list);
			}
		}
		return new ArrayList<>(map.values());
	}
	
	
	
	public static void main(String[] args) {
		String[] strs=new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res=groupAnagrams2(strs);
		System.out.println(res.toString());
	}
	
}
