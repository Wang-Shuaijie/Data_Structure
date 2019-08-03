package com.java.��ָoffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution55 {
	/**
	 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
	 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���'g'�����Ӹ��ַ����ж���ǰ�����ַ�"google"ʱ����һ��ֻ����һ�ε��ַ���'l'��
	 */
	
	//���������ռ�
	 Map<Character, Integer> map=new HashMap<>();
	 Queue<Character> queue=new LinkedList<>();
	 public void insert(char ch) {
		 if(map.containsKey(ch)) {
			 map.put(ch, map.get(ch)+1);
		 }else {
			 map.put(ch, 1);
		 }
		 if(map.get(ch)>1) {
			 while(queue.size()!=0 && map.get(queue.peek())>1) {
				 queue.poll();
			 }
		 }else {
			 queue.add(ch);
		 }
	 }
	 
	 public char firstAppearingOnce() {
		 if(!queue.isEmpty()) {
			 return queue.peek();
		 }
		 else return ' ';
	 }
}
