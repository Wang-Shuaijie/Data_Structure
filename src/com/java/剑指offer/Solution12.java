package com.java.剑指offer;

public class Solution12 {
	/**
	 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
	 * 比如输入3，则打印出1、2、3一直到最大的3位数即999。
	 * 思路：首先计算出n位数的最大十进制数，然后利用循环输出从1到最大的n位数。
	 */
	public void printToMaxofDigits(int n) {
		long number=1;
		int i=0;
		//算出比n位十进制多1的数，比如n=3 最大数为999,number=1000
		while(i<n) {
			number*=10;
			i++;
		}
		for(long j=1;j<number;j++) {
			System.out.println(j+" ");
			//每打印5个数到下一行
			if(j%5==0) {
				System.out.println();
			}
		}
	}
	
	//更正确的思路
	//由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
	//使用回溯法得到所有的数。
	public void print1ToMaxOfNDigits(int n) {
		if(n<=0) return;
		char[] number=new char[n];
		print1ToMaxOfNDigits(number,0);
	}
	private void print1ToMaxOfNDigits(char[] number, int digit) {
		if(digit==number.length) {
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++) {
			number[digit]=(char) (i+'0');
			print1ToMaxOfNDigits(number, digit+1);
		}
	}
	private void printNumber(char[] number) {
		int index=0;
		while(index<number.length && number[index]=='0') index++;
		while(index<number.length) {
			System.out.println(number[index++]);
		}
		System.out.println();
	}
}
