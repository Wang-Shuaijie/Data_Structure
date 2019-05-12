package com.demo.offer;

public class Solution46 {
	/**
	 * 求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
	 */
	public int get_Sum(int n) {
		//巧用递归
		int sum=n;
		boolean res=(n>0) && ((sum+=get_Sum(n-1))>0);
		return sum;
		
		/*if(n<0) return 0; 
		if(n==1) return 1;
		return n+get_Sum(n-1);*/
	}
}
