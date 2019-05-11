package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	/**
	 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

	 */
	
	public static List<List<String>> solveNQueens(int n){
		List<List<String>> res=new ArrayList<>();
		if(n<=0) return res;
		helper(res,new int[n],0);
		return res;
	}
	
	public static void helper(List<List<String>> res, int[] queens, int pos) {
		if(pos==queens.length) {
			addSolution(res,queens);
			return;
		}
		for(int i=0;i<queens.length;i++) {
			queens[pos]=i;
			if(isValid(queens,pos)) {
				helper(res, queens, pos+1);
			}
		}
	}
	
	public static void addSolution(List<List<String>> res, int[] queens) {
		List<String> list=new ArrayList<>();
		for(int i=0;i<queens.length;i++) {
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<queens.length;j++) {
				if(queens[i]==j) {
					sb.append('Q');
				}else {
					sb.append('.');
				}
			}
			list.add(sb.toString());
		}
		
		res.add(list);
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
	
	
	
	
	public static void main(String[] args) {
		int n=4;
		List<List<String>> res=solveNQueens(n);
		System.out.println(res.toString());
	}
}
