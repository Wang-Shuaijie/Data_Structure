package com.demo.base.Array;

public class TestSearch {
	public static void main(String[] args) {
		//Ŀ������
		int[] arr=new int[] {2,3,5,6,8,4,9,0};
		//Ŀ��Ԫ��
		int target=8;
		//Ŀ��Ԫ�������±�
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
