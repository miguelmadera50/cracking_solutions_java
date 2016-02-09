/**
 * Implementation of dynamic array contaning 3 stacks 
 * 
 * "Problem 3.1 - Describe how you could use a single 
 * array to implement three stacks"
 * 
 * @author miguel
 */
public class ArrayStack {
	int[] baseArray;
	int topStackOne;
	int topStackTwo;
	int topStackThree;
	
	public ArrayStack() {
		baseArray = new int[3];
		
		// Initial values
		topStackOne = 0;
		topStackTwo = 1;
		topStackThree = 2;
	}
	
	void push(int data, int stack){
		try {
			if (stack == 1){
				baseArray[topStackOne + 3] = data;
				topStackOne += 3;
			}
			else if (stack == 2){
				baseArray[topStackTwo + 3] = data;
				topStackTwo += 3;
			}
			else if(stack == 3){
				baseArray[topStackThree + 3] = data;
				topStackThree += 3;
			}
		}
		catch(Exception e){
			growArray();
			push(data, stack);
		}
	}
	
	Object pop(int stack){
			if (stack == 1){
				if (topStackOne == 0){
					return null;
				}
				else
				topStackOne -= 3;
				return baseArray[topStackOne + 3];
			}
			else if (stack == 2){
				if (topStackTwo == 1){
					return null;
				}
				else
				topStackTwo -= 3;
				return baseArray[topStackTwo + 3];
			}
			else if(stack == 3){
				if (topStackThree == 0){
					return null;
				}
				else
				topStackThree -= 3;
				return baseArray[topStackThree + 3];
			}
			return null;
	}
	
	Object  peek(int stack){
		if (stack == 1){
			return baseArray[topStackOne];
		}
		else if (stack == 2){
			return baseArray[topStackTwo];
		}
		else if (stack == 3){
			return baseArray[topStackThree];
		}
		return null;
	}
	
	/**
	 * Expands Stack Array by a factor of 2 when array is maxed out.
	 */
	private void growArray(){
		int[] newArray = new int[baseArray.length * 2];
		for (int i = 0; i < baseArray.length; i++){
			newArray[i] = baseArray[i];
		}
		baseArray = newArray;
	}
	
	// Allows a peek at the entire internal array
	int[] getArrayStack(){
		return baseArray;
	}
}