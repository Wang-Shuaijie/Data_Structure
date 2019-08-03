package com.demo.Campus;

import java.util.Scanner;

/**
 * ����һ���������飬����������������0��
 * Ҫ��������ҳ��������ĳ˻���ʹ�ó˻�
 * ���Ҫ��ʱ�临�Ӷ�o(n),�ռ临�Ӷ�o(1)
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
	 * ˼·:���������:һ�����,һ���δ�,һ��������,һ����С,һ����С
     * ֻҪ�ҳ��������,����ͽ����
	 */
	private static long maxProduct(long[] arr) {
		//max1,max2,max3���ڼ�¼���,�δ�,���������
        long max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        //min1,min2���ڼ�¼��С,��С����
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
