package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
	/**
	 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]


	 */
	private static int res=0;
	public static int totalNQueens(int n) {
		//int res=0;
		if(n<=0) return 0;
		helper(new int[n],0);
		return res;
	}

	public static void helper(int[] queens, int pos) {
		if(pos==queens.length) {
			res++;
			return;
		}
		for(int i=0;i<queens.length;i++) {
			queens[pos]=i;
			if(isValid(queens,pos)) {
				helper(queens, pos+1);
			}
		}
	}	

	public static boolean isValid(int[] queens, int pos) {
		for(int i=0;i<pos;i++) {
			if(queens[i]==queens[pos]) {//同一列
				return false;
			}else if(Math.abs(queens[pos]-queens[i])==Math.abs(i-pos)) {//是否在对角线上
				return false;
			}
		}
		return true;
	}
	
	
	
	
	//用boolean[]解
	public static int totalNQueens2(int n) {
		boolean[] cols=new boolean[n];
		boolean[] d1=new boolean[2*n];
		boolean[] d2=new boolean[2*n];
		helper(0,cols,d1,d2,n);
		return res;
	}
	
	public static void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
		if(row==n) {
			res++;
			return;
		}
		for(int col=0;col<n;col++) {
			int id1=col-row+n;
			int id2=col+row;
			if(cols[col] || d1[id1] || d2[id2]) continue;
			cols[col]=true;
			d1[id1]=true;
			d2[id2]=true;
			helper(row+1, cols, d1, d2, n);
			cols[col]=false;
			d1[id1]=false;
			d2[id2]=false;
		}
		
	}

	public static void main(String[] args) {
		int n=4;
		System.out.println(totalNQueens2(n));
	}
	
}
