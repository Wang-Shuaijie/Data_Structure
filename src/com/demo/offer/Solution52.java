package com.demo.offer;

public class Solution52 {
	/**
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
	 */
	public int[] multiply(int[] A) {
		int[] B=new int[A.length];
		if(A.length==0 || A==null) return B;
		B[0]=1;
		//计算下三角连乘
		for(int i=1;i<B.length;i++) {
			B[i]=B[i-1]*A[i-1];
		}
		int temp=1;
		//计算上三角连乘
		for(int j=B.length-2;j>=0;j--) {
			temp*=A[j+1];
			B[j]*=temp;
		}
		return B;
	}
}
