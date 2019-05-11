package com.demo.offer;

import java.util.Arrays;
import java.util.Comparator;

public class Solution33 {
	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个

思路：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面，最后再递归调用。
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
