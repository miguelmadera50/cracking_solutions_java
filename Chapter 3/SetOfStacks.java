/**
 * 
 * "Problem 3.3 -  Imagine a (literal) stack of plates. If the stack gets 
 * too high, it might topple. Therefore, in real life, we would likely 
 * start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOf Stacks that mimics this. SetOfStacks 
 * should be composed of several stacks and should create a new stack once 
 * the previous one exceeds capacity. SetOf Stacks. push() and SetOfStacks.
 * pop() should behave identically to a single stack (that is, pop() should
 * return the same values as it would if there were just a single stack). 
 *  
 *  FOLLOW UP 
 *  	Implement a function popAt(int index) which performs a pop 
 *  	operation on a specific sub-stack."
 * 
 * @author miguel
 */
public class SetOfStacks {
	int threshold;
	Stack[] baseArray;
	int stackCount;
	int stackPosition;
	
	public SetOfStacks(int threshold) { 
		this.threshold = threshold;
		stackPosition = 0;
		stackCount = 0;
		
		// Initial BaseArray size doesn't matter
		baseArray = new Stack[2];
		baseArray[0] = new Stack();
	}
	
	void push(int newNode){
		
		// Case 1 - new stack has to be made
		if (stackCount == threshold){
			try {
				// try-catch forbids incrementing stackPosition here
				baseArray[stackPosition + 1] = new Stack();
				baseArray[stackPosition + 1].push(newNode);
				stackPosition++;
				stackCount = 1;
				
			} catch(NullPointerException npe) {
				growArray();
				push(newNode);
			} catch(ArrayIndexOutOfBoundsException aiob) {
				growArray();
				push(newNode);
			}
		}
		
		// Case 2 - only 1 stack is affected
		else {
			baseArray[stackPosition].push(newNode);
			stackCount++;
		}
	}
	
	Object pop(){
		
		// Case 1 - all stacks are empty
		if (stackCount == 0 && stackPosition == 0) return null;
		
		// Case 2 - last element of stack is popped
		if (stackCount == 0){
			stackCount = threshold - 1;
			return baseArray[--stackPosition].pop();
		}
		
		// Case 3 - only 1 stack is affected
		else {
			stackCount--;
			return baseArray[stackPosition].pop();
		}		
	}
	
	// TODO: Followup problem	
	Object popAt(){
		return null;
	}
	
	/**
	 * Expands Stack Array by a factor of 2 when array is maxed out.
	 * Operation is O(n) but only occurs in O(log n) intervals.
	 */
	private void growArray(){
		Stack[] newArray = new Stack[baseArray.length * 2];
		for (int i = 0; i < baseArray.length; i++){
			newArray[i] = baseArray[i];
		}
		baseArray = newArray;
	}
}
