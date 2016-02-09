/**
 * Used for Problem 3.6, includes isEmpty() method
 * 
 * @author miguel
 */
public class StackSort {
	Node top;
	
	Object pop() {
		if (top != null){
			Node returnNode = top;
			top = top.next;
			return returnNode.data;
		}
		return null;
	}
	
	void push(int newNode) {
		Node node = new Node(newNode);
		node.next = top;
		top = node;
	}
	
	Object peek() {
		try {
			return top.data;
		} catch(NullPointerException npe) {
			return null;
		}
	}
	
	boolean isEmpty() {
		try {
			int value = top.data;
			return false;
		} catch(NullPointerException npe) {
			return true;
		}
	}
}