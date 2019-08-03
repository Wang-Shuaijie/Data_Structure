package com.java.base.Sort;

import java.util.Arrays;

/**
 * ��ѡ������
 * @author WangShuaiJie
 *
 */
public class SelectSort {
	
	public static void selectSort(int[] arr) {
		//�������е���
		for(int i=0;i<arr.length;i++) {
			//�����С�����±�
			int minIndex=i;
			//�ѵ�ǰ����������������е����Ƚ�
			for(int j=i+1;j<arr.length;j++) {
				//��������и�С����,�滻�±�
				if(arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			//�統ǰ�������±�����С���±겻һ��
			if(i!=minIndex) {
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
