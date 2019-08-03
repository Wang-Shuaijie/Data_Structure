package com.java.leetcode;

public class LongestPalindrome {
	/**
	 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
	 * 示例 1：输入: "babad"输出: "bab"注意: "aba" 也是一个有效答案。
	 * 回文串，就是正读反读都一样的字符串，比如 "bob", "level"
	 */
	private String res="";
	public String longestPalindrome(String s) {
		//判断字符串长度
		if(s.length() == 0 || s == null ) return s;
		//String res="";res应该为全局变量
		for(int i=0;i<s.length();i++) {
			helper(s, i, i);
			helper(s, i, i+1);//判断cbba这种情况
		}
		return res;
	}
	
	public void helper(String s,int left,int right) {
		/*
		 * babad
		 * i=2 b  left--(1) right++(3) 
		 * aba //中心扩散left--(0) right++(4) 
		 * 				  babad
		 */
		while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		//String res="";
		//substring(x)是从字符串的的第x个字符截取;;substring(x,y）是从x到y前的位置停止(包括x不包括y)
		String cur=s.substring(left+1, right);
		//System.out.println(cur);
		if(cur.length() > res.length()) {
			res=cur;
		}
	}
	
	public static String longestPalindrome2(String s) {
		//判断字符串长度
		if(s.length() == 0 || s == null ) return s;
		String res="";
		boolean[][] dp=new boolean[s.length()][s.length()];
		//标记是否最长
		int max=0;
		/*
		 * 遍历
		 * babad 
		 * i=2 遍历 bab
		 * i=4 遍历 babad  i=4 j=2 遍历bad i=2 j=0 遍历bab
		 */		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				dp[j][i] =  s.charAt(i)==s.charAt(j) && ((i-j <= 2) || dp[j+1][i-1]);
				if(dp[j][i]) {
					if(i - j + 1 > max) {
						max = i-j+1;
						res=s.substring(j, i+1);
					}
				}
			}
		}
		return res;
	}
	
	
	
	
}
