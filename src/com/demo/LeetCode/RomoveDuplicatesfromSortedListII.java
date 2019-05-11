package com.demo.LeetCode;

public class RomoveDuplicatesfromSortedListII {
	/**
	 * Example 1:
	 * Input: 1->2->3->3->4->4->5
	 * Output: 1->2->5
	 */
	public ListNode deleteDuplicates(ListNode head) {
		/*
		 * ��������ͷ���ܻ����ظ����ɾ���Ļ�ͷָ���ı䣬������ȴ����Ҫ���������ͷָ�롣������Ҫ����һ���µĽڵ㣬Ȼ������ԭ����
		 * Ȼ����һ��ǰ��ָ���һ����ָ�룬ÿ��ǰ��ָ��ָ���½��Ľڵ㣬
		 * ��ָ�����һ��λ�ÿ�ʼ���±�����������ͬ����������£�ֱ��������ͬ��ʱ��
		 * ��ǰ��ָ���nextָ�������Ǹ���ͬ��Ԫ�ء������ָ������ĵ�һ��Ԫ�ؾͲ���ͬ��
		 * ���ǰ��ָ��������һλ��
		 */
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(0);
		ListNode pre=dummy;
		dummy.next=head;
		while(pre.next!=null) {
			ListNode cur=pre.next;
			while(cur.val==cur.next.val) {
				cur=cur.next;
			}
			if(cur!=pre.next) {
				pre.next=cur.next;
			}else {
				pre=pre.next;
			}
		}
		return dummy.next;
	}
}
