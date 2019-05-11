package com.demo.base.Array;

public class TestSearch {
	public static void main(String[] args) {
		//目标数组
		int[] arr=new int[] {2,3,5,6,8,4,9,0};
		//目标元素
		int target=8;
		//目标元素所在下标
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				index=i;
				break;
			}
		}
		System.out.println("index:"+index);
	}
}
