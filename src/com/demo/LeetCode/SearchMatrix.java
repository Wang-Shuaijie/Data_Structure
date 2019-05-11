package com.demo.LeetCode;

public class SearchMatrix {
	/**
	 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。
现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
	 */
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//思路：从左下角开始，依次排序不符合条件的列，再排除不符合条件的行
		//即从左下角开始，逐渐向右上角缩小范围
		if(matrix.length==0) return false;
		int i=matrix.length-1;
		int j=0;
		while(i>=0 && j<matrix[0].length) {
			if(matrix[i][j]==target) {
				return true;
			}else if(matrix[i][j]>target) {
				i--;
			}else if(matrix[i][j]<target) {
				j++;
			}
		}
		
        return false;
	}
	
	//暴力解法，但并不高效
	public boolean searchMatrix2(int[][] matrix, int target) {
		for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(target==matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
	}
}
