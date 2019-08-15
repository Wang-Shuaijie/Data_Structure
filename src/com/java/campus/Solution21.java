package com.java.campus;

import java.util.Scanner;
import java.util.Stack;

/**
 * ʵ��һ��HTML�﷨�������HTML�﷨��������£���ǩ����պϣ������ɿ�ʼ�ͽ���������ǩ�պϣ���<div></div>��Ҳ�����Ապϣ�
��<div />
��ǩ����Ƕ����<div><a></a></div>���� <div><a/></div>�����Ǳ�ǩ���ܽ��棺<div><a></div></a>�ǲ�����ı�ǩ�����������
��<div id="a<1"></div>
���ԵĹ�����name="����������ַ�"������������֮������пո��������������Ϲ���ʱ������HTML�����﷨����
�����ı�ֻ�������ĸa-z��<>"=
������������ʵ��һ��HTML�﷨��������������﷨���󷵻�1��û���﷨���󷵻�0
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
        str = str.trim(); //����ǰ��Ŀո�
        if(str == null && str.length() == 0) return false;
        Stack<String> stack = new Stack<>(); //��¼��ǩ����ջ˳��
        int i = 0;
        while(i < str.length()){
            if(i == 0 && str.charAt(i) != '<') return false; //��һ���ַ�����<������������Ա�ǩ��ʼ
            if(i == str.length() - 1 && str.charAt(i) != '>') return false; //�����ַ�����>������������Ա�ǩ����
            if(str.charAt(i) == '<'){
                int j = i + 1;
                //'<'֮������Ǳ�ǩ��������'<'֮����ַ��ض���a-z����'/'
                if(j < str.length() && (str.charAt(j) >= 'a' && str.charAt(j) <= 'z' || str.charAt(j) == '/')){
                    //��ȡ��ǩ�ַ���<xx xx="">
                    boolean inStr = false; //�Ƿ����ַ���"����
                    while(j < str.length()){
                        if(!inStr && str.charAt(j) == '>'){  //��ǩ����
                            if(!checkAtt(str.substring(i + 1, j), stack)) //����ı�ǩ�Ѿ�ȥ��'<'��'>'�ַ�
                                return false; //�������﷨����
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
     
    public static boolean checkAtt(String str, Stack<String> stack){  //�����ǩ���������
        if(str == null && str.length() == 0) return true;
        int type = 0; //��¼��ǩ�����ͣ�0Ϊ��ʼ��ǩ<x>��1Ϊ������ǩ</x>,2Ϊ�Ապϱ�ǩ<x/>
        if(str.charAt(0) == '/'){  //�ж��Ƿ��ǽ�����ǩ
            if(!(str.length() >= 2 && str.charAt(1) >= 'a' && str.charAt(1) <= 'z')) return false; //������ǩ��'/'֮����������ĸ
            type = 1; //Ϊ������ǩ
            str = str.substring(1);
        }
        str = str.trim(); //ȥ���ַ�������Ŀո�
        if(str.charAt(str.length() - 1) == '/'){ //�ж��Ƿ����Ապϱ�ǩ
            if(type == 1) return false; //����ͬʱΪ������ǩ�������Ապϱ�ǩ
            type = 2;
            str = str.substring(0, str.length() - 1);// ȥ������'/'
        }
        int i = 0;
        //��ȡ��ǩ�����֣����ж��Ƿ���ϱպϹ���
        while(i < str.length() && str.charAt(i) != ' ') i++;
        String name = str.substring(0, i);
        if(type == 0) stack.push(name);
        else if(type == 1){
            if(!stack.isEmpty() && stack.peek().equals(name)) stack.pop();
            else return false;
        }
        //�ж��������Ƿ����﷨����
        boolean hasAtt = false; //�жϸñ�ǩ�Ƿ������ԣ���Խ�����ǩ����������
        boolean hasBlank = false; //�ж�����name֮ǰ�Ƿ��пո�
        while(i < str.length()){
            while(i < str.length() && str.charAt(i) == ' ') {hasBlank = true; i++;}
            while(i < str.length() && str.charAt(i) != '=' && str.charAt(i) != ' ') i++; //��ȡ��������
            if(i < str.length() && str.charAt(i) == '='){ //���û��'='˵���������ԣ������д���
                i++;
                if(i >= str.length() || str.charAt(i) != '"') return false; //'='֮�������˫����
                i++;
                while(i < str.length() && str.charAt(i) != '"') i++; //Ѱ����һ��˫����
                if(i >= str.length()) return false;
                if(!hasBlank) return false; //����֮ǰû�пո��﷨����
            }
            hasBlank = false;
            hasAtt = true;
            i++;
        }
        if(type == 1 && hasAtt) return false; //������ǩ����������
        return true;
    }
}
