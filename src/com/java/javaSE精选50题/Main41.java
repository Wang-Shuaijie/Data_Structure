package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ����̲����һ�����ӣ���ֻ�������֡�
 * ��һֻ���Ӱ��������ƾ�ݷ�Ϊ��ݣ�����һ������ֻ���ӰѶ��һ�����뺣�У�������һ�ݡ�
 * �ڶ�ֻ���Ӱ�ʣ�µ�������ƽ���ֳ���ݣ��ֶ���һ������ͬ���Ѷ��һ�����뺣�У�������һ�ݣ�
 * ���������ġ�����ֻ���Ӷ����������ģ���֪����ֻ������һ�����ӣ��ʺ�̲��ԭ�������ж��ٸ����ӣ�
 * @author WangShuaiJie
 *
 */
public class Main41 {
	public static void main(String[] args) {
		System.out.println(getPeach(1));
	}
	//����˼ά
	/**              5     4      3     2      1     

	  *    ���Ӹ���     6     31    156   781     3906

	  *�����õĸ���     1      6    31    156     781*/
	//��һ��*5+1
	//��getPeach(4)=getPeach(5)*5+1=6*5+1=31
	private static int getPeach(int i) {
		if(i==5) {
			return 6;
		}
		return getPeach(i+1)*5+1;
	}
}
