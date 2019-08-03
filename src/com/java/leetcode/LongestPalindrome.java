package com.java.leetcode;

public class LongestPalindrome {
	/**
	 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
	 * ʾ�� 1������: "babad"���: "bab"ע��: "aba" Ҳ��һ����Ч�𰸡�
	 * ���Ĵ�����������������һ�����ַ��������� "bob", "level"
	 */
	private String res="";
	public String longestPalindrome(String s) {
		//�ж��ַ�������
		if(s.length() == 0 || s == null ) return s;
		//String res="";resӦ��Ϊȫ�ֱ���
		for(int i=0;i<s.length();i++) {
			helper(s, i, i);
			helper(s, i, i+1);//�ж�cbba�������
		}
		return res;
	}
	
	public void helper(String s,int left,int right) {
		/*
		 * babad
		 * i=2 b  left--(1) right++(3) 
		 * aba //������ɢleft--(0) right++(4) 
		 * 				  babad
		 */
		while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		//String res="";
		//substring(x)�Ǵ��ַ����ĵĵ�x���ַ���ȡ;;substring(x,y���Ǵ�x��yǰ��λ��ֹͣ(����x������y)
		String cur=s.substring(left+1, right);
		//System.out.println(cur);
		if(cur.length() > res.length()) {
			res=cur;
		}
	}
	
	public static String longestPalindrome2(String s) {
		//�ж��ַ�������
		if(s.length() == 0 || s == null ) return s;
		String res="";
		boolean[][] dp=new boolean[s.length()][s.length()];
		//����Ƿ��
		int max=0;
		/*
		 * ����
		 * babad 
		 * i=2 ���� bab
		 * i=4 ���� babad  i=4 j=2 ����bad i=2 j=0 ����bab
		 */		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				dp[j][i] =  s.charAt(i)==s.charAt(j) && ((i-j <= 2) || dp[j+1][i-1]);
				if(dp[j][i]) {
					if(i - j + 1 > max) {
						max = i-j+1;
						res=s.substring(j, i+1);
					}
				}
			}
		}
		return res;
	}
	
	
	
	
}
