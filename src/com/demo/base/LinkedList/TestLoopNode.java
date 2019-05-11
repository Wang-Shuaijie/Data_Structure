package com.demo.base.LinkedList;

public class TestLoopNode {
	public static void main(String[] args) {
		LoopNode n1=new LoopNode(1);
		LoopNode n2=new LoopNode(2);
		LoopNode n3=new LoopNode(3);
		
		n1.insertNode(n2);
		n2.insertNode(n3);
		
		System.out.println(n3.next().getData());
	}
}
