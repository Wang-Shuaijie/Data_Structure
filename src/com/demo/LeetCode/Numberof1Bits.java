package com.demo.LeetCode;

public class Numberof1Bits {
	/**
	 * ��дһ��������������һ���޷�������������������Ʊ��ʽ������λ��Ϊ ��1�� �ĸ�����Ҳ����Ϊ������������

ʾ�� :

����: 11
���: 3
����: ���� 11 �Ķ����Ʊ�ʾΪ 00000000000000000000000000001011
	 */
	public int hammingWeight(int n) {
		/**
		 * ��flag����n��ÿλ��λ�����㣬���ж�1�ĸ���
		 */
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((flag&n)!=0) {
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
	
	public int hammingWeight2(int n) {
		/**
		 * ���һ��������Ϊ0����ô�������������һλ��1��
		 * ������ǰ����������1����ôԭ�������������ұߵ�1�ͻ��Ϊ0��ԭ����1��������е�0������1(������ұߵ�1���滹��0�Ļ�)��
		 * ��������λ�������ܵ�Ӱ��
		 */
		int count=0;
		while(n!=0) {
			count++;
			n=(n-1)&n;
		}
		return count;
	}
}
