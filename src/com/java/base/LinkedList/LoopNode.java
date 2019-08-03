package com.java.base.LinkedList;
/**
 * 单向循环链表
 * @author WangShuaiJie
 *
 */
public class LoopNode {
	//节点内容
	int data;
	//下一节点(如果只有一个节点时，指向自己)
	LoopNode next=this;
	
	public LoopNode(int data) {
		this.data=data;
	}
	
	//删除当前节点的下一个节点
	public void removeNode() {
		//取出下下个节点
		LoopNode nextNode=this.next.next;
		//把下下个节点设置为当前节点的下一个节点
		this.next=nextNode;
	}
	
	//插入节点作为当前节点的下一个节点
	public void insertNode(LoopNode node) {
		//取出当前节点的下一个节点，作为下下节点
		LoopNode nextNode = this.next;
		//把新节点作为当前节点的下一个节点
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
