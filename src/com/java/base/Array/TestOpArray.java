package com.java.base.Array;

import java.util.Arrays;
/**
 * ����Ԫ�ص����
 * @author WangShuaiJie
 *
 */
public class TestOpArray {
	public static void main(String[] args) {
		//������鳤�Ȳ��ɱ������ --˼·���½�һ���ϴ������
		int[] arr=new int[] {9,8,7};
		//���ٲ鿴����Ԫ��
		System.out.println(Arrays.toString(arr));
		//Ҫ���������Ŀ��Ԫ��
		int dist=6;
		
		//����һ��������
		int[] newArr=new int[arr.length+1];
		//��ԭ������Ԫ�ظ��Ƶ�������
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		//��Ŀ��Ԫ�ط������������
		newArr[arr.length]=dist;
		//�������滻������
		arr=newArr;
		System.out.println(Arrays.toString(arr));
	}
}
