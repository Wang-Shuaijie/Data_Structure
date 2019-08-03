package com.java.javaSE精选50题;
/**
 * 题目：一球从h米高度自由落下，每次落地后反跳回原高度的一半； 
 *  再落下，求它在 第n次落地时，共经过多少米？第n次反弹多高？
 * @author WangShuaiJie
 *
 */
public class Main10 {
	public static void main(String[] args) {
		System.out.println(getHeight(10, 3));
	}
	/*
	 *  经过的距离：这个可以总结得到：
	 *  第一次落地经过：h,
	 *  第二次落地经过：h+(h/2)*2,
	 *  第三次落地经过：h+(h/2)*2+(h/2/2)*2 
	 *  那么第n次落地经过：  h+(h/2)*2+(h/2/2)*2 +...+h/(2的n-1次方)*2
	 */
	private static float getHeight(float h, float n) {
		float sum=h;
		for(int i=2;i<=n;i++) {
			h=h/2;//第i次落地反弹高度
			sum+=h*2;//总经过距离		
		}
		return sum;
	}
}
