package com.java.base.LinkedList;
/**
 * ����ѭ������
 * @author WangShuaiJie
 *
 */
public class LoopNode {
	//�ڵ�����
	int data;
	//��һ�ڵ�(���ֻ��һ���ڵ�ʱ��ָ���Լ�)
	LoopNode next=this;
	
	public LoopNode(int data) {
		this.data=data;
	}
	
	//ɾ����ǰ�ڵ����һ���ڵ�
	public void removeNode() {
		//ȡ�����¸��ڵ�
		LoopNode nextNode=this.next.next;
		//�����¸��ڵ�����Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=nextNode;
	}
	
	//����ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
	public void insertNode(LoopNode node) {
		//ȡ����ǰ�ڵ����һ���ڵ㣬��Ϊ���½ڵ�
		LoopNode nextNode = this.next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		node.next=nextNode;
	}
	
	public LoopNode next() {
		return this.next;
	}
	
	public int getData() {
		return this.data;
	}
}
