package com.java.campus;
/**
 * �߹���������Ǵ�С��ÿ����Ҫ���ö��� B ��Ѫ�ĺ���Ա������ϣ�����Ҫ�������ڲ�ͬʱ�����á�
Ů�ͳ�ʮ��ҹ�Dҹÿ����������ܶ౭��ͬ���� B ��Ѫ�ĺ�蹩�������Ǵ�С�����á�
ĳ�գ�������������¶ŵ͵͵Ǳ���ħ�ݱ��Dҹץס��Ҫ���ڽ��շݵĺ�����������������С��Ҫ��Ĳ豭�����򡭡�

��������:
ÿ���������������룬��һ�������ʾ�豭�������ڶ��������ʾÿ�ݲ豭��� B ��Ѫ�����������б�ʾ��С�����Ķ���

�������:
��ÿһ��������������п��ܵĴ��䷽��������ж��ַ������밴ÿ�������ĵ�һ�� B ��Ѫ�����Ĵ�С�������С�
����޷��ҵ��κ�һ�������С��ķ��������"NO"(����������)�����С�

ʾ��1
����
7
2 4 6 1 3 5 7
7

���
1 6
2 5
3 4
 * @author WangShuaiJie
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cups = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		int target = sc.nextInt();
		sc.close();

		int[] vols = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(vols);

		int s = 0, e = vols.length - 1;
		boolean find = false;
		while (s < e) {
			int firstCup = vols[s], secondCup = vols[e];
			if (firstCup + secondCup == target) {
				System.out.printf("%d %d\n", firstCup, secondCup);
				find = true;
				++s;
			} else if (firstCup + secondCup > target) {
				--e;
			} else {
				++s;
			}
		}

		if (!find) {
			System.out.println("NO");
		}
	}
}
