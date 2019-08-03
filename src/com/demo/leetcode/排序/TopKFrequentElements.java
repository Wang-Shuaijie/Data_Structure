package com.demo.leetcode.����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * ����Ƶ������ k ��Ԫ��
 * @author WangShuaiJie
 *
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k){
		List<Integer> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		Map<Integer, Integer> map=new HashMap<>();
		for(int num:nums) {
			if(map.containsKey(nums)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
		//�������ɸ�Ͱ��ÿ��Ͱ�洢����Ƶ����ͬ����,Ͱ���±��ʾ�����ֵ�Ƶ��
		List<Integer>[] buckets=new ArrayList[nums.length+1];
		for(int key:map.keySet()) {
			int frequency=map.get(key);
			if(buckets[frequency]==null) {
				buckets[frequency]=new ArrayList<>();
			}
			buckets[frequency].add(key);
		}
		
		//�Ӻ���ǰ����Ͱ
		for(int i=buckets.length-1;i>=0 && res.size()<k;i--) {
			if(buckets[i]==null) continue;
			if (buckets[i].size() <= (k - res.size())) {
	            res.addAll(buckets[i]);
	        } else {
	            res.addAll(buckets[i].subList(0, k - res.size()));
	        }
		}
		return res;
	}
	
}
