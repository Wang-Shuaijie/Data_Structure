package com.demo.leetcode.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按照字符出现次数对字符串排序
 * Input:"tree"
 * Output:"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * @author WangShuaiJie
 *
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(char c:s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		List<Character>[] buckets=new ArrayList[s.length()+1];
		for(char c:map.keySet()) {
			int f=map.get(c);
			if(buckets[f]==null) buckets[f]=new ArrayList<>();
			buckets[f].add(c);
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=buckets.length-1;i>=0;i--) {
			if(buckets[i]==null) continue;
			for(char c:buckets[i]) {
				for(int j=0;j<i;j++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
