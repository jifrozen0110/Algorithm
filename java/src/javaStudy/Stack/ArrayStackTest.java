package javaStudy.Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayStackTest {
	private ArrayStack arrayStack;
	private int[] ARR_DATA={1,2,3,4,5};

	@BeforeEach
	void setUp(){
		arrayStack=new ArrayStack(5);

	}
	@Test
	void push() {
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(5);

		for(int i=0;i<5;i++){
			assertEquals(ARR_DATA[i],arrayStack.stack[i]);
		}
	}

	@Test
	void pop() {
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(5);

		assertEquals(5,arrayStack.pop());

	}
}