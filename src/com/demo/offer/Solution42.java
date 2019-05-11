package com.demo.offer;

public class Solution42 {
	/**
	 * ·­×ª×Ö·û´®
	 * Given s = "the sky is blue",
return "blue is sky the".
	 */
	public String ReverseSentence(String str) { 
		if (str == null || str.length() == 0) return str; 
		if (str.trim().length() == 0) return str; 
		StringBuilder sb = new StringBuilder(); 
		String re = reverse(str); 
		String[] s = re.split(" "); 
		for (int i = 0; i < s.length - 1; i++) { 
			sb.append(reverse(s[i]) + " "); 
		} 
		sb.append(reverse(s[s.length-1])); 
		return String.valueOf(sb); 
	} 
	public String reverse(String str) { 
		StringBuilder sb = new StringBuilder(); 
		for (int i = str.length() - 1; i >= 0 ; i--) { 
			sb.append(str.charAt(i)); 
		} 
		return String.valueOf(sb); 
	}

}
