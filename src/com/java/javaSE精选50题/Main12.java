package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ����ҵ���ŵĽ������������ɡ�����(I)���ڻ����10��Ԫʱ���������10%��
 * �������10��Ԫ������20��Ԫʱ������10��Ԫ�Ĳ��ְ�10%��ɣ�����10��Ԫ�Ĳ��֣��ɿ����7.5%��
 * 20��40��֮��ʱ������20��Ԫ�Ĳ��֣������5%��40��60��֮��ʱ����40��Ԫ�Ĳ��֣������3%��
 * 60��100��֮��ʱ������60��Ԫ�Ĳ��֣������1.5%������100��Ԫʱ������100��Ԫ�Ĳ��ְ�1%��ɣ� �Ӽ������뵱������I����Ӧ���Ž���������
 * 
 * @author WangShuaiJie
 *
 */
public class Main12 {
	public static void main(String[] args) {
		System.out.println("�������㴴�������(��λ����Ԫ):");
		Scanner scanner = new Scanner(System.in);
		while (!scanner.hasNextDouble()) {
			System.out.println("�����������֣�");
			scanner.next();
		}
		double profit = scanner.nextDouble();
		double bonus = 0;
		if (profit <= 10) {
			bonus = profit * 0.1;
		} else if (profit <= 20) {

			bonus = (profit - 10) * 0.075 + 1;

		} else if (profit <= 40) {
			bonus = (profit - 10) * 0.05 + 1.75;
		} else if (profit <= 60) {
			bonus = (profit - 10) * 0.03 + 2.75;
		} else if (profit <= 100) {
			bonus = (profit - 10) * 0.015 + 3.35;
		} else {
			bonus = (profit - 100) * 0.01 + 3.95;
		}
		System.out.println(profit + "��Ԫ���󣬿��Ի�ã�" + bonus + "��Ԫ");
		scanner.close();
	}

}
