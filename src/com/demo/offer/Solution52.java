package com.demo.offer;

public class Solution52 {
	/**
	 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
	 */
	public int[] multiply(int[] A) {
		int[] B=new int[A.length];
		if(A.length==0 || A==null) return B;
		B[0]=1;
		//��������������
		for(int i=1;i<B.length;i++) {
			B[i]=B[i-1]*A[i-1];
		}
		int temp=1;
		//��������������
		for(int j=B.length-2;j>=0;j--) {
			temp*=A[j+1];
			B[j]*=temp;
		}
		return B;
	}
}
