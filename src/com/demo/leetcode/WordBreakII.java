package com.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
	/**
	 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

    分隔时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。

示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
	 */
	
	static HashMap<Integer,List<String>> map=new HashMap<>();
	//DFS
	public static List<String> wordBreak(String s, List<String> wordDict){
		return dfs(s,wordDict,0);
	}
	
	public static List<String> dfs(String s, List<String> wordDict, int start){
		if(map.containsKey(start)) {
			return map.get(start);
		}
		List<String> res=new ArrayList<>();
		if(start==s.length()) {
			res.add("");
		}
		for(int end=start+1;end<=s.length();end++) {
			if(wordDict.contains(s.substring(start, end))) {
				List<String> list=dfs(s,wordDict,end);
				for(String temp:list) {
					res.add(s.substring(start,end)+(temp.equals("")?"":" ")+temp);
				}
			}
		}
		map.put(start,res);
		return res;
	}


	public static void main(String[] args) {
		String s="catsanddog";
		List<String> wordDict=new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> res=wordBreak(s, wordDict);
		System.out.println(res.toString());
	}
}
