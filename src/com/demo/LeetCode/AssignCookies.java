package com.demo.LeetCode;

import java.util.Arrays;

public class AssignCookies {
	/**
	 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。

示例 1:

输入: [1,2,3], [1,1]

输出: 1
	 */
	public static int findContentChildren(int[] g,int[] s) {
		if(s.length==0 || g.length==0) return 0;
		int res=0;
		int j=0;
		//先对小孩和饼干排序
		Arrays.sort(g);
		Arrays.sort(s);
		for(int i=0;i<s.length;i++) {
			//优先满足最小孩子的需求
			if(s[i]>=g[j]) {
				res++;
				j++;
			}
			if(j>=g.length) break;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] s=new int[] {1,1,2};
		int[] g=new int[] {1,2};
		System.out.println(findContentChildren(g, s));
	}
}
