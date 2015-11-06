public class Prob25 {
	
	public static void main(String[] args) {
		Node firstHead = new Node(1);
		firstHead.appendToTail(2);
		firstHead.appendToTail(3);
		firstHead.appendToTail(4);
		
		Node secondHead = new Node(7);
		secondHead.appendToTail(8);
		secondHead.appendToTail(9);
		//printLinkedList(reverseListSum(firstHead, secondHead));
		printLinkedList(normalListSum(firstHead, secondHead));
		
	}
	
	//Input: (1 -> 2 -> 3 -> 4) + (7 -> 8 -> 9).That is, 4321 + 987.
	//Output: 8 -> 0 -> 3 -> 5.That is, 5308.
	private static Node reverseListSum(Node firstHead, Node secondHead) {
		Node sumList = null;
		int carryDigit = 0;
		while (!(firstHead == null && secondHead == null)){			
			
			// If one list has run out of digits, 0 is taken instead of null
			carryDigit += (firstHead == null? 0 : firstHead.data) 
					+ (secondHead == null? 0 : secondHead.data);
			
			if (sumList == null) sumList = new Node(carryDigit % 10);
			else sumList.appendToTail(carryDigit % 10);
			
			carryDigit = (carryDigit >= 10? carryDigit / 10 : 0);
			firstHead = firstHead == null ? null : firstHead.next;
			secondHead = secondHead == null ? null : secondHead.next;
			System.out.println(firstHead + "   " + secondHead + "   " + (firstHead != null && secondHead != null));
		}
		// In case of remaining digits
		if (carryDigit != 0) sumList.appendToTail(carryDigit);
		return sumList;
	}
	
	// answer = 2 0 2 3
	private static Node normalListSum(Node firstHead, Node secondHead) {
		// Due to the time complexity of calculating string lengths,
		// stringBuilder conversion to int appears to be faster 
		// (still in O(n) time)
		StringBuilder firstBuilder = new StringBuilder();
		StringBuilder secondBuilder = new StringBuilder();
		
		while (firstHead != null) {
			firstBuilder.append(firstHead.data);
			firstHead = firstHead.next;
		}
		while (secondHead != null) {
			secondBuilder.append(secondHead.data);
			secondHead = secondHead.next;
		}
		
		char[] sum = (
				"" + (Integer.parseInt(firstBuilder.toString())
				+ Integer.parseInt(secondBuilder.toString()))
				).toCharArray();
		Node answerHead = null;
		
		for (char ch: sum){
			if (answerHead == null) answerHead = 
					new Node(Character.getNumericValue(ch));
			else answerHead.appendToTail(Character.getNumericValue(ch));
		}
			
		return answerHead;
	}

	private static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}
}