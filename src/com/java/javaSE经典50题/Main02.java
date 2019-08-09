package com.java.javaSE经典50题;
/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数
 * 素数：只能被0和它自身整除，如3,5,7,11,131... 
 * @author WangShuaiJie
 *
 */
public class Main02 {
	//判断素数的方法：用一个数分别去除2到这个数减1
	public static void main(String[] args) {
		for(int i=101;i<=200;i++) {
			if(isRightNum(i)) System.out.println(i);
		}
	}
	
	public static boolean isRightNum(int n) {
		if(n<=1) return false;
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
