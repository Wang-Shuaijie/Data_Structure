package com.demo.test;
/**
 * ��������
 * @author WangShuaiJie
 *
 */
public class Main11 {
	public static void main(String[] args) {
		encode("abc123", 3);
		decode("def123", 3);
	}
	
	//����
	public static void encode(String str, int k) {
		StringBuilder res=new StringBuilder();
		for(char c:str.toCharArray()) {
			c=encrypt(c, k);
			res.append(c);
		}
		System.out.println(res.toString());
	}
	
	//����
	public static void decode(String str, int k) {
		k=0-k;
		encode(str, k);
	}
	
	
	private static char encrypt(char c, int k) {
		if(c>='a' && c<='z') {
			// �ƶ�key%26λ
			c=(char) (c+k%26);
			if (c < 'a') {
	            c += 26; // ���󳬽�
	         } else if (c > 'z') {
	            c -= 26; // ���ҳ���
	         }
		}
		// ����ַ����е�ĳ���ַ��Ǵ�д��ĸ
	      else if (c >= 'A' && c <= 'Z') {
	         c += k % 26; // �ƶ�key%26λ
	         if (c < 'A') {
	            c += 26;// ͬ��
	         } else if (c > 'Z') {
	            c -= 26;// ͬ��
	         }
	      }
		return c;
	}
}
