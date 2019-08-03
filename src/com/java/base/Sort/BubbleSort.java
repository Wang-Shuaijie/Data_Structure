package com.java.base.Sort;

import java.util.Arrays;

/**
 * ð������(�����Ƚϣ���������)
 * @author WangShuaiJie
 *
 */
public class BubbleSort {
	/**
	 * 
	 * @param arrĿ������
	 */
	public static void bubbleSort(int[] arr) {
		//���ƹ��Ƚ϶�����
		for(int i=0;i<arr.length-1;i++) {
			//arr.length-1-iǰ��ȽϹ��ľͲ�Ҫ�ٱ���(�ȽϵĴ���)
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=0;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	/*
	 * ����Ƚ�length-1��
	 * 5,7,3,9,8,4,0,6,7,2 
	 * 5,3,7,8,4,0,6,7,2,9
	 * 3,5,7,4,0,6,7,2,8,9
	 * 3,5,4,0,6,7,2,7,8,9
	 * 3,5,0,4,6,2,7,7,8,9
	 * 3,0,4,5,2,6,7,7,8,9
	 * 0,3,4,2,5,6,7,7,8,9
	 * 0,3,2,4,5,6,7,7,8,9
	 * 0,2,3,4,5,6,7,7,8,9
	 *  9��
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
