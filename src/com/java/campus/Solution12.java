package com.java.campus;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * av394281�У��������ϵ��������Ǵ�С����Ϊ����ĳ�����ɣ���϶�����ְ����ϣ���m������i����סͷ�ڼ����Ϲ�����
ͬ���ڵ�Ļ����ˢ�����Ͻ������������㱻ָ���ҵ���С���������̴����һ�����еĵ� `k` ��������һ�ε��֡�
(Ϊ�����⣬��С��û�й��� ascii �ַ����������)
�������:
�����ÿһ�ж�Ӧ�����ÿһ�еĴ𰸣�����޽⣬����ַ���`Myon~`
(�벻Ҫ�������Ŀ��У�
Ϊ�˷������⣬����𰸴�����Ϊc�������[c]

ʾ��1
����
2 misakamikotodaisuki
3 !bakabaka~ bakabaka~ 1~2~9!
3 3.1415926535897932384626433832795028841971693993751o582097494459211451488946419191919l91919hmmhmmahhhhhhhhhh
7 www.bilibili.com/av170001
1 111
���
[d]
[9]
[l]
[7]
Myon~
 * @author WangShuaiJie
 *
 */
public class Solution12 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(getAppearOnce(n,str));
        }
         
    }
     
    private static String getAppearOnce(int n, String str){
        if(str.length()==0 || str==null || n>=str.length()) return "Myon~";
        LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int count=0;
        for(Character c:map.keySet()){
            if(map.get(c)==1){
                count=count+1;
                if(count==n){
                    return c.toString();
                }
            }
        }
        return "Myon~";
    }
}
