package com.java.剑指offer;

public class Solution42 {
	/**
	 * 翻转字符串
	 * Given s = "the sky is blue",
return "blue is sky the".
	 */
	public String ReverseSentence(String s) { 
		if(s.trim().equals("")){
            return s;
        }
        //利用split分割
		String res="";
		//原字符串调用trim()来去除冗余空格，然后调用split()来分隔，分隔符设为"\\s+"，这其实是一个正则表达式，\\s表示空格字符，+表示可以有一个或多个空格字符
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
