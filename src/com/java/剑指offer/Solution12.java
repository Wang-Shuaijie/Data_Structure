package com.java.��ָoffer;

public class Solution12 {
	/**
	 * ��������n����˳���ӡ����1������nλʮ��������
	 * ��������3�����ӡ��1��2��3һֱ������3λ����999��
	 * ˼·�����ȼ����nλ�������ʮ��������Ȼ������ѭ�������1������nλ����
	 */
	public void printToMaxofDigits(int n) {
		long number=1;
		int i=0;
		//�����nλʮ���ƶ�1����������n=3 �����Ϊ999,number=1000
		while(i<n) {
			number*=10;
			i++;
		}
		for(long j=1;j<number;j++) {
			System.out.println(j+" ");
			//ÿ��ӡ5��������һ��
			if(j%5==0) {
				System.out.println();
			}
		}
	}
	
	//����ȷ��˼·
	//���� n ���ܻ�ǳ�����˲���ֱ���� int ��ʾ���֣������� char ������д洢��
	//ʹ�û��ݷ��õ����е�����
	public void print1ToMaxOfNDigits(int n) {
		if(n<=0) return;
		char[] number=new char[n];
		print1ToMaxOfNDigits(number,0);
	}
	private void print1ToMaxOfNDigits(char[] number, int digit) {
		if(digit==number.length) {
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++) {
			number[digit]=(char) (i+'0');
			print1ToMaxOfNDigits(number, digit+1);
		}
	}
	private void printNumber(char[] number) {
		int index=0;
		while(index<number.length && number[index]=='0') index++;
		while(index<number.length) {
			System.out.println(number[index++]);
		}
		System.out.println();
	}
}
