package com.java.base.Array;

public class TestBinarySearch {
	public static void main(String[] args) {
		//���ڶ��ֲ�����˵��Ŀ����������������
		int[] arr=new int[] {1,2,3,3,4,5,6,7,8,9};
		//Ŀ��Ԫ��
		int target=3;
		//��¼Ŀ��λ��
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
				//��[mid+1,right]�в���
				left = mid + 1;
			}else {
				//��[left,mid-1]�в���
				right = mid - 1;
			}
		}
		System.out.println(index);
	}
}
