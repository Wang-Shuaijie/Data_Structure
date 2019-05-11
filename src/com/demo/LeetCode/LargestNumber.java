package com.demo.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LargestNumber {
	/**
	 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210

示例 2:

输入: [3,30,34,5,9]
输出: 9534330

说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

	 */
	public String largestNumber(int[] nums) {
		//这个题一开始我是自定义class然后写comparator，首先比较第一位数，然后比较第二位……后来想了一下其实直接把两个数转为String，然后分别前后拼接一下就可以比较了。直接sort就可以得到结果，代码更清晰。或者定义一个PriorityQueue，自定义comparator，把给定的数组转为这个queue也是一样的。
		if(nums==null || nums.length==0) return null;
		LinkedList<String> res=new LinkedList<>();
		for(int num:nums) {
			res.add(String.valueOf(num));
		}
		StringBuilder sb=new StringBuilder();
		Collections.sort(res, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1=o2+o1;
				String s2=o1+o2;
				//x.compareTo(a)  x==a 0 x>a 1 x<a -1
				return s1.compareTo(s2);
			}
		});
		for(String s:res) {
			sb.append(s);
		}
		int cnt = 0;
		while (cnt < sb.length() && sb.charAt(cnt) == '0') {
			cnt++;
		}
		return sb.substring(cnt == sb.length() ? cnt - 1 : cnt);
	}
}
