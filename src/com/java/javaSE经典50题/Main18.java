package com.java.javaSE����50��;
/**
 * ��Ŀ������ƹ����ӽ��б������������ˡ��׶�Ϊa,b,c���ˣ��Ҷ�Ϊx,y,z���ˡ��ѳ�ǩ��������������
 * �������Ա����������������a˵������x�ȣ�c˵������x,z�ȣ��������ҳ��������ֵ�������
 * @author WangShuaiJie
 *
 */
public class Main18 {
	public static void main(String[] args) {
		for(char a='x';a<='z';a++) {
			for(char b='x';b<='z';b++) {
				if(a!=b) {
					for(char c='x';c<='z';c++) {
						if(c!=a && c!=b && a!='x' && c!='x' && c!='z') {
							System.out.println("a--"+a);
							System.out.println("b--"+b);
							System.out.println("c--"+c);
						}
					}
				}
			}
		}
	}
}
