package com.demo.leetcode.̰��;

import java.util.Arrays;

/**
 * Input: [1,2], [1,2,3]
Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.

��Ŀ������ÿ�����Ӷ���һ������ȣ�ÿ�����ɶ���һ����С��ֻ�б��ɵĴ�С���ڵ���һ�����ӵ�����ȣ�
�ú��ӲŻ������㡣��������Ի������ĺ���������
 * @author WangShuaiJie
 *
 */
public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int gi=0, si=0;
		while(gi<g.length && si<s.length) {
			if(g[gi]<=s[si]) {
				gi++;
			}
			si++;
		}
		return gi;
	}
}
