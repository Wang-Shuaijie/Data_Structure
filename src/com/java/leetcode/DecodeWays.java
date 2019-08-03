package com.java.leetcode;
/**
 *  һ��������ĸ A-Z ����Ϣͨ�����·�ʽ�����˱��룺

'A' -> 1
'B' -> 2
...
'Z' -> 26

����һ��ֻ�������ֵķǿ��ַ������������뷽����������
��������:
һ������������֣�����12
�������:
���뷽��������
��������1:
12
�������1:
2
12���Խ���ɡ�AB������A��B"������
 * @author WangShuaiJie
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if(s.isEmpty() || s.charAt(0)=='0') return 0;
		int[] dp=new int[s.length()+1];
		dp[0]=1;
		for(int i=1;i<dp.length;i++) {
			dp[i]=(s.charAt(i-1)=='0'?0:dp[i-1]);
			if(i>1 && (s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<='6')) {
				dp[i]+=dp[i-2];
			}
		}
		return dp[s.length()];
	}
}
