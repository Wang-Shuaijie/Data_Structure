package com.java.javaSE50题;
/**
 * 100以内的素数
 * @author WangShuaiJie
 *
 */
public class Main27 {
	public static void main(String[] args) {
		for(int i=1;i<=100;i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	private static boolean isPrime(int n) {
		if(n==1) return false;
		else if(n==2) return true;
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
