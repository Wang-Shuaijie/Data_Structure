package com.java.��ָoffer;

public class Solution03 {
	/**
	 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
	 * ˼·�������Ͻǻ����½ǿ�ʼ�ң�����ɾ���������ö��ַ�����
	 */
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//�����½ǿ�ʼ��
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
	
	//�ڶ��ֱ����ƽ⣬ȫ���������Ƽ�
}
