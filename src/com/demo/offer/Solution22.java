package com.demo.offer;

import java.util.Stack;

public class Solution22 {
	/**
	 * ���������������У���һ�����б�ʾջ��ѹ��˳��
	 * ���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
	 * ����ѹ��ջ���������־�����ȡ�
	 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
	 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
	 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�

	˼·����ջ��ѹ�뵯��Ԫ�أ�������ջ��
	 */
	public boolean IsPopOrder(int[] push, int[] pop) {
		if(push==null || push.length==0 || pop==null || pop.length==0 || push.length!=pop.length) return false;
		Stack<Integer> stack=new Stack<>();
		int index=0;
		for(int i=0;i<push.length;i++) {
			stack.push(push[i]);
			while(!stack.isEmpty() && stack.peek()==pop[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}
}
