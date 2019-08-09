package com.java.campus;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * av394281中，充满威严的蕾米莉亚大小姐因为触犯某条禁忌，被隙间妖怪八云紫（紫m……èi）按住头在键盘上滚动。
同样在弹幕里乱刷梗被紫姐姐做成罪袋的你被指派找到大小姐脸滚键盘打出的一行字中的第 `k` 个仅出现一次的字。
(为简化问题，大小姐没有滚出 ascii 字符集以外的字)
输出描述:
输出的每一行对应输入的每一行的答案，如果无解，输出字符串`Myon~`
(请不要输出多余的空行）
为了方便评测，如果答案存在且为c，请输出[c]

示例1
输入
2 misakamikotodaisuki
3 !bakabaka~ bakabaka~ 1~2~9!
3 3.1415926535897932384626433832795028841971693993751o582097494459211451488946419191919l91919hmmhmmahhhhhhhhhh
7 www.bilibili.com/av170001
1 111
输出
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
