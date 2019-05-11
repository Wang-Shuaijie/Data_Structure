package com.demo.base.Array;
/**
 * 数组
 * @author WangShuaiJie
 *
 */
public class TestArray {
	public static void main(String[] args) {
		//创建数组
		int[] arr1=new int[3];
		//获取数组长度
		int length1=arr1.length;
		System.out.println(length1);
		//访问数组元素，要注意下标从0开始
		int element0=arr1[0];
		System.out.println("element0:"+element0);
		//赋值
		arr1[0]=99;
		System.out.println("element0:"+element0);
		arr1[1]=98;
		arr1[2]=97;
		//遍历数组
		for(int i=0;i<arr1.length;i++) {
			System.out.println("arr1[] element"+i+":"+arr1[i]);
		}
		
		//创建数组同时为其赋值
		int[] arr2=new int[] {90,80,70,60,50};
		System.out.println(arr2.length);
	}
}
