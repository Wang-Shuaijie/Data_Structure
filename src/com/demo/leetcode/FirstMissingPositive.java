package com.demo.leetcode;

import java.util.HashSet;

public class FirstMissingPositive {
	/**
	 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������

ʾ�� 1:

����: [1,2,0]
���: 3

	 */
	
	
	//��hsahset�Ƚϼ򵥣���������time:O(n)
	public static int firstMissingPositive2(int[] nums) {
		int res=0;
		HashSet<Integer> set=new HashSet<>();
		//��һ�������������е���������HashSet�У������ҳ���������ֵ
		for(int num:nums) {
			if(num<=0) continue;
			set.add(num);
			res=Math.max(res, num);
		}
		//�´�ѭ����1��ʼ���������֣��ĸ������Ҳ����ͷ����ĸ����֣����һֱ�ҵ����������֣��򷵻����ֵ+1
		for(int i=1;i<=res;i++) {
			if(!set.contains(i)) return i;
		}
		return res+1;
	}
	
	/*
	 * ��Ȼ���ܽ����µ����飬��ô����ֻ�ܸ���ԭ�����飬
	 * ���ǵ�˼·�ǰ�1���������һ��λ��nums[0]��2���ڵڶ���λ��nums[1]��
	 * ����Ҫ��nums[i]����nums[nums[i] - 1]�ϣ���ô���Ǳ����������飬
	 * ���nums[i] != i + 1, ��nums[i]Ϊ�����Ҳ�����n��
	 * ����nums[i]������nums[nums[i] - 1]�Ļ������ǽ�����λ�õ�����
	 * �����������������ֱ����������������ٱ���һ�����飬
	 * �����Ӧλ���ϵ�������ȷ�򷵻���ȷ����
	 */
	
	public static int firstMissingPositive(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++) {
			while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]) {
				swap(nums[i], nums[nums[i]-1]);
			}
		}
		for(int i=0;i<n;i++) {
			if(nums[i]!=i+1) return i+1;
		}
		return n+1;
	}
	
	private static void swap(int a,int b) {
		int temp=a;
		a=b;
		b=temp;
	}
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,0};
		System.out.println(firstMissingPositive2(nums));
	}
}
