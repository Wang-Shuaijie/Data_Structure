package com.java.leetcode;
/**
 *  一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。
输入描述:
一串编码过的数字，比如12
输出描述:
解码方法的总数
输入例子1:
12
输出例子1:
2
12可以解码成“AB”，“A，B"这两种
 * @author WangShuaiJie
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if(s.isEmpty() || s.charAt(0)=='0') return 0;
		int[] dp=new int[s.length()+1];
		dp[0]=1;
		for(int i=1;i<dp.length;i++) {
			dp[i]=(s.charAt(i-1)=='0'?0:dp[i-1]);
			if(i>1 && (s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<='6')) {
				dp[i]+=dp[i-2];
			}
		}
		return dp[s.length()];
	}
}
