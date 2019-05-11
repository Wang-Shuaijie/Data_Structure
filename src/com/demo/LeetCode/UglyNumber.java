package com.demo.LeetCode;

public class UglyNumber {
	/**
	 * ���һ�����Ƿ�Ϊ��ª������ν��ª����������������ֻ����2,3,5��
	 */
	public boolean isUgly(int num) {
		while(num>=2) {
			if(num%2==0) num/=2;
			else if(num%3==0) num/=3;
			else if(num%5==0) num/=5;
			else return false;
		}
		return num==1;
	}
	
	public boolean isUgly2(int num) {
		if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
	}
}
