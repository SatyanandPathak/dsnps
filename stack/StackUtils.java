package stackproblems;

public class StackUtils {
	
	public static void main(String args[]) {
		ArrayStack<Integer> stack = ArrayStack.createStack(5, Integer.class)
				.push(5).push(2).push(7).push(1).push(-1);
		System.out.println(stack);
		stack = sort(stack);
		System.out.println(stack);
		stack.print();
		
	}
	
	public static ArrayStack<Integer> sort(ArrayStack<Integer> stack) {
		
		if (stack == null || stack.isEmpty()) 
			return stack;
		
		
		ArrayStack<Integer> tempStack = ArrayStack.createStack(stack.maxSize(), Integer.class);
		
		while(!stack.isEmpty()) { // n
			Integer temp = stack.pop();
			
			if (tempStack.isEmpty()) {
				tempStack.push(temp);
				continue;
			} 
						
			while(tempStack.peek() >= temp) { // n
				stack.push(tempStack.pop());	
				
			}
			tempStack.push(temp);
			
			while (!stack.isEmpty() && (stack.peek() >= tempStack.peek())) {
				tempStack.push(stack.pop());
			}
			
		}
		stack = tempStack;
		System.out.println(stack);
		System.out.println(tempStack);
		return tempStack;
		
	}

}
