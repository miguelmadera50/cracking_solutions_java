/**
 * "Problem 2.2 - Implement an algorithm to find the kth to last 
 * element of a singly linked list"
 * 
 * @author miguel
 */
public class Prob22 {

	public static void main(String[] args) {
		Node headNode = new Node(1);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		headNode.appendToTail(4);
		headNode.appendToTail(5);
		headNode.appendToTail(4);
		headNode.appendToTail(2);
		printLinkedList(headNode); 
		System.out.println(getKthLastElement(headNode, 5));
	}
		
	// 2 loop implementation, may be improved
	private static int getKthLastElement(Node node, int k) {
		Node runnerNode = node;
		int length = 0;
		while (node != null){
			length++;
			node = node.next;
		}
		
		k = length - k;		
		for (int i = 0; i < k; i++){
			runnerNode = runnerNode.next;
		}
		return runnerNode.data;
	}

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}
