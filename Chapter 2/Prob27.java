/**
 * "Problem 2.7 - Implement a function to check if a linked list 
 * is a palindrome"
 * 
 * @author miguel
 */
public class Prob27 {
	
	public static void main(String[] args) {
		
		// Test cases
		Node firstHead = new Node(1);
		firstHead.appendToTail(2);
		firstHead.appendToTail(3);
		firstHead.appendToTail(3);
		firstHead.appendToTail(4);
		firstHead.appendToTail(1);	
		
		Node secondHead = new Node(1);
		secondHead.appendToTail(2);
		secondHead.appendToTail(3);
		secondHead.appendToTail(4);
		secondHead.appendToTail(3);
		secondHead.appendToTail(2);
		secondHead.appendToTail(1);
		
		Node thirdHead = new Node(1);
		thirdHead.appendToTail(2);
		thirdHead.appendToTail(3);
		thirdHead.appendToTail(3);
		thirdHead.appendToTail(2);
		thirdHead.appendToTail(1);
		
		System.out.println(isPalindrome(firstHead));
		System.out.println(isPalindrome(secondHead));
		System.out.println(isPalindrome(thirdHead));
	}

	private static boolean isPalindrome(Node head) {
		Node slowRunner = head;
		Node fastRunner = head;
		String str = "" + head.data;
		int count = 0;
		int i = 0;
		
		// Sets slowRunner to the middle of the linked list				
		while(head != null){				
			try {
				if (fastRunner.next.next != null){					
					slowRunner = slowRunner.next;
					fastRunner = fastRunner.next.next;
					str += slowRunner.data;
				}
			} catch(NullPointerException npe){}
			count++;
			head = head.next;
		}
		
		if (count % 2 == 0){
			slowRunner = slowRunner.next;
		}
		
		// Compares reversed String to next values inside of LinkedList
		str = new StringBuilder(str).reverse().toString();
		while (slowRunner != null){
			if (slowRunner.data != Integer.parseInt(str.charAt(i++) + "")) {
				return false;
			}
			slowRunner = slowRunner.next;
		}
		return true;		
	}
}