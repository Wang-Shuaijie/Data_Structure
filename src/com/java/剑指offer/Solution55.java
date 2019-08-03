package com.java.剑指offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution55 {
	/**
	 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
	 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
	 */
	
	//借助辅助空间
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
