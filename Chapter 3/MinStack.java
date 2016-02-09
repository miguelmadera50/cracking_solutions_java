/**
 * 
 * "Problem 3.2 -  How would you design a stack which, in addition to push 
 * and pop, also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time."
 * 
 * @author miguel
 */
public class MinStack {
	Node top;
	Node minStack;
	int minimum;
	
	public MinStack(){
		minimum = Integer.MAX_VALUE;
	}
	
	Object pop() {
		if (top != null){
			
			// Linked List is used to maintain current minimum
			// Stack may also be used instead.
			if (top.data <= minimum){
				minStack = minStack.next;
				minimum = minStack.data;
			}
			Node returnNode = top;
			top = top.next;
			return returnNode.data;
		}
		return null;
	}	

	void push(int newNode) {
		// Minimum is updated
		if (newNode <= minimum){
			minimum = newNode;
			Node minNode = new Node(newNode);
			minNode.next = minStack;
			minStack = minNode; 
		}
		Node node = new Node(newNode);
		node.next = top;
		top = node;
	}
	
	int peek() {
		return top.data;
	}
	
	int min(){
		return minimum;
	}
}