package com.demo.base.Sort;

import java.util.Arrays;

/**
 * ϣ������
 * @author WangShuaiJie
 *
 */
public class ShellSort {
	
	public static void shellSort(int[] arr) {
		//�������в���(����)
		for(int d=arr.length/2;d>0;d/=2) {
			//��������Ԫ��
			for(int i=d;i<arr.length;i++) {
				for(int j=i-d;j>=0;j-=d){
					//�����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�����
					if(arr[j]>arr[j+d]) {
						int temp=arr[j];
						arr[j]=arr[j+d];
						arr[j+d]=temp;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
