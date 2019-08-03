package com.demo.Campus;

import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，
 * 要求从其中找出三个数的乘积，使得乘积
 * 最大，要求时间复杂度o(n),空间复杂度o(1)
 * @author WangShuaiJie
 *
 */
public class Solution01 {
	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
		int len=sc.nextInt();
		long[] arr=new long[len];
		for(int i=0;i<len;i++) {
			arr[i]=sc.nextLong();
		}
		System.out.println(maxProduct(arr));
	}
	
	/*
	 * 思路:定义五个数:一个最大,一个次大,一个第三大,一个最小,一个次小
     * 只要找出这五个数,问题就解决了
	 */
	private static long maxProduct(long[] arr) {
		//max1,max2,max3用于记录最大,次大,第三大的数
        long max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        //min1,min2用于记录最小,次小的数
        long min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(long num:arr) {
        	if(num>max1) {
        		max3=max2;
        		max2=max1;
        		max1=num;
        	}else if(num>max2) {
        		max3=max2;
        		max2=num;
        	}else if(num>max3) {
        		max3=num;
        	}
        	if(num<min1) {
        		min2=min1;
        		min1=num;
        	}else if(num<min2) {
        		min2=num;
        	}
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
	}
}
