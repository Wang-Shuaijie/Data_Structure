package com.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
	/**
	 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�

˵����

    �ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
    ����Լ����ֵ���û���ظ��ĵ��ʡ�

ʾ�� 1��

����:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
���:
[
  "cats and dog",
  "cat sand dog"
]

����:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
���:
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
