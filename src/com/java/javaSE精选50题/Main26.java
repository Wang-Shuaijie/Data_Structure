package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
 * @author WangShuaiJie
 *
 */
public class Main26 {
	public static void main(String[] args) {
		   System.out.println("请输入第一个英文字母：");
		   Scanner scanner=new Scanner(System.in);
		   String input=scanner.next();
		   String input2="";
		   switch (input) {
		       case"m":
		          System.out.println("Monday");
		          break;
		       case"t":
		          System.out.println("请输入第二个字母：");
		          input2=scanner.next();
		          if (input2.equals("u")) {
		              System.out.println("Tuesday");
		          }else if (input2.equals("h")) {
		              System.out.println("Thursday");
		          } else {
		              System.out.println("你输入的字母有误！");
		          }
		          break;
		       case"w":
		          System.out.println("Wednesday");
		          break;
		       case"f":
		          System.out.println("Friday");
		           break;
		       case"s":
		          System.out.println("请输入第二个字母：");
		          input2=scanner.next();
		          if (input2.equals("u")) {
		              System.out.println("Sunday");
		          }else if (input2.equals("a")) {
		              System.out.println("Saturday");
		          } else {
		              System.out.println("你输入的字母有误！");
		          }
		          break;
		       default:
		          System.out.println("你输入的字母不正确！");
		          break;
		   }
		   scanner.close();
		}

}
