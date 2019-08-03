package com.java.leetcode;

public class RotateImage {
	/**
	 * ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��

��ͼ��˳ʱ����ת 90 �ȡ�

˵����

�������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��

ʾ�� 1:

���� matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
ԭ����ת�������ʹ���Ϊ:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

�ȸ���159��ת������456��ת
1  2  3     1  4  7    7  4  1

4  5  6 --> 2  5  8 -->8  5  2����

7  8  9     3  6  9����9  6  3
	 */
	public void rotats(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			//��159�Ի�
			for(int j=0;j<matrix[0].length;j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}			
		}
		//��456�Ի� ֻ�������
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length/2;j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][matrix.length-1-j];
				matrix[i][matrix.length-1-j]=temp;
			}
		}
	}
}
