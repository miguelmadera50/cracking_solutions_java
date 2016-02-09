
public class Stack {
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
	
	int peek() {
		return top.data;
	}
}