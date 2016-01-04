/**
 * "Problem 2.6 - Given a circular linked list, implement an algorithm which 
 * returns the node at the beginning of the loop.
 * 		DEFINITION
 * 		Circular linked list: A (corrupt) linked list in which a node's next 
 * 		pointer points to an earlier node, so as to make a loop in the linked list.
 * 
 * 		EXAMPLE
 * 		Input: A ->B->C->D->E- > C [the same C as earlier]
 * 		Output: C
 * 
 * @author miguel
 */
public class Prob26 {

	public static void main(String[] args) {
		Node headNode = new Node(1);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		headNode.appendToTail(7);
		headNode.appendToTail(5);
		headNode.appendToTail(4);
		headNode.appendToTail(2);
		printLinkedList(headNode); 
		
		// Creating a corrupt (cyclical) linked list
		Node runnerNode = headNode;
		Node cycleNode = null;
		while (runnerNode.next != null){
			if (runnerNode.data == 7)
				cycleNode = runnerNode;
			runnerNode = runnerNode.next;
		}
		runnerNode.next = cycleNode;
		
		System.out.println(findCyclicNode(headNode));
		
		// This will not end for a cyclical list.
		printLinkedList(headNode);
	}
	
	private static int findCyclicNode(Node node) {
		
		// First step is already taken
		int answer = -1;
		int maxCycleAmount = 1;
		Node slowRunner = node.next;
		Node fastRunner = node.next.next;
		
		// Slow / Fast runner method
		while (slowRunner != fastRunner){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			maxCycleAmount++;
		}
		System.out.println("max: " + maxCycleAmount);
		
		Node baseNode = node;
		while (baseNode != null){
			Node runnerNode = baseNode.next;
			
			for (int i = 0; i <= maxCycleAmount; i++){
				if (baseNode == runnerNode){
					answer = baseNode.data;
				}
				runnerNode = runnerNode.next;
			}
			baseNode = baseNode.next;
		}
		return answer;		
	}

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}
