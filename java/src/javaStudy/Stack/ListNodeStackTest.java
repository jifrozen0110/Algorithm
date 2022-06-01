package javaStudy.Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javaStudy.LinkedList.ListNode;

class ListNodeStackTest {

	ListNodeStack listNodeStack;
	int[] ARR_DATA={1,2,3,4};

	@BeforeEach
	void setUp() {
		listNodeStack=new ListNodeStack();
	}

	@Test
	void push() {
		listNodeStack.push(1);
		listNodeStack.push(2);
		listNodeStack.push(3);
		listNodeStack.push(4);

		ListNode listNode= listNodeStack.listNode;

		int i=0;
		while(listNode!=null){
			assertEquals(ARR_DATA[i++],listNode.data);
			listNode=listNode.next;
		}
	}

	@Test
	void pop() {
		listNodeStack.push(1);
		listNodeStack.push(2);
		listNodeStack.push(3);
		listNodeStack.push(4);

		assertEquals(4,listNodeStack.pop());
	}
}