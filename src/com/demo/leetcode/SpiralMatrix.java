package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
	 * Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

	
	 */
	
	//±©Á¦ÆÆ½â O(m*n)
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res=new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return res;
		int rowBegin=0;
		int rowEnd=matrix.length-1;
		int colBegin=0;
		int colEnd=matrix.length-1;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd) {
			for(int i=colBegin;i<=colEnd;i++) {
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			
			for(int i=rowBegin;i<=rowEnd;i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			if(rowBegin<=rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					res.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			
			if(colBegin<=colEnd) {
				for(int i=rowEnd;i>=rowBegin;i--) {
					res.add(matrix[i][colBegin]);
				}
			}
			colBegin++;
			
		}
		return res;
	}
}
