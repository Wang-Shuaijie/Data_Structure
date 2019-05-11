package com.demo.offer;

public class Solution53 {
	/**
	 * ��ʵ��һ����������ƥ�������.���͡�*����������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ�
	 */
	//��̬�滮�ⷨ
	public boolean match(char[] str, char[] pattern) {
		int m=str.length, n=pattern.length;
		boolean[][] dp=new boolean[m+1][n+1];
		dp[0][0]=true;
		for(int i=1;i<=n;i++) {
			if(pattern[i-1]=='*') {
				dp[0][i]=dp[0][i-2];
			}
		}
		for (int i = 1; i <= m; i++)
	        for (int j = 1; j <= n; j++)
	            if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (pattern[j - 1] == '*')
	                if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
	                    dp[i][j] |= dp[i][j - 1]; // a* counts as single a
	                    dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
	                    dp[i][j] |= dp[i][j - 2]; // a* counts as empty
	                } else
	                    dp[i][j] = dp[i][j - 2];   // a* only counts as empty

	    return dp[m][n];
	}
	
	//�ַ����жϽⷨ
	public boolean match2(char[] str, char[] pattern) {
	    if (str == null || pattern == null)
	        return false;
	    // ���ַ����ĳ���Ϊ1
	    if (str.length == 1) {
	        if (pattern.length == 1){
	            if (str[0] == pattern[0] || pattern[0] == '.')
	                return true;
	            return false;
	        }
	    }
	    int sindex = 0;
	    int pindex = 0;
	    return matchIndex(str,sindex,pattern,pindex);
	}

	public boolean matchIndex(char[] str,int sindex, char[] pattern, int pindex) {
	    // str��patternͬʱ����ĩβ����ƥ��ɹ�
	    if (sindex == str.length && pindex == pattern.length)
	        return true;
	    // ��pattern�ȵ�β����strû�е���ĩβ����ƥ��ʧ��
	    if (sindex != str.length && pindex == pattern.length)
	        return false;
	    // ��pattern�ڶ����ַ���*
	    if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
	        if (sindex != str.length && pattern[pindex] == str[sindex] ||
	                sindex != str.length && pattern[pindex] == '.') {
	            return matchIndex(str,sindex+1,pattern,pindex+2)
	                    || matchIndex(str,sindex,pattern,pindex+2)
	                    || matchIndex(str,sindex+1,pattern,pindex);
	        } else {
	            return matchIndex(str,sindex,pattern,pindex+2);
	        }
	    }
	    // ��pattern�ڶ����ַ�����*
	    if (sindex != str.length && pattern[pindex] == str[sindex] ||
	            sindex != str.length && pattern[pindex] == '.')
	        return matchIndex(str,sindex+1,pattern,pindex+1);
	    return false;
	}
	
	
	public boolean isMatch(String s, String p) {
		if(s.length()==0 && p.length()==0) return true;
		char s0 = getCharWithoutOverSteo(s, 0), p0=getCharWithoutOverSteo(p, 0), p1=getCharWithoutOverSteo(p, 1);
		if(isMatchCharacter(s0, p0) || p1=='*') {
			if(p1!='*') {
				if(s.length()==0) return false;
				return isMatch(s.substring(1), p.substring(1));
			}
			int i=0;
			boolean res=isMatch(s.substring(0), p.substring(2));
			if(res) return res;
			while(i<s.length() && isMatchCharacter(getCharWithoutOverSteo(s, i), p0)) {
				res=isMatch(s.substring(i+1), p.substring(2));
				if(res) return res;
				i++;
			}
		}
		return false;
	}
	
	private boolean isMatchCharacter(char a, char b) {
		if(a==b || a=='.' || b=='.') {
			return true;
		}
		return false;
	}
	private char getCharWithoutOverSteo(String s, int index) {
		if(s.length()>index) {
			return s.charAt(index);
		}
		return 0;
	}

}
