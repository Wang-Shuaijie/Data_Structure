package com.demo.test;
/**
 * 凯撒密码
 * @author WangShuaiJie
 *
 */
public class Main11 {
	public static void main(String[] args) {
		encode("abc123", 3);
		decode("def123", 3);
	}
	
	//加密
	public static void encode(String str, int k) {
		StringBuilder res=new StringBuilder();
		for(char c:str.toCharArray()) {
			c=encrypt(c, k);
			res.append(c);
		}
		System.out.println(res.toString());
	}
	
	//解密
	public static void decode(String str, int k) {
		k=0-k;
		encode(str, k);
	}
	
	
	private static char encrypt(char c, int k) {
		if(c>='a' && c<='z') {
			// 移动key%26位
			c=(char) (c+k%26);
			if (c < 'a') {
	            c += 26; // 向左超界
	         } else if (c > 'z') {
	            c -= 26; // 向右超界
	         }
		}
		// 如果字符串中的某个字符是大写字母
	      else if (c >= 'A' && c <= 'Z') {
	         c += k % 26; // 移动key%26位
	         if (c < 'A') {
	            c += 26;// 同上
	         } else if (c > 'Z') {
	            c -= 26;// 同上
	         }
	      }
		return c;
	}
}
