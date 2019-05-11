package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	/**
	 * n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������

��ͼΪ 8 �ʺ������һ�ֽⷨ��

����һ������ n���������в�ͬ�� n �ʺ�����Ľ��������

ÿһ�ֽⷨ����һ����ȷ�� n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��

ʾ��:

����: 4
���: [
 [".Q..",  // �ⷨ 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // �ⷨ 2
  "Q...",
  "...Q",
  ".Q.."]
]
����: 4 �ʺ��������������ͬ�Ľⷨ��

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
			if(queens[i]==queens[pos]) {//ͬһ��
				return false;
			}else if(Math.abs(queens[pos]-queens[i])==Math.abs(i-pos)) {//�Ƿ��ڶԽ�����
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
