package com.java.leetcode.���ֲ���;
/**
 * Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

��Ŀ����������һ��������ַ����� letters ��һ���ַ� target��
Ҫ���ҳ� letters �д��� target ����С�ַ�������Ҳ����ͷ��ص� 1 ���ַ���
 * @author WangShuaiJie
 *
 */
public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int l=0, h=letters.length-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(letters[m]<=target) {
				l=m+1;
			}else {
				h=m-1;
			}
		}
		return l<letters.length-1?letters[l]:letters[0];
	}
}
