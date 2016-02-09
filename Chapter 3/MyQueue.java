/**
 * "Problem 2.5 -  Implement a MyQueue class which implements a queue 
 * using two stacks"
 * 
 * @author miguel
 */
public class MyQueue {
	Stack storageStack;
	Stack dequeueStack;
	
	// No need to reset second Stack every time
	boolean storageStackChanged;
	
	public MyQueue() {
		storageStack = new Stack();
		storageStackChanged = false;
	}
	
	// Operation is O(1)
	public void enqueue(int node) {
		storageStackChanged = true;
		storageStack.push(node);
	}
	
	// Operation is O(n)
	public Object dequeue() {
		
		// If values have changed
		if (storageStackChanged) {
			
			dequeueStack = new Stack();
			Object popValue = storageStack.pop();
			
			while (popValue != null){
				
				// Second stack is used here to reverse order
				dequeueStack.push((int) popValue);
				popValue = storageStack.pop();
			}
		}
		storageStackChanged = false;
		return dequeueStack.pop();
	}
}
