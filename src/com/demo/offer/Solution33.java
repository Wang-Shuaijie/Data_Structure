package com.demo.offer;

import java.util.Arrays;
import java.util.Comparator;

public class Solution33 {
	/**
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ��

˼·���Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ�������򡣻�ʹ�ñȽϺͿ��ŵ�˼�룬��ǰ��������������Ƚϣ���С��ŵ���ǰ�棬����ٵݹ���á�
	 */
	public String minimumNumber(int[] nums) {
		if(nums==null || nums.length==0) return null;
		StringBuilder sb=new StringBuilder();
		String[] str=new String[nums.length];
		for(int i=0;i<nums.length;i++) {
			str[i]=String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String c1=o1+o2;
				String c2=o2+o1;
				return c1.compareTo(c2);
			}
		});
		for(int i=0;i<nums.length;i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
