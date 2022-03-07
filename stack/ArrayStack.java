package stackproblems;

import java.lang.reflect.Array;

public class ArrayStack<T> {
	
	T data[];
	int top = -1;
	
	private ArrayStack(int capacity, Class<T> clazz){
		data = (T[]) Array.newInstance(clazz, capacity);
	}
	
	public static final <T> ArrayStack<T> createStack(int capacity, Class<T> clazz) {
		return new ArrayStack<>(capacity, clazz);
		
	}
	
	
	public final ArrayStack<T> push(T element){
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		data[++top] = element;
		return this;
	}
	
	public final T pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		return data[top--];
	}
	
	public final T peek() {
			
			if(isEmpty()) {
				throw new RuntimeException("Stack is empty");
			}
			
			return data[top];
	}
	
	
	public final boolean isFull() {
		return top == data.length - 1;
		
	}
	
	
	public final boolean isEmpty() {
		return top == -1;
	}
	
	public final int maxSize() {
		return data.length;
		
	}
	
	public void print() {
		for (int i = 0; i <= top; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String args[]) {
		ArrayStack<Integer> stack = ArrayStack.createStack(5, Integer.class)
				.push(0).push(1).push(2).push(3).push(4);
		
		System.out.println("pushed 5 elements");
		System.out.println(stack.isFull());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty());
		
		
		
	}

}
