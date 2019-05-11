package com.demo.base.Sort;

import java.util.Arrays;
/**
 * ��������
 * @author WangShuaiJie
 *
 */
public class InsertSort {
	
	public static void insertSort(int arr[]) {
		//������������
		for(int i=1;i<arr.length;i++) {
			//�����ǰ���ֱ�ǰһ��С,�����������Ƚ�����
			if(arr[i]<arr[i-1]) {
				int temp=arr[i];
				//���ȵ�����߻�������temp��С���ݽ���
				int j=i-1;
				while(j >= 0 && arr[j]>temp) {
					//����
					arr[j+1]=arr[j];
					j--;
				}
				//��temp���ڿ�λ
				arr[j+1]=temp;
				
			}
		}
	}
	
	/*
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
