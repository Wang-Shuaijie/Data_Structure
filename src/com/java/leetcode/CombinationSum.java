package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
	 * candidates �е����ֿ����������ظ���ѡȡ��
	 * ˵�����������֣����� target���������������⼯���ܰ����ظ�����ϡ� 
	 * ʾ�� 1:
	 * ����: candidates = [2,3,6,7], target = 7,
	 * ����⼯Ϊ:
[
  [7],
  [2,2,3]
]

	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         *�����ֽ��Ҫ�󷵻����з���Ҫ������ʮ�а˾Ŷ���Ҫ���õ��ݹ飬
         *���ҽ����˼·����ͬС�����Ƶ���Ŀ�� Path Sum II��Subsets II��
         *Permutations��Permutations II��Combinations �ȵȣ�
         *�����ϸ�о���Щ��Ŀ���ֶ���һ����·��������Ҫ��дһ���ݹ麯����
         *���������¼�������������start��¼��ǰ�ĵݹ鵽���±꣬
         *listΪһ���⣬res���������Ѿ��õ��Ľ⣬ÿ�ε����µĵݹ麯��ʱ��
         *��ʱ��targetҪ��ȥ��ǰ����ĵ��������忴�������£�
         */
		List<List<Integer>> res=new ArrayList<>();
		if(candidates==null || candidates.length==0) return res;
		helper(res,new ArrayList<>(),candidates,target,0);
		return res;
    }

	public static void helper(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int start) {
		if(target<0) return;
		if(target==0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=start;i<candidates.length;i++) {
			list.add(candidates[i]);
			helper(res,list,candidates,target-candidates[i],i);
			list.remove(list.size()-1);
		}
	}
	
	
	public static void main(String[] args) {
		int[] candidates=new int[] {2,3,6,7};
		int target=7;
		List<List<Integer>> res=combinationSum(candidates, target);
		System.out.println(res.toString());
	}
}
