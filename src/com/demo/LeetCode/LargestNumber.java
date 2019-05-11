package com.demo.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LargestNumber {
	/**
	 * ����һ��Ǹ������������������ǵ�˳��ʹ֮���һ������������

ʾ�� 1:

����: [10,2]
���: 210

ʾ�� 2:

����: [3,30,34,5,9]
���: 9534330

˵��: ���������ܷǳ�����������Ҫ����һ���ַ���������������

	 */
	public String largestNumber(int[] nums) {
		//�����һ��ʼ�����Զ���classȻ��дcomparator�����ȱȽϵ�һλ����Ȼ��Ƚϵڶ�λ������������һ����ʵֱ�Ӱ�������תΪString��Ȼ��ֱ�ǰ��ƴ��һ�¾Ϳ��ԱȽ��ˡ�ֱ��sort�Ϳ��Եõ��������������������߶���һ��PriorityQueue���Զ���comparator���Ѹ���������תΪ���queueҲ��һ���ġ�
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
