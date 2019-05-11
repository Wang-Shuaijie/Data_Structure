package com.demo.base.Sort;

import java.util.Arrays;
/**
 * ��������
 * @author WangShuaiJie
 *
 */
public class QuickSort {
	public static void quickSort(int[] arr,int start,int end) {
		//������޵ݹ�
		if(start<end) {
			//�����0��Ԫ����Ϊ��׼ֵ
			int stard= arr[start];
			//��¼��Ҫ������±�
			int i=start;
			int j=end;
			//ѭ���ұȱ�׼��������ֺͱȱ�׼��С������
			while(i<j) {
				//�ұ����ֱȱ�׼����������λ
				while(i<j && stard<=arr[j]) {
					j--;
				}
				//ʹ���ұ߱ȱ�׼��С�������滻��׼λ
				arr[i]=arr[j];
				
				//������ֱȱ�׼��С��������λ
				while(i<j && arr[i]<=stard) {
					i++;
				}
				//ʹ����߱ȱ�׼����������滻��λ
				arr[j]=arr[i];
			}
			//��׼������
			arr[i]=stard;
			//�������бȱ�׼��С������
			quickSort(arr, start, i);
			//�������бȱ�׼���������
			quickSort(arr, i+1, end);
		}
		
	}
	
	/*�ֱ�ӳ�ʼ���С�5,7,3,9,8,4,0,6,7,2�����˿�ʼ��̽�⡱��
	 * �ȴ���������һ��С��5���������ڻ�׼��λ���ٴ���������һ������5����������ȱλ	��
	 * �����������������i��j���ֱ�ָ����������ߺ����ұߡ�
	 * �տ�ʼ��ʱ����iָ�����е�����ߣ���i=0����ָ������5��
	 * ��jָ�����е����ұߣ���j=9����ָ������2��
	 * ÿ�ν���������j���ж�
	 * 5,7,3,9,8,4,0,6,7,2 ��ʼ̬ ��5Ϊ��׼ֵ i=0 j=9
	 * 2,0,3,4,5,8,9,6,7,7
	 * 
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
