package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	/*
	 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
	 * ���磬���� n = 3�����ɽ��Ϊ��
	 * [
	 * "((()))",
	 * "(()())",
	 * "(())()",
	 * "()(())",
	 * "()()()"
	 * ]
	 * 
	 * ��������
	 * [(0,n-1),(1,n-2),(3,n-3,....(n-1,n))]
	 * �����ַ���ֻ�������ź������������ַ����������ս���ض���������3����������3����
	 * �������Ƕ�����������left��right�ֱ��ʾʣ���������ŵĸ����������ĳ�εݹ�ʱ�������ŵĸ������������ŵĸ�����
	 * ˵����ʱ���ɵ��ַ����������ŵĸ������������ŵĸ������������')('�����ķǷ����������������ֱ�ӷ��أ�����������
	 * ���left��right��Ϊ0����˵����ʱ���ɵ��ַ�������3�������ź�3�������ţ����ַ����Ϸ�����������к󷵻ء�
	 * ���������������������㣬����ʱleft����0������õݹ麯����ע������ĸ��£���right����0������õݹ麯����ͬ��Ҫ���²���
	 */
	public static List<String> generateParenthesis(int n){
		List<String> res=new ArrayList<>();
		if(n==0) return res;
		helper(res, "", n, n);
		return res;
	}
	
	public static void helper(List<String> res,String s,int left,int right) {
		if(left>right) {
			return;
		}
		if(left==0 && right==0) {
			res.add(s);
			return;
		}
		if(left>0) {
			helper(res, s+"(", left-1, right);
		}
		if(right>0) {
			helper(res, s+")", left, right-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
