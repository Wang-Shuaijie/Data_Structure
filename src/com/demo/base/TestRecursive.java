package com.demo.base;
/**
 * �ݹ����--쳲���������
 * @author WangShuaiJie
 *
 */
public class TestRecursive {
	public static void main(String[] args) {
		print(3);
		System.out.println(febonaqcci(6));
	}
	//�ݹ�һ��Ҫע���������
	public static void print(int i) {
		if(i>0) {
			System.out.println(i);
			print(i-1);
		}
	}
	
	/*
	 * 쳲���������:1 1 2 3 5 8 13 21....
	 * i=5
	 * febonaqcci(4)+febonaqcci(3)
	 * febonaqcci(3)+febonaqcci(2)+febonaqcci(2)+febonaqcci(1)
	 * febonaqcci(2)+febonaqcci(1)+1+1+1
	 * 1+1+1+1+1
	 */
	public static int febonaqcci(int i) {
		if(i == 1 || i == 2) {
			return 1;
		}else {
			return febonaqcci(i-1)+febonaqcci(i-2);
		}
	}
	
}
