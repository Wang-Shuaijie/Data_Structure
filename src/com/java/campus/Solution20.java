package com.java.campus;

import java.util.Scanner;

/**
 * ���version1 > version2 ����1����� version1 < version2 ����-1����Ȼ����0.
 * 
 * �����version�ַ����ǿգ�ֻ�������ֺ��ַ� �ַ�������ͨ�������ϵ�С���㣬ֻ�����������������С�
 * �����ַ���2.5������������壬ֻ�Ǵ���汾�ǵ�һ���汾����2���ڶ����汾����5.
 * 
 * ��������: �����ַ������ÿո�ָ ÿ���ַ���Ϊһ��version�ַ������ǿգ�ֻ�������ֺ��ַ�.
 * 
 * �������: ֻ�����1, -1����0
 * 
 * ʾ��1 ���� 0.1 1.1
 * 
 * ��� -1
 * 
 * @author WangShuaiJie
 *
 */
public class Solution20 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String v1 = scanner.next();
			String v2 = scanner.next();
			System.out.println(comp(v1, v2));
		}
	}

	private static int comp(String v1, String v2) {

		String[] nums1 = v1.split("\\.");
		String[] nums2 = v2.split("\\.");

		for (int i = 0; i < nums1.length && i < nums2.length; i++) {

			String vi1 = nums1[i];
			String vi2 = nums2[i];
			int pp = Integer.compare(Integer.valueOf(vi1), Integer.valueOf(vi2));
			if (pp != 0) {
				return pp;
			}
		}
		return Integer.compare(nums1.length, nums2.length);
	}
}
