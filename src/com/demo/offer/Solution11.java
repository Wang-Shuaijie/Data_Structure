package com.demo.offer;

public class Solution11 {
	/**
	 * ����һ��double���͵ĸ�����base��int���͵�����exponent��
	 * ��base��exponent�η�������ʹ�ÿ⺯��������Ҫ���Ǵ�������
	 */
	public double power(double base, int exponent) {
		double res=0;
		if(exponent==0) return 1.000000;
		//if(base==0)��������д�������������
		if(base >= -0.000001 && base <= 0.000001) return 0;
		if(exponent>0) {
			for(int i=0;i<exponent;i++) {
				res*=base;
			}
		}else {
			for(int i=0;i<(-exponent);i++) {
				res*=base;
			}
			res=1.0/base;
		}
		return res;
	}
	
	//x^n=(x*x)^(n/2) n%2=0
	//x^n=x*(x*x)^(n/2) n%2=1
	public double power2(double base, int exponent) {
		if (exponent == 0)
	        return 1;
	    if (exponent == 1)
	        return base;
	    boolean isNegative = false;
	    if (exponent < 0) {
	        exponent = -exponent;
	        isNegative = true;
	    }
	    double pow = power2(base * base, exponent / 2);
	    if (exponent % 2 != 0)
	        pow = pow * base;
	    return isNegative ? 1 / pow : pow;
	}
}
