/**
 * Problem 2.4 - Write code to partition a linked list around a value x, such 
 * that all nodes less than x come before all nodes greater than or equal to x.
 * 
 * NOTE: this is not a sorting algorithm, Node order is unaffected.
 * 
 * @author miguel
 */
public class Prob24 {
	
	public static void main(String[] args) {
		Node headNode = new Node(1);
		headNode.appendToTail(7);
		headNode.appendToTail(6);
		headNode.appendToTail(4);
		headNode.appendToTail(5);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		
		printLinkedList(headNode); 
		printLinkedList(partitionLinkedList(headNode, 5));
	}
	
	private static Node partitionLinkedList(Node node, int x){
		Node smallList = null;
		Node largeList = null;
		
		// Implementation uses 2 temporary Lists as buffers
		while (node != null){
			if (node.data < x){
				if (smallList == null) smallList = new Node(node.data);
				else smallList.appendToTail(node.data);
			}
			else {
				if (largeList == null) largeList = new Node(node.data);
				else largeList.appendToTail(node.data);
			}				
			node = node.next;
		}
		Node newHead = smallList;
		
		// Sets smallList equal to last node
		while (smallList.next != null) smallList = smallList.next;
		smallList.next = largeList;
		return newHead;
	}
	
	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}