package com.java.base.Array;

import java.util.Arrays;

/**
 * ����Ԫ�ص�ɾ��
 * @author WangShuaiJie
 *
 */
public class TestOpArray2 {
	//���ɾ�������е�Ԫ��
	public static void main(String[] args) {
		//Ŀ������
		int[] arr=new int[] {9,8,7,6,5,4};
		//Ҫɾ����Ԫ���±�
		int dist=3;//Ԫ��6
		
		//����һ��������
		int[] newArr=new int[arr.length-1];
		//���Ƴ�Ҫɾ����Ԫ���������Ԫ��
		for(int i=0;i<newArr.length;i++) {
			if(i<dist) {
				newArr[i]=arr[i];
			}else {
				newArr[i]=arr[i+1];
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
}
