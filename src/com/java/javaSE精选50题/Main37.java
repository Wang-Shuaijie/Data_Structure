package com.java.javaSE��ѡ50��;

import java.util.Arrays;

/**
 * ��Ŀ����n����Χ��һȦ��˳���źš�
 * �ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������µ���ԭ���ڼ��ŵ���λ��
 * @author WangShuaiJie
 *
 */
public class Main37 {
	public static void main(String[] args) {
		findLast(3);
	}
	public static void findLast(int n) {
		boolean[] people=new boolean[n];
		Arrays.fill(people, true);
		int i=n;//������
		int countNum=0;
		int index=0;
		while(i>1) {
			if(people[index]==true) {
				countNum++;
				if(countNum==3) {
					countNum=0;
					people[index]=false;
					i--;
				}
			}
			index++;
			if(index==n) {
				index=0;
			}
		}
		for(int j=0;j<n;j++) {
			if(people[j]==true) {
                System.out.println("ԭ���ڵ�" + (j + 1) + "λ���������ˡ�");
			}
		}
	}
}
