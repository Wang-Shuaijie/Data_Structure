package com.demo.LeetCode;

public class SearchMatrix {
	/**
	 * ��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�

    ÿ�е�Ԫ�ش������������С�
    ÿ�е�Ԫ�ش��ϵ����������С�
���о��� matrix ���£�

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
���� target = 5������ true��

���� target = 20������ false��
	 */
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//˼·�������½ǿ�ʼ���������򲻷����������У����ų���������������
		//�������½ǿ�ʼ���������Ͻ���С��Χ
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
	
	//�����ⷨ����������Ч
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
