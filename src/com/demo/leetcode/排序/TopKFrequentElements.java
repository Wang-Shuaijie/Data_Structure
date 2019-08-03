package com.demo.leetcode.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 出现频率最多的 k 个元素
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
		//设置若干个桶，每个桶存储出现频率相同的数,桶的下标表示数出现的频率
		List<Integer>[] buckets=new ArrayList[nums.length+1];
		for(int key:map.keySet()) {
			int frequency=map.get(key);
			if(buckets[frequency]==null) {
				buckets[frequency]=new ArrayList<>();
			}
			buckets[frequency].add(key);
		}
		
		//从后向前遍历桶
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
