package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：
 * 有n个整数，使其前面各数顺序向后移m个位置，
 * 最后m个数变成最前面的m个数
 * 程序分析：在原来数组的基础上还要创建一个和原来数组大小一样的数组
 * @author WangShuaiJie
 *
 */
public class Main36 {
	public static void main(String[] args) {
		System.out.print("请输入10个数的数组: ");
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int[] array = new int[10];
		for (int i=0; i<array.length; i++) {
			array[count++] = sc.nextInt();
		}
	    System.out.print("请输入一个小于10的数: ");
		int number = sc.nextInt();
		sc.close();
	}
	
	private static void arrayHandler(int[] array, int m) {
		int[] temp=new int[m];
		for(int i=0;i<m;i++) {
			temp[i]=array[array.length-m+i];
		}
		for(int i=array.length-m-1;i>=0;i--) {
			array[i+m]=array[i];
		}
		for(int i=0;i<m;i++) {
			array[i]=temp[i];
		}
	}	
}
