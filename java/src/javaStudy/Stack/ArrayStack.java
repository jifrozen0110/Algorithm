package javaStudy.Stack;

public class ArrayStack implements Stack{
	int[] stack;
	int top;

	public ArrayStack(int size){
		stack=new int[size];
		top=-1;
	}

	@Override
	public void push(int data) {
		stack[++top]=data;
	}

	@Override
	public int pop() {
		if(top==-1) return top;
		return stack[top--];
	}
}
