package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	/**
	 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。

示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

	 */
	public static boolean wordBreak(String s,List<String> wordDict) {
		if(s.length()==0 || s==null) return false;
		boolean[] dp=new boolean[s.length()+1];		
		dp[0]=true;
		for(int i=0;i<s.length();i++) {
			//dp[i]表示的意思就是，s字符串0~i的子串是否能够符合要求
			if(!dp[i]) {
				continue;
			}
			for(String word:wordDict) {
				if(i+word.length()<=s.length() && s.substring(i, i+word.length()).equals(word)) {
					dp[i+word.length()]=true;
				}
			}
		}
		return dp[s.length()];
	}
	
	public boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] dp=new boolean[s.length()+1];
		dp[0]=true;
		for(int i=1;i<=s.length();i++) {
			for(int j=i-1;j>=0 && !dp[i]; j--) {
				String word=s.substring(j, i);
				dp[i]=dp[j] && wordDict.contains(word);
			}
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		String s="leetcode";
		List<String> wordDict=new ArrayList<>();
		String a="leet";String b="code";
		wordDict.add(a);
		wordDict.add(b);
		System.out.println(wordBreak(s, wordDict));
	}
}
