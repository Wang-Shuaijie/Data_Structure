package com.demo.LeetCode;

import java.util.Arrays;

public class AssignCookies {
	/**
	 * ��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ���ÿ������ i ������һ��θ��ֵ gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻����ÿ����� j ������һ���ߴ� sj ����� sj >= gi �����ǿ��Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��

ע�⣺

����Լ���θ��ֵΪ����
һ��С�������ֻ��ӵ��һ����ɡ�

ʾ�� 1:

����: [1,2,3], [1,1]

���: 1
	 */
	public static int findContentChildren(int[] g,int[] s) {
		if(s.length==0 || g.length==0) return 0;
		int res=0;
		int j=0;
		//�ȶ�С���ͱ�������
		Arrays.sort(g);
		Arrays.sort(s);
		for(int i=0;i<s.length;i++) {
			//����������С���ӵ�����
			if(s[i]>=g[j]) {
				res++;
				j++;
			}
			if(j>=g.length) break;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] s=new int[] {1,1,2};
		int[] g=new int[] {1,2};
		System.out.println(findContentChildren(g, s));
	}
}
