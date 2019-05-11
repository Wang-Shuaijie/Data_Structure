package com.demo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution28 {
	/*
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	 * 全排列
	 */
	public static List<String> permutation(String str){
		List<String> res=new ArrayList<>();
		if(str==null || str.length()==0) return res;
		char[] chars=str.toCharArray();
		Arrays.sort(chars);
		helper(res,new ArrayList<>(),chars,new boolean[chars.length]);
		return res;
	}

	private static void helper(List<String> res, List<Character> list, char[] chars, boolean[] used) {
		if(list.size()==chars.length) {
			StringBuilder builder = new StringBuilder(list.size());
		    for(Character ch: list){
		        builder.append(ch);
		    }
		    res.add(builder.toString());
		}
		for(int i=0;i<chars.length;i++) {
			if(used[i] || i>0 && chars[i]==chars[i-1] && !used[i-1]) continue;
			used[i]=true;
			list.add(chars[i]);
			helper(res, list, chars, used);
			used[i]=false;
			list.remove(list.size()-1);		
		}
	}
	
	/**
	 * 暴力破解3个for循环，解略
	 */
	
	/**
	 * 交换
	 */
	
//	public void  Permutation(char[] chars,int pos,TreeSet<String> result){
//        if(pos==chars.length){
//            result.add(String.valueOf(chars));
//        }
//        
//        for(int i=pos;i<chars.length;i++){
//            char temp=chars[i];
//            chars[i]=chars[pos];
//            chars[pos]=temp;
//            
//            Permutation(chars,pos+1,result);
//            
//            temp=chars[i];
//            chars[i]=chars[pos];
//            chars[pos]=temp;
//        }
//    }
//    
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> result=new ArrayList<String>();
//        TreeSet<String> temp=new TreeSet<String>();//防止相同的两个元素“aa”
//        if(str==null || str.length()==0) return result;
//        char[] chars=str.toCharArray();
//       
//        Permutation(chars,0,temp);
//        result.addAll(temp);
//        return result;
//    }
    
	//测试
	public static void main(String[] args) {
		String str="abbc";
		List<String> res=permutation(str);
		for(String s:res) {
			System.out.println(s);
		}
	}
}
