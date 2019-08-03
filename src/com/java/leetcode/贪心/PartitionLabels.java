package com.java.leetcode.贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
题目描述： 分隔字符串使同种字符出现在一起
 * @author WangShuaiJie
 *
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
	    int[] lastIndexsOfChar = new int[26];
	    for (int i = 0; i < S.length(); i++) {
	        lastIndexsOfChar[char2Index(S.charAt(i))] = i;
	    }
	    List<Integer> partitions = new ArrayList<>();
	    int firstIndex = 0;
	    while (firstIndex < S.length()) {
	        int lastIndex = firstIndex;
	        for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
	            int index = lastIndexsOfChar[char2Index(S.charAt(i))];
	            if (index > lastIndex) {
	                lastIndex = index;
	            }
	        }
	        partitions.add(lastIndex - firstIndex + 1);
	        firstIndex = lastIndex + 1;
	    }
	    return partitions;
	}

	private int char2Index(char c) {
	    return c - 'a';
	}
}
