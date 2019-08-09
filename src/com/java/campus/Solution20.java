package com.java.campus;

import java.util.Scanner;

/**
 * 如果version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
 * 
 * 输入的version字符串非空，只包含数字和字符 字符不代表通常意义上的小数点，只是用来区分数字序列。
 * 例如字符串2.5并不代表二点五，只是代表版本是第一级版本号是2，第二级版本号是5.
 * 
 * 输入描述: 两个字符串，用空格分割。 每个字符串为一个version字符串，非空，只包含数字和字符.
 * 
 * 输出描述: 只能输出1, -1，或0
 * 
 * 示例1 输入 0.1 1.1
 * 
 * 输出 -1
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
