/**
 * "Problem 3.6 - Write a program to sort a stack in ascending order 
 * (with biggest items on top). You may use at most one additional 
 * stack to hold items, but you may not copy the elements into any 
 * other data structure (such as an array). The stack supports the 
 * following operations: push, pop, peek, and isEmpty."
 * 
 * @author miguel
 */
public class Prob36 {

	public static void main(String[] args) {
		StackSort stack = new StackSort();
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(9);
		stack.push(2);
		stack.push(7);
		stack.push(1);
		
		sortStack(stack, 7);
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}			
	}

	private static void sortStack(StackSort stack, int stackSize) {
		
		Stack holdingStack = new Stack();
		
		while (stackSize > 1) {
			int currentMin = (int) stack.pop();
			
			// Obtains minimum value in currentMin buffer
			for (int i = 1; i < stackSize; i++) {
				if ((int) stack.peek() < currentMin) {
					holdingStack.push(currentMin);
					currentMin = (int) stack.pop();
				}
				else {
					holdingStack.push((int) stack.pop());
				}
			}
			
			// Sets that value at the bottom of stack and places all other
			// values above it.
			stack.push(currentMin);
			for (int i = 1; i < stackSize; i++) {
				stack.push((int) holdingStack.pop());
			}
			stackSize--;
		}
	}
}
