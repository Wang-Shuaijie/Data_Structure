package com.demo.base.Sort;

import java.util.Arrays;

import com.demo.base.StackandQueue.MyQueue;

/**
 * ��������(����ʵ��)
 * @author WangShuaiJie
 *
 */
public class RadixQueueSort {
	
	public static void radixQueueSort(int[] arr) {
		//�洢��������������
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//������������Ǽ�λ��
		int maxLength=(max+"").length();
		//������ʱ�������
		MyQueue[] temp=new MyQueue[10];
		//Ϊ�������鸳ֵ
		for(int i=0;i<temp.length;i++) {
			temp[i]=new MyQueue();
		}
		//������󳤶ȵ��������ȽϵĴ���
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//��ÿһ�����ֱַ��������
			for(int j=0;j<arr.length;j++) {
				//��������
				int ys=arr[j]/n%10;
				//�ѵ�ǰ���������ݷ���ָ��������
				temp[ys].add(arr[j]);
			}	
		}
		//��¼ȡ��Ԫ����Ҫ�ŵ�λ��
		int index=0;
		//ȡ������
		for(int k=0;k<temp.length;k++) {
			//��ǰ���в�Ϊ��,ѭ��ȡ��Ԫ��
				while(!temp[k].isEmpty()) {
					arr[index]=temp[k].poll();
					index++;
				}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		radixQueueSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
