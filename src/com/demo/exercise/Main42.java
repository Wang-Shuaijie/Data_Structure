package com.demo.exercise;
/**
 * ��Ŀ��809*??=800*??+9*??+1
 * ����??�������λ��,8*??�Ľ��Ϊ��λ����9*??�Ľ��Ϊ3λ����
 * ��??�������λ������809*??��Ľ����
 * @author WangShuaiJie
 *
 */
public class Main42 {
	public static void main(String[] args) {
		int x = 0;
		boolean flag = false;
		for (int i = 10; i < 100; i++) {
			if (809 * i == 800 * i + 9 * i + 1) {
				flag = true;
				x = i;
				break;
			}
 
		}
		if (flag) {
			System.out.print("�����λ����" + x);
			System.out.print("809*??�Ľ����:" + 809 * x);
		} else
			System.out.print("�޷���Ҫ�����");

	}
}
