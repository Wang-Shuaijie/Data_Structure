package com.java.leetcode.贪心;
/**
 * s = "abc", t = "ahbgdc"
Return true.
 * @author WangShuaiJie
 *
 */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int index=-1;
		for(char c:s.toCharArray()) {
			//public int indexOf(int ch, int fromIndex): 
			//返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
			//如果此字符串中没有这样的字符，则返回 -1。
			index=t.indexOf(c, index+1);
			if(index==-1) {
				return false;
			}
		}
		return true;
	}
}
