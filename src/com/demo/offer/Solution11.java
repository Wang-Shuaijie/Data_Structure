package com.demo.offer;

public class Solution11 {
	/**
	 * 给定一个double类型的浮点数base和int类型的整数exponent。
	 * 求base的exponent次方。不得使用库函数，不需要考虑大数问题
	 */
	public double power(double base, int exponent) {
		double res=0;
		if(exponent==0) return 1.000000;
		//if(base==0)不能这样写，浮点数有误差
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
