package com.demo.base.Array;
/**
 * ����
 * @author WangShuaiJie
 *
 */
public class TestArray {
	public static void main(String[] args) {
		//��������
		int[] arr1=new int[3];
		//��ȡ���鳤��
		int length1=arr1.length;
		System.out.println(length1);
		//��������Ԫ�أ�Ҫע���±��0��ʼ
		int element0=arr1[0];
		System.out.println("element0:"+element0);
		//��ֵ
		arr1[0]=99;
		System.out.println("element0:"+element0);
		arr1[1]=98;
		arr1[2]=97;
		//��������
		for(int i=0;i<arr1.length;i++) {
			System.out.println("arr1[] element"+i+":"+arr1[i]);
		}
		
		//��������ͬʱΪ�丳ֵ
		int[] arr2=new int[] {90,80,70,60,50};
		System.out.println(arr2.length);
	}
}
