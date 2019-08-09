package com.java.javaSE经典50题;

/**
 * 题目：某个公司采用公用电话传递数据，数据是四位的整数， 在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
 * 再将第一位和第四位交换，第二位和第三位交换
 * 
 * @author WangShuaiJie
 *
 */
public class Main48 {
	private static void encryption(int n) {
		int[] nums = new int[4];
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i] = (n % 10 + 5) % 10;
			n = n / 10;
		}
		// 按要求替换,交换1、4位

		int temp = 0;// 交换数
		temp = nums[0];
		nums[0] = nums[3];
		nums[3] = temp;
		// 交换2、3位
		temp = nums[1];
		nums[1] = nums[2];
		nums[2] = temp;
		System.out.println("加密后的结果：" + nums[0] + nums[1] + nums[2] + nums[3]);
	}
}
