package com.java.leetcode;

public class ValidateIPAddress {
	/**
	 * ��дһ����������֤������ַ����Ƿ�����Ч�� IPv4 �� IPv6 ��ַ��
IPv4 ��ַ��ʮ�������͵�����ʾ��ÿ����ַ����4��ʮ���������䷶ΧΪ 0 - 255�� ��(".")�ָ���磬172.16.254.1��
ͬʱ��IPv4 ��ַ�ڵ��������� 0 ��ͷ�����磬��ַ 172.16.254.01 �ǲ��Ϸ��ġ�
IPv6 ��ַ��8��16���Ƶ���������ʾ��ÿ���ʾ 16 ���ء���Щ������ͨ�� (":")�ָ����,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 ��һ����Ч�ĵ�ַ�����ң����ǿ��Լ���һЩ�� 0 ��ͷ�����֣���ĸ����ʹ�ô�д��Ҳ������Сд�����ԣ� 2001:db8:85a3:0:0:8A2E:0370:7334 Ҳ��һ����Ч�� IPv6 address��ַ (�������� 0 ��ͷ�����Դ�Сд)��
Ȼ�������ǲ�����Ϊĳ�����ֵΪ 0����ʹ��һ���յ��飬�����ڳ��� (::) ������� ���磬 2001:0db8:85a3::8A2E:0370:7334 ����Ч�� IPv6 ��ַ��
ͬʱ���� IPv6 ��ַ�У������ 0 Ҳ�ǲ�������ġ����磬 02001:0db8:85a3:0000:0000:8a2e:0370:7334 ����Ч�ġ�
˵��: �������Ϊ�������ַ�����û�пո�������������ַ���

ʾ�� 1:

����: "172.16.254.1"
���: "IPv4"
����: ����һ����Ч�� IPv4 ��ַ, ���Է��� "IPv4"��

ʾ�� 2:
����: "2001:0db8:85a3:0:0:8A2E:0370:7334"
���: "IPv6"
����: ����һ����Ч�� IPv6 ��ַ, ���Է��� "IPv6"��

	 */
	public String validIPAddress(String IP) {
		if(validateIPv4(IP)) {
			return "IPv4";
		}
		if(validateIPv6(IP)) {
			return "IPv6";
		}
		return "Neither";
	}
	
	private boolean validateIPv4(String IP) {
		String[] strs=IP.split("\\.", -1);
		if(strs.length!=4) {
			return false;
		}
		for(String str:strs) {
			int len=str.length();
			if(len<1 || len>3 || (len>1 && str.charAt(0)=='0')) {
				return false;
			}
			for(char c:str.toCharArray()) {
				//�����������
				if(!Character.isDigit(c)) {
					return false;
				}
			}
			if(Integer.parseInt(str)>255) {
				return false;
			}
		}
		return true;	
	}
	
	private boolean validateIPv6(String IP) {
		String[] strs=IP.toLowerCase().split(":",-1);
		if(strs.length != 8) {
			return false;
		}
		for(String str:strs) {
			int len=str.length();
			if(len<1 || len>4) {
				return false;
			}
			for(char c:str.toCharArray()) {
				if(!Character.isDigit(c) && (c<'a' || c>'f')) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/*

split() ��������ƥ�������������ʽ������ַ�����

ע�⣺ . �� | �� * ��ת���ַ�������ü� \\��

ע�⣺����ָ����������� | ��Ϊ���ַ���
split(regex, limit)����

��һ������ͬ��һ�� ����Ϊ�ָ���ַ�������������ʽ

�ڶ�������limit �����ǿ��� ģʽӦ�õĴ��� 

���� limitΪ����������ʾ ģʽ��Ӧ�þ����ܶ�Ĵ��� ����-1

limit =0 ��ʾģʽӦ�þ����ܶ�Ĵ�����������������ⳤ�ȣ����ҽ�β���ַ�������������

limit>0ʱ ��ôģʽ����Ӧ��limit-1�� ���鳤�Ȳ��ᳬ��limit
	 */
}
