public class Chapter3 {
	
	// Test Driver for Chapter 3 Problems
	public static void main(String[] args) {
//		stackTest();
//		arrayStackTest();
//		setOfStacksTest();
//		towersOfHanoiTest();
//		myQueueTest();
		shelterQueueTest();
	}
	
	private static void shelterQueueTest() {
		ShelterQueue queue = new ShelterQueue();		
		
		queue.enqueue("Dog1", PetType.DOG);
		queue.enqueue("Dog2", PetType.DOG);
		queue.enqueue("Cat1", PetType.CAT);
		queue.enqueue("Dog3", PetType.DOG);
		queue.enqueue("Cat2", PetType.CAT);
		queue.enqueue("Cat3", PetType.CAT);
		queue.enqueue("Dog4", PetType.DOG);
		queue.enqueue("Dog5", PetType.DOG);
		queue.enqueue("Dog6", PetType.DOG);
		queue.enqueue("Cat4", PetType.CAT);
		queue.enqueue("Dog7", PetType.DOG);
		queue.enqueue("Cat5", PetType.CAT);
		
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
//		System.out.println(queue.dequeueAny());
	}

	private static void myQueueTest(){
		Stack stack = new Stack();
		MyQueue queue = new MyQueue();
		
		stack.push(1);		
		System.out.println(stack.pop());
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		queue.enqueue(1);		
		System.out.println(queue.dequeue());
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
	private static void towersOfHanoiTest(){
		TowersOfHanoi game = new TowersOfHanoi(3);		
		game.solve(
			game.getTowerSize(), 
			game.getTower(1), 
			game.getTower(2),
			game.getTower(3)
		);		
		game.printGameState();
	}
	
	private static void setOfStacksTest(){
		SetOfStacks stack = new SetOfStacks(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		// Should print "null"
		System.out.println(stack.pop());
	}
	
	private static void arrayStackTest() {
		ArrayStack arr = new ArrayStack();
		arr.push(4, 1);
		arr.push(5, 1);
		arr.push(1, 1);
		arr.push(7, 2);
		arr.push(3, 2);
		arr.push(2, 2);
		arr.push(9, 3);
		arr.push(8, 3);
		arr.push(6, 3);
		
		System.out.println(arr.pop(1));
		System.out.println(arr.pop(1));
		System.out.println(arr.pop(1));
		System.out.println(arr.pop(1));
		System.out.println(arr.pop(2));
		System.out.println(arr.pop(2));
		System.out.println(arr.pop(2));
		System.out.println(arr.pop(3));
		System.out.println(arr.pop(3));
		System.out.println(arr.pop(3));
		
		// Inspects elements of internal array
		int[] hiddenArray = arr.getArrayStack();
		for (int elem : hiddenArray) System.out.print(elem + "   ");
		System.out.println();
	}

	private static void stackTest(){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}	
}
