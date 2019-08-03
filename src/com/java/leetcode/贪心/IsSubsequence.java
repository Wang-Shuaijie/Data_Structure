package com.java.leetcode.̰��;
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
			//���ش� fromIndex λ�ÿ�ʼ����ָ���ַ����ַ����е�һ�γ��ִ���������
			//������ַ�����û���������ַ����򷵻� -1��
			index=t.indexOf(c, index+1);
			if(index==-1) {
				return false;
			}
		}
		return true;
	}
}
