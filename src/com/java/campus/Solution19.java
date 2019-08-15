package com.java.campus;
/**
 * 给定一个数字矩阵，请设计一个算法从左上角开始顺时针打印矩阵元素
 * @author WangShuaiJie
 *
 */
public class Solution19 {
	private static void print(int[][] matrix) {
		int rowStart=0;
		int rowEnd=matrix.length-1;
		int colStart=0;
		int colEnd=matrix[0].length-1;
		
		while(rowStart<=rowEnd && colStart<=colEnd) {
			for(int i=colStart;i<=colEnd;i++) {
				System.out.print(matrix[rowStart][i]+" ");
			}
			rowStart++;
			for(int i=rowStart;i<=rowEnd;i++) {
				System.out.print(matrix[i][colEnd]+" ");
			}
			colEnd--;
			if(rowStart<=rowEnd) {
				for(int i=colEnd;i>=colStart;i--) {
					System.out.print(matrix[rowEnd][i]+" ");
				}
				rowEnd--;
			}
			if(colStart<=colEnd) {
				for(int i=rowEnd;i>=rowStart;i--) {
					System.out.print(matrix[i][colStart]+" ");
				}
				colStart++;
			}
			
		}
	}
}
