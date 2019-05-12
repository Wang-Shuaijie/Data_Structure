package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	/**
	 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�

˵����

    ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
    ����Լ����ֵ���û���ظ��ĵ��ʡ�

ʾ�� 1��

����: s = "leetcode", wordDict = ["leet", "code"]
���: true
����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��

	 */
	public static boolean wordBreak(String s,List<String> wordDict) {
		if(s.length()==0 || s==null) return false;
		boolean[] dp=new boolean[s.length()+1];		
		dp[0]=true;
		for(int i=0;i<s.length();i++) {
			//dp[i]��ʾ����˼���ǣ�s�ַ���0~i���Ӵ��Ƿ��ܹ�����Ҫ��
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
