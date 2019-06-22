package com.demo.base.Sort;

import java.util.Arrays;

/**
 * �鲢����
 * @author WangShuaiJie
 *
 */
public class MregeSort {

	public static void mergeSort(int[] arr,int low,int high) {
		int middle=(low+high)/2;
		if(low<high) {
			//�������
			mergeSort(arr, low, middle);
			//�����ұ�
			mergeSort(arr, middle+1, high);
			//�鲢
			merge(arr, low, middle, high);
		}
		
	}
	public static void merge(int[] arr,int low,int middle,int high) {
		//���ڴ洢�鲢����ʱ����
		int[] temp=new int[high-low+1];
		//��¼��һ����������Ҫ�������±�
		int i=low;
		//��¼�ڶ�����������Ҫ�������±�
		int j=middle+1;
		//��¼����ʱ�����ŵ��±�
		int index=0;
		//������������ȡ��С�����֣�������ʱ����
		while(i<=middle&&j<=high) {
			//��һ����������ݸ�С
			if(arr[i]<=arr[j]) {
				//������ʱ����
				temp[index]=arr[i];
				i++;
			}else {
				temp[index]=arr[j];
				j++;
			}
			index++;
		}
		//������������
		while(j<=high) {
			temp[index]=arr[j];
			j++;
			index++;
		}
		while(i<=middle) {
			temp[index]=arr[i];
			i++;
			index++;
		}
		//����ʱ��������ݴ���ԭ����
		for(int k=0;k<temp.length;k++) {
			arr[k+low]=temp[k];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 7, 3, 9, 8, 4, 0, 6, 7, 2 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
}
