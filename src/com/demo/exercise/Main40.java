package com.demo.exercise;
/**
 * ��Ŀ���ַ�������
 * @author WangShuaiJie
 *
 */
public class Main40 {
	public static void main(String[] args) {
		/*
		 * boolean b=string1.compareTo(string2);
		 * string1������ֵ����string2����b�Ǵ����㣬����С����
		 */
		String[] str = {"abc","cad","m","fa","f"};
	     for(int i=0;i<str.length-1;i++){
	          for(int j=0;j<str.length-i-1;j++){
	               if(str[j].compareTo(str[j+1])<0){
	                   String temp = str[j];
	                   str[j] = str[j+1];
	                   str[j+1] = temp;
	               }
	          }
	     }
	     for(String subStr:str)

	         System.out.print(subStr+" ");

	}
}
