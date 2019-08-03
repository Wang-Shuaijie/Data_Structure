package com.java.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class Solution20 {
	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	 * 例如，如果输入如下矩阵：  1  2  3  4 
	 *                         5  6  7  8 
	 *                         9  10 11 12 
	 *                         13 14 15 16 
	 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 */
	public List<Integer> printMatrix(int[][] matrix){
		List<Integer> res=new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return res;
		int rowBegin=0;
		int rowEnd=matrix.length-1;
		int colBegin=0;
		int colEnd=matrix[0].length-1;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd) {
			for(int i=colBegin;i<=colEnd;i++) {
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			
			for(int i=rowBegin;i<=rowEnd;i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			//rowbegin增加了，所以要判断
			if(rowBegin<=rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					res.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			
			//同上
			if(colBegin<=colEnd) {
				for(int i=rowEnd;i>=rowBegin;i--) {
					res.add(matrix[i][colBegin]);
				}
				colBegin++;
			}
			
		}
		return res;
	}
	
	//精简写法
	public ArrayList<Integer> printMatrix2(int[][] matrix) {
	    ArrayList<Integer> ret = new ArrayList<>();
	    int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
	    while (r1 <= r2 && c1 <= c2) {
	        for (int i = c1; i <= c2; i++)
	            ret.add(matrix[r1][i]);
	        for (int i = r1 + 1; i <= r2; i++)
	            ret.add(matrix[i][c2]);
	        if (r1 != r2)
	            for (int i = c2 - 1; i >= c1; i--)
	                ret.add(matrix[r2][i]);
	        if (c1 != c2)
	            for (int i = r2 - 1; i > r1; i--)
	                ret.add(matrix[i][c1]);
	        r1++; r2--; c1++; c2--;
	    }
	    return ret;
	}
}
