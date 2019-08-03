package com.java.leetcode;

public class RegularExpressionMatching {
	/**
	 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
	 * '.' 匹配任意单个字符。'*' 匹配零个或多个前面的元素
	 * s 可能为空，且只包含从 a-z 的小写字母.p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
	 * 输入:s = "aa" p = "a*"输出: true
	 * 
	 * 思路：
	 * boolean dp[i][j]的含义是s[0-i]与p[0-j]是否匹配
	 * dp[0][0]=true
	 * 1.p.charAt(j)==s.charAt(i):dp[i][j]=dp[i-1][j-1]
	 * 2.if p.charAt(j)=='.':dp[i][j]=dp[i-1][j-1]
	 * 3.if p.charAt(j)=='*':
	 * 		3.1.if p.charAt(j-1)!=s.charAt(i):dp[i][j]=dp[i-1][j-2]
	 * 		3.2.if p.charAt(j-1)==s.charAt(i) or p.charAt(j-1)=='.'
	 * 			dp[i][j]=dp[i][j-1]  a*  a
	 * 			dp[i][j]=dp[i-1][j]  a*  aa
	 * 			dp[i][j]=dp[i][j-2]  a*  empty
	 */
	
	public static boolean isMatch(String s, String p) {
		if((s==null || s.length()==0) && (p==null || p.length()==0)) return false;
		boolean[][] dp=new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		//预处理
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='*' && dp[0][i-1]) {
				dp[0][i+1]=true;
			}
		}
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<p.length();j++) {
				if(p.charAt(i)==s.charAt(j)) {
					dp[i+1][j+1]=dp[i][j];
				}
				if(p.charAt(j)=='.') {
					dp[i+1][j+1]=dp[i][j];
				}
				if(p.charAt(j)=='*') {
					if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
						dp[i+1][j+1]=dp[i+1][j-1];
					}else {
						dp[i+1][j+1]=(dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];       
    }
	
	
	public static void main(String[] args) {
		String s="aa", p="a*";
		System.out.println(isMatch(s, p));
	}
}
