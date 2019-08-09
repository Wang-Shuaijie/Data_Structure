package com.java.javaSE50题;
/**
 * 题目：求0—7所能组成的奇数个数。
 * @author WangShuaiJie
 *
 */
public class Main43 {
	/*
	 * 最少也是1位数，最多能组成8位的数字 
	 * 第一位不能为零，最后一位不能是偶数
	 */
	public static void main(String[] args) {
		 int count = 0;
	        //声明由数字组成的数
	        int n = 8;
	        //一位数
	        count = n/2;
	        //两位数
	        count += (n-1)*n/2;
	        //三位数
	        count += (n-1)*n*n/2;
	        //四位数
	        count += (n-1)*n*n*n/2;
	        //五位数
	        count += (n-1)*n*n*n*n/2;
	        //六位数
	        count += (n-1)*n*n*n*n*n/2;
	        //七位数
	        count += (n-1)*n*n*n*n*n*n/2;
	        System.out.println("0-7所能组成的奇数个数："+count);
	}
}
