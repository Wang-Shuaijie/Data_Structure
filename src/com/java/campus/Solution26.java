package com.java.campus;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��K����ɫ��С��(K<=10)��ÿ��С�������ɸ�������С��100����
 * ������һ��С���ӣ��ܷ�N��С��(N<=8)������Ҫ����ЩС��������N��С�򣬷������ӡ� ��֪������Щ��ѡ��ʽ��ע��ÿ����ɫ��С��֮��û�в��
 * 
 * �밴���ֵ���˳�������ѡС������з�ʽ��
 * 
 * ����3����ɫ��ÿ����ɫС��ĸ����ֱ�Ϊa:1,b:2,c:3������3��С��������У� 003,012,021,102,111,120
 * 
 * 
 * ��������:
 * 
 * ��һ����������K N���ֱ��ʾС��������Ŀ����ѡ��С����� �ڶ��п�ʼΪÿ��С�����Ŀ����N������
 * 
 * 
 * �������: ������п��е���ѡ����������������
 * 
 * ��������1: 3 3 1 2 3
 * 
 * �������1: 003 012 021 102 111 120
 * 
 * @author WangShuaiJie
 *
 */
public class Solution26 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] nums = new int[k];
			for (int i = 0; i < k; i++) {
				nums[i] = sc.nextInt();
			}
			Stack<String> stack = new Stack<String>();
			helper(nums, n, 0, stack, "");
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
		}

	}

	private static void helper(int[] nums, int target, int index, Stack<String> stack, String string) {
		if (index == nums.length && target == 0) {
			stack.push(string);
			return;
		}
		int nextTarget = 0;
		for (int i = Math.min(target, nums[index]); i >= 0; i--) {
			nextTarget = target - i;
			helper(nums, nextTarget, index + 1, stack, string + "i");
		}
	}
}
