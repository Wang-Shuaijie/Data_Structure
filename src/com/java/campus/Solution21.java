package com.java.campus;

import java.util.Scanner;
import java.util.Stack;

/**
 * 实现一个HTML语法检查器。HTML语法规则简化如下：标签必须闭合，可以由开始和结束两个标签闭合，如<div></div>，也可以自闭合，
如<div />
标签可以嵌套如<div><a></a></div>或者 <div><a/></div>，但是标签不能交叉：<div><a></div></a>是不允许的标签里可以有属性
如<div id="a<1"></div>
属性的规则是name="任意非引号字符"，多属性声明之间必须有空格，属性声明不符合规则时，整段HTML都算语法错误
输入文本只会出现字母a-z和<>"=
请用任意语言实现一个HTML语法检查器函数，有语法错误返回1，没有语法错误返回0
 * @author WangShuaiJie
 *
 */
public class Solution21 {
	public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int result = 1;
        if(solve(str)) result = 0;
        System.out.println(result);
    }
     
    public static boolean solve(String str){
        str = str.trim(); //消除前后的空格
        if(str == null && str.length() == 0) return false;
        Stack<String> stack = new Stack<>(); //记录标签的入栈顺序
        int i = 0;
        while(i < str.length()){
            if(i == 0 && str.charAt(i) != '<') return false; //第一个字符不是<，则表明不是以标签开始
            if(i == str.length() - 1 && str.charAt(i) != '>') return false; //最后的字符不是>，则表明不是以标签结束
            if(str.charAt(i) == '<'){
                int j = i + 1;
                //'<'之后如果是标签，紧跟在'<'之后的字符必定是a-z或者'/'
                if(j < str.length() && (str.charAt(j) >= 'a' && str.charAt(j) <= 'z' || str.charAt(j) == '/')){
                    //获取标签字符串<xx xx="">
                    boolean inStr = false; //是否处于字符串"里面
                    while(j < str.length()){
                        if(!inStr && str.charAt(j) == '>'){  //标签结束
                            if(!checkAtt(str.substring(i + 1, j), stack)) //传入的标签已经去除'<'和'>'字符
                                return false; //属性有语法错误
                            i = j;
                            break;
                        }
                        else if(str.charAt(j) == '"') inStr = !inStr;
                        j++;
                    }
                }
            }
            i++;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
     
    public static boolean checkAtt(String str, Stack<String> stack){  //处理标签里面的属性
        if(str == null && str.length() == 0) return true;
        int type = 0; //记录标签的类型，0为开始标签<x>，1为结束标签</x>,2为自闭合标签<x/>
        if(str.charAt(0) == '/'){  //判断是否是结束标签
            if(!(str.length() >= 2 && str.charAt(1) >= 'a' && str.charAt(1) <= 'z')) return false; //结束标签的'/'之后必须紧跟字母
            type = 1; //为结束标签
            str = str.substring(1);
        }
        str = str.trim(); //去除字符串后面的空格
        if(str.charAt(str.length() - 1) == '/'){ //判断是否是自闭合标签
            if(type == 1) return false; //不能同时为结束标签，又是自闭合标签
            type = 2;
            str = str.substring(0, str.length() - 1);// 去除最后的'/'
        }
        int i = 0;
        //获取标签的名字，并判断是否符合闭合规则
        while(i < str.length() && str.charAt(i) != ' ') i++;
        String name = str.substring(0, i);
        if(type == 0) stack.push(name);
        else if(type == 1){
            if(!stack.isEmpty() && stack.peek().equals(name)) stack.pop();
            else return false;
        }
        //判断其属性是否有语法错误
        boolean hasAtt = false; //判断该标签是否有属性，针对结束标签不能有属性
        boolean hasBlank = false; //判断属性name之前是否有空格
        while(i < str.length()){
            while(i < str.length() && str.charAt(i) == ' ') {hasBlank = true; i++;}
            while(i < str.length() && str.charAt(i) != '=' && str.charAt(i) != ' ') i++; //获取属性名字
            if(i < str.length() && str.charAt(i) == '='){ //如果没有'='说明不是属性，不进行处理
                i++;
                if(i >= str.length() || str.charAt(i) != '"') return false; //'='之后必须是双引号
                i++;
                while(i < str.length() && str.charAt(i) != '"') i++; //寻找下一个双引号
                if(i >= str.length()) return false;
                if(!hasBlank) return false; //属性之前没有空格，语法错误
            }
            hasBlank = false;
            hasAtt = true;
            i++;
        }
        if(type == 1 && hasAtt) return false; //结束标签不能有属性
        return true;
    }
}
