package com.java.javaSE精选50题;
/**
 * 题目：海滩上有一堆桃子，五只猴子来分。
 * 第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
 * 第三、第四、第五只猴子都是这样做的，已知第五只拿走了一个桃子，问海滩上原来最少有多少个桃子？
 * @author WangShuaiJie
 *
 */
public class Main41 {
	public static void main(String[] args) {
		System.out.println(getPeach(1));
	}
	//逆向思维
	/**              5     4      3     2      1     

	  *    桃子个数     6     31    156   781     3906

	  *猴子拿的个数     1      6    31    156     781*/
	//上一次*5+1
	//如getPeach(4)=getPeach(5)*5+1=6*5+1=31
	private static int getPeach(int i) {
		if(i==5) {
			return 6;
		}
		return getPeach(i+1)*5+1;
	}
}
