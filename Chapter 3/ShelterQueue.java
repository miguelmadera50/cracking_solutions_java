public class ShelterQueue {
	
	PetNode first, last, dog, cat;
	
	//
	//
	// NONE OF THIS WORKS
	//
	//
	
	
	// Since Node (Linked List) is implemented for integers,
	// dog = 1, cat = 0 	
	void enqueue(String name, PetType type) {
		if (first == null){
			last = new PetNode(names
			if (first.type == PetType.DOG) dog = last;
			else cat = last;
		} else {
			last.next = new PetNode(name, type);
			last = last.next;
		}		
	}

	String dequeueAny() {	g into account node.deleteNode()
	String dequeueCat() {
		if (cat == null) return null;
		
		String adoptedCat = cat.name;
		PetNode copyCat = cat.next;
		
		//Node deletion
		if (first == cat) first = cat.next;
		else first = first.next; next cat
			if (copyCat.type == PetType.CAT){				
				cat = copyCat;
				return adoptedCat;
			}
			copyCat = copyCat.next;
		}
		
		// Last cat was adopted
		cat = null;
		return adoptedCat;	
	}
	
	//	Operation is O(n) taking into account node.deleteNode()
	String dequeueDog() {
		if (dog == null) return null;
		
		String adoptedDog = dog.name;
		PetNode copyDog = dog.next;
		
		//Node deletion
		if (first == dog) first = dog.next;
		else first = first.next;
		
		while (copyDog != null){
			
			// Reference is set to next dog
			if (copyDog.type == PetType.DOG){				
				dog = copyDog;
				return adoptedDog;
			}
			copyDog = copyDog.next;
		}
		
		// Last dog was adopted
		dog = null;
		return adoptedDog;	
	}
}
