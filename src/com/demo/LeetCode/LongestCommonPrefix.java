package com.demo.LeetCode;

public class LongestCommonPrefix {
	/**
	 * ��дһ�������������ַ��������е������ǰ׺��
	 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
	 * ����: ["flower","flow","flight"] ���: "fl"
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";
		String res=strs[0];
		//��1��ʼ�Ƚ�
		for(int i=1;i<strs.length;i++) {
			/*
			 * indexOf����ĳ��ָ�����ַ���ֵ���ַ������״γ��ֵ�λ�ã�û�з���-1
			 * ��flow indexOf("fl") return 0;
			 * 
			 * ����flower��û�н�ȡ�ַ�
			 * ��flowe û�н�ȡ�ַ�
			 * ....
			 * ��fl
			 */
			while(strs[i].indexOf(res)!=0) {
				res=res.substring(0, res.length()-1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] strs=new String[] {"flowers","flight","flow"};
		System.out.println(longestCommonPrefix(strs));
	}
}
