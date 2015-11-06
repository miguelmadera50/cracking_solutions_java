/**
 * "Problem 2.1 - Write code to remove duplicates from an unsorted 
 * linked list.How would you solve this problem if a temporary 
 * buffer is not allowed?"
 * 
 * @author miguel
 */
public class Prob21 {
	
	public static void main(String[] args) {
		Node headNode = new Node(1);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		headNode.appendToTail(4);
		headNode.appendToTail(5);
		headNode.appendToTail(4);
		headNode.appendToTail(2);
		
		printLinkedList(headNode); 
		removeDuplicates(headNode);
		printLinkedList(headNode); 
	}	
	
	// Implemented without a temporary buffer 
	private static void removeDuplicates(Node node) {
		Node head = node;
		while (node != null){
			Node runnerNode = node.next;
			while (runnerNode != null){
				if (node.data == runnerNode.data){
					head.deleteNode(head, node.data);
				}
				runnerNode = runnerNode.next;
			}
			node = node.next;
		}
	}
	
	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}