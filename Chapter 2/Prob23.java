/**
 * Problem 2.3 - Implement an algorithm to delete a node in the 
 * middle of a singly linked list, given only access to that node. 
 * 
 * EXAMPLE:
 * 		Input: the node c from the linked list a->b->c->d->e
 * 		Result: nothing is returned, but the new linked list 
 * 				looks like a- >b- >d->e
 * 
 * @author miguel
 */
public class Prob23 {

	public static void main(String[] args) {
		Node headNode = new Node(1);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		headNode.appendToTail(7);
		headNode.appendToTail(5);
		headNode.appendToTail(4);
		headNode.appendToTail(2);
		printLinkedList(headNode); 
		
		// Gets middle node for testing method		
		Node runnerNode = headNode;
		while (runnerNode != null){
			if (runnerNode.data == 7)
				break;
			runnerNode = runnerNode.next;
		}
		
		deleteMiddleNode(runnerNode);
		printLinkedList(headNode);
	}

	private static void deleteMiddleNode(Node node) {
		int nextNodeData = node.next.data;
		node.next = node.next.next;
		node.data = nextNodeData;
		// Deallocation would be performed here in a C++ implementation
	}

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}