package com.java.base.Array;

public class TestBinarySearch {
	public static void main(String[] args) {
		//对于二分查找来说，目标数组必须是有序的
		int[] arr=new int[] {1,2,3,3,4,5,6,7,8,9};
		//目标元素
		int target=3;
		//记录目标位置
		int index = -1;
		int left=0;
		int right=arr.length-1;
		
		while(left <= right) {
			int mid = (left+right) / 2;
			if(arr[mid] == target) {
				index = mid;
				break;
			}
			else if(arr[mid] < target) {
				//在[mid+1,right]中查找
				left = mid + 1;
			}else {
				//在[left,mid-1]中查找
				right = mid - 1;
			}
		}
		System.out.println(index);
	}
}
