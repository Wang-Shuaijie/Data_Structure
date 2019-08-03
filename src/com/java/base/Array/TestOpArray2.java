package com.java.base.Array;

import java.util.Arrays;

/**
 * 数组元素的删除
 * @author WangShuaiJie
 *
 */
public class TestOpArray2 {
	//如何删除数组中的元素
	public static void main(String[] args) {
		//目标数组
		int[] arr=new int[] {9,8,7,6,5,4};
		//要删除的元素下标
		int dist=3;//元素6
		
		//创建一个新数组
		int[] newArr=new int[arr.length-1];
		//复制除要删除的元素外的所有元素
		for(int i=0;i<newArr.length;i++) {
			if(i<dist) {
				newArr[i]=arr[i];
			}else {
				newArr[i]=arr[i+1];
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
}
