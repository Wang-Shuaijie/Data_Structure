package com.java.base.Array;

import java.util.Arrays;
/**
 * 数组元素的添加
 * @author WangShuaiJie
 *
 */
public class TestOpArray {
	public static void main(String[] args) {
		//解决数组长度不可变的问题 --思路：新建一个较大的数组
		int[] arr=new int[] {9,8,7};
		//快速查看数组元素
		System.out.println(Arrays.toString(arr));
		//要加入数组的目标元素
		int dist=6;
		
		//创建一个新数组
		int[] newArr=new int[arr.length+1];
		//把原有数组元素复制到新数组
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		//把目标元素放入新数组最后
		newArr[arr.length]=dist;
		//新数组替换旧数组
		arr=newArr;
		System.out.println(Arrays.toString(arr));
	}
}
