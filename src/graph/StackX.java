package graph;

/**
 * 
 * @ClassName StackX
 * @Description 使用数组实现栈结构
 * @author qsdepth@foxmail.com
 * @date 2014-12-18
 */
public class StackX {
	
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public StackX(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	public void push(int value) {
		stackArray[++top] = value;
	}
	
	public int pop() {
		return stackArray[top--];
	}
	
	public int peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize-1);
	}
}
