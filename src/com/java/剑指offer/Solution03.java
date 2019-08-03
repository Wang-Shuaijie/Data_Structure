package com.java.剑指offer;

public class Solution03 {
	/**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 思路：从右上角或左下角开始找，逐行删除，或者用二分法查找
	 */
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//从左下角开始找
		int i=matrix.length-1;
		int j=0;
		while(i>=0 && j<matrix[0].length) {
			if(matrix[i][j]==target) {
				return true;
			}else if(matrix[i][j]>target) {
				i--;
			}else {
				j++;
			}
		}
		return false;
	}
	
	//第二种暴力破解，全遍历，不推荐
}
