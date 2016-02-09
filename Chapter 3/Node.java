/**
 * Simple implementation of Linked List from
 * Cracking the coding Interview 4th Ed.
 */
class Node {
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	// Returns new head
	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d){
			return n.next;
		}
		
		while (n.next != null){
			if (n.next.data == d){
				
				// Node reference is overwritten
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
}