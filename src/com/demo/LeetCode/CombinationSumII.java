package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	/**
	 * ����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
	 * candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
	 * ˵����
	 * �������֣�����Ŀ������������������
	 * �⼯���ܰ����ظ�����ϡ� 
	 * ʾ�� 1:
	 * ����: candidates = [10,1,2,7,6,1,5], target = 8,
����⼯Ϊ:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
		if(candidates==null || candidates.length==0) return res;
		//�������ظ�Ԫ�أ���Ҫȥ��,������
		Arrays.sort(candidates);
		help(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
    }
	
	public static void help(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int start) {
		if(target<0) return;
		if(target==0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=start;i<candidates.length;i++) {
			if(i!=start && candidates[i]==candidates[i-1]) continue;
			list.add(candidates[i]);
			//ÿ���⼯ֻ����һ�Σ�������i+1
			help(res, list, candidates, target-candidates[i], i+1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates=new int[] {10,1,2,7,6,1,5};
		int target=8;
		List<List<Integer>> res=combinationSum2(candidates, target);
		System.out.println(res.toString());
	}
}

