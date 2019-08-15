package com.java.campus;

import java.util.Scanner;

/**
 * СQ������һ�����г�Ϊ��ת����: ��������n��m, ����n�ܱ�2m����������һ������������������1, 2, 3, 4..., ÿ��m�����ŷ�תһ��,
 * �������Ϊ'-';�� ����n = 8, m = 2, ���о���: -1, -2, +3, +4, -5, -6, +7, +8. ��n = 4, m =
 * 1, ���о���: -1, +2, -3, + 4. СQ����ϣ�����ܰ�������ǰn���Ϊ���١� ��������: ���������������n��m(2 <= n <=
 * 109, 1 <= m), ��������n�ܱ�2m������
 * 
 * �������: ���һ������, ��ʾǰn��͡�
 * 
 * ��������1: 8 2
 * 
 * �������1: 8
 * 
 * @author WangShuaiJie
 *
 */
public class Solution27 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		System.out.println(process(n, m));
	}

	public static long process(long n, long m) {
		if (n % (2 * m) != 0)
			return -1;
		return m * (n / 2);

	}
}
