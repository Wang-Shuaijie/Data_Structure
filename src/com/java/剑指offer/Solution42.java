package com.java.��ָoffer;

public class Solution42 {
	/**
	 * ��ת�ַ���
	 * Given s = "the sky is blue",
return "blue is sky the".
	 */
	public String ReverseSentence(String s) { 
		if(s.trim().equals("")){
            return s;
        }
        //����split�ָ�
		String res="";
		//ԭ�ַ�������trim()��ȥ������ո�Ȼ�����split()���ָ����ָ�����Ϊ"\\s+"������ʵ��һ��������ʽ��\\s��ʾ�ո��ַ���+��ʾ������һ�������ո��ַ�
		String[] words=s.trim().split("\\s+");
		for(int i=0;i<words.length;i++) {
			res=" "+words[i]+res;
		}
		return res.trim();
	}
	
		public String ReverseSentence2(String str) {
		        if(str==null||str.length()==0||str.trim().length()==0)
		            return str;
		        StringBuffer sb = new StringBuffer();
		        String[] s = str.trim().split(" ");
		        for(int i = s.length-1;i>=0;i--){
		            if(s[i]!="")
		                sb.append(s[i]);
		            if(i-1>=0)
		                sb.append(" ");
		        }
		        return sb.toString();
		    }

}
