package com.java.javaSE��ѡ50��;

/**
 * ��Ŀ����ӡ������ͼ�������Σ�
 * 
 * @author WangShuaiJie
 *
 */
public class Main19 {
	public static void main(String[] args) {
		// ��ӡ���沿�֣�
		int n = 4;
		for (int i = 0; i < n; i++) { // ������
			for (int k = 3 - i; k > 0; k--) { // ����*ǰ��ո�����
				System.out.print(" ");
			}
			// ������ţ�����Ҫ����
			for (int j = 0; j <= 2 * i; j++) { // ������
				System.out.print("*");
			}
			// �����������ϻ���
			System.out.println();
		}
		// ��ӡ���沿��
		n = 3;
		for (int i = n; i > 0; i--) { // ������
			for (int k = 3 - i + 1; k > 0; k--) { // ����*ǰ��ո�����,��һ��Ҫ�ӿո�
				System.out.print(" ");
			}
			// ������ţ�����Ҫ����
			for (int j = 0; j <= 2 * i - 2; j++) { // ������
				System.out.print("*");
			}
			// �����������ϻ���
			System.out.println();
		}
	}
}
