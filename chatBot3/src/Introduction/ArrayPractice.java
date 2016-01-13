package Introduction;

public class ArrayPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] someDigitsOfPi = {3,1,4,1,5,9,2,6,5,3};
//		int[] someDigitsOfE = new int[4];
//		someDigitsOfE[0] = 2;
//		someDigitsOfE[1]= 7;
//		someDigitsOfE[2] = 1;
//		someDigitsOfE[3] = 8;
//		
//		System.out.println("The number of digits of pi we have is " + someDigitsOfPi.length);
//		System.out.println("The number of digits of e we have is " + someDigitsOfE.length);
//		printArrayContent(someDigitsOfPi);
		long startTime = System.currentTimeMillis();
//		int[] randomArray1 = generateARandomArray(10000);
//		printArrayContent(randomArray1);
		
//		String[] deck = makeCards();
//		shuffle(deck);
//		printArrayContent(deck);
		
//		int[] intArray = randomIntArray(50);
//		shuffle(intArray);
//		printArrayContent(intArray);
//		organize(intArray);
//		printArrayContent(intArray);
		
//		countPrimes(99999);
		long endTime = System.currentTimeMillis();
		System.out.println("The method took " + (endTime-startTime)+ "ms");
	}

	public static void countPrimes(int max) {
		boolean[] theNumbers = new boolean[max+1];
		//printArrayContent(theNumbers);
		for(int index = 2; index<theNumbers.length; index++){
			//starts by assuming every number is prime (except 0 and 1)
			theNumbers[index] = true; 
		}
		//for(boolean b: theNumbers){shortcut to do something with every boolean
		for(int index=0; index<theNumbers.length; index++){
			// if(theNumbers[index]) is the same as if(theNumbers[index]==true)
			if(theNumbers[index]){
				for(int multipleIndex = index+index; multipleIndex<theNumbers.length; multipleIndex+=index){
					theNumbers[multipleIndex]=false;
				}	
			}
		}
		String statement = "";
		int count =0;
		for(int index = 0; index< theNumbers.length; index++){
			if(theNumbers[index]){
				count++;
				statement += " "+index+",";
			}
		}
		statement += "\nThere are " + count + " primes between 1 and "+max+".";
		System.out.println(statement);
	}

	public static int[] organize(int[] array) {
		for(int i = 0; i<array.length; i++){
			for(int index = 0; index<array.length; index++){
				int test = index+1;
				if(test>=array.length){test =array.length-1;}
				if(array[index]>array[test]){
					int tmp = array[index];
					array[index] = array[index+1];
					array[index+1] = tmp;
				}
			}
		}
		return array;
	}

	public static int[] randomIntArray(int length) {
		int[] tmpArray = new int[length];
		for(int index=0; index<length; index++){
			int ranNum = (int)(Math.random()*length);
			tmpArray[index] = ranNum;
		}
		return tmpArray;
	}
	
	public static int[] shuffle(int[] deck) {
		for(int index = 0; index<deck.length; index++){
			int swapCard = (int)(Math.random()*deck.length);
			int holder = deck[index];
			deck[index] = deck[swapCard];
			deck[swapCard] = holder;
		}
		return deck;
	}

	public static String[] shuffle(String[] deck) {
		for(int index = 0; index<deck.length; index++){
			int swapCard = (int)(Math.random()*deck.length);
			swap(deck,index,swapCard);
		}
		return deck;
	}

	public static void swap(String[] deck, int a, int b) {
		String placeholder = deck[a];
		deck[a] = deck[b];
		deck[b] = placeholder;
		
	}

	public static String[] makeCards() {
		String[] suits={"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] cards={"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Jack", "Queen", "King"};
		int cardNum = 0;
		String[] allCards = new String[52];
		for(int index = 0; index<suits.length; index++){
			for(int j = 0; j<cards.length; j++){//nested for loop
				allCards[cardNum] = cards[j] + " of " + suits[index];
				cardNum++;
			}
		}
		
		return allCards;
		
	}
		

	public static int[] generateARandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		for(int index = 0; index<arrayLength; index++){
			//array[index] = index+1;
			array[index] = arrayLength-index;
		}
		return array;
	}

	public static void printArrayContent(int[] array) {
		String arrayContent = "[";
		for(int index = 0; index < array.length; index++){
			if(index<array.length-1)arrayContent = arrayContent + array[index] + ", "; 
			else arrayContent = arrayContent + array[index];
				
		}
		
		arrayContent = arrayContent + "]";
		System.out.println(arrayContent);
		
	}

	public static void printArrayContent(String[] array) {
		String arrayContent = "[";
		for(int index = 0; index < array.length; index++){
			if(index<array.length-1)arrayContent = arrayContent + array[index] + ", "; 
			else arrayContent = arrayContent + array[index];
				
		}
		
		arrayContent = arrayContent + "]";
		System.out.println(arrayContent);
		
	}
	
	public static void printArrayContent(boolean[] array) {
		String arrayContent = "[";
		for(int index = 0; index < array.length; index++){
			if(index<array.length-1)arrayContent = arrayContent + array[index] + ", "; 
			else arrayContent = arrayContent + array[index];
				
		}
		
		arrayContent = arrayContent + "]";
		System.out.println(arrayContent);
		
	}
	
}
