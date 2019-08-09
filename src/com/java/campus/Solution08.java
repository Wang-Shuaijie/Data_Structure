package com.java.campus;

import java.util.Scanner;

/**
 * 输入一个long类型的数值, 求该数值的二进制表示中的1的个数 . 
 * @author WangShuaiJie
 *
 */
public class Solution08 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        System.out.println(count);
    }
}
