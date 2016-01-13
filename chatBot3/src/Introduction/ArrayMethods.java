package Introduction;

public class ArrayMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] someDigitsOfPi = {3,1,4,1,5,9,2,6,5,3};
		int[] testArray = {3,7,3};
		int[] testArray2 = {1,2,2,9,3,1,2,1,3,3,7,3,3,3,3,3,3,3};
//		System.out.println(isSorted(someDigitsOfPi));
//		
//		 double[] testDouble = {3.2,3.2,3.1,3.4,3.5,3.2};
//		 System.out.println(getStats(testDouble)[0]);
//		 System.out.println(getStats(testDouble)[1]);
//		 System.out.println(getStats(testDouble)[2]);
//		 System.out.println(getStats(testDouble)[3]);
//		 System.out.println(getStats(testDouble)[4]);
//		 System.out.println(getStats(testDouble)[5]);
		 
		int testInt = longestSharedSequence(testArray,testArray2);
//		ArrayPractice.printArrayContent(testInt);
		System.out.println(testInt);
		
//		int[] testInt = cycleThrough(testArray, -1);
//		ArrayPractice.printArrayContent(testInt);
	}

	public static int searchUnsorted(int[] arrayToSearch, int key){
		/**
		 * this method take an unsorted int array (arrayToSearch) and returns an 
		 * int corresponding to the index of a key, if it is in the array
		 * if the key is not in the array, this method returns -1
		 * */
		//boolean found = false;
		int tmp = -1;
		for(int i=0; i<arrayToSearch.length; i++){
			if(arrayToSearch[i] == key){
				//found = true;
				tmp = i;
			}
		}
//		if(found){
//			return tmp;
//		}else{
//			return -1;
//		}
		return tmp;
	}

	public static int searchSorted(int[] sortedArrayToSearch, int key){
		/**
		 * this method is exactly like the one above, except the parameter sortedArrayToSearch will
		 * always be sorted in DESCENDING order. Again return the index of the key or return -1
		 * if the key is not in the array
		 * 
		 * Note: You should attempt to write a method that is more efficient that searchUnsroted
		 * */
		int tmp = -1;
		for(int i=0; i<sortedArrayToSearch.length; i++){
			if(sortedArrayToSearch[i] == key){
				tmp = i;
				break;
			}
		}
		return tmp;
	}
	
	public static boolean isSorted(int[] array){
        /**
         * This method takes an in array as a parameter and returns 'true' if the array is already sorted in 
         * DESCENDING order
         * */
		boolean descending = true;
		for(int i=0; i<array.length; i++){
			for(int j=1; j<array.length; j++){
				if(i+j<array.length){
					if(array[i]<array[i+j]){
						descending = false;
					}
				}
			}
		}
        return descending;
    }
	
	public static double[] getStats(double[] array){
        /** 
         * This method return a double[] contain a WHOLE BUNCH of stats
         * The double array must keep the following stats about the array parameter:
         * index 0 = the mean
         * index 1 = the max
         * index 2 = the min
         * index 3 = the median
         * index 4 = the number of values greater than or equal to the mean
         * index 5 = the number of values below the mean
         * */
         double[] stats = new double[6];
         double total = 0;
         for(int i=0; i<array.length; i++){
        	 total += array[i];
         }
         stats[0] = total/array.length;
         double[] holder = array;
         double[] copy = holder; 
         for(int i = 0; i<array.length; i++){
 			for(int index = 0; index<array.length; index++){
 				int test = index+1;
 				if(test>=array.length){test =array.length-1;}
 				if(copy[index]>copy[test]){
 					double tmp = copy[index];
 					copy[index] = copy[test];
 					copy[test] = tmp;
 				}
 			}
 		}
         stats[1] = array[array.length-1];
         stats[2] = array[0];
         
         if(array.length%2 == 0){
        	 int tmp = array.length/2;
        	 double tmp2 = copy[tmp] + copy[tmp-1];
        	 stats[3] = (tmp2)/2;
         }else{
        	 stats[3] = copy[array.length/2];
         }
         
         double higher = 0;
         double lower = 0;
         for(int i=0; i<array.length; i++){
        	 if(array[i]>=stats[0])higher++;
        	 if(array[i]<stats[0])lower++;
         }
         
         stats[4] = higher;
         stats[5] = lower;
         return stats;
    }
	
	 public static void reverseOrder(int[] array){
	        /**
	         * this method reverses the order of the array passed to it.
	         * Not that this method does not have a return type. You do not need to copy the array first
	         * Furthermore, note that the array is not necessarily in any *particular* order. It may be 
	         * in a random order, though you still need to reverse whatever order it is in
	         * 
	         * */
		 int endNum = array.length-1;
		 for(int i=0; i<array.length/2; i++){
			 int tmp = array[i];
			 array[i]=array[endNum-i];
			 array[endNum-i] = tmp;
		 }
	}
	
	 public static int countDifferences(int[] array1, int[] array2){
	        /**Here, you will write an method that returns the number of values in two arrays 
	         * that are NOT the same (either in value OR location).
	         * Examples:
	         * countDifferences({1,2,3},{1,2,3}) returns 0, since these arrays are exactly the same
	         * countDifferences({3,2,3,4},{3,2,5,4}) returns 1, since '3','2', and '4' are same value, same location, but the 3 and 5 are different
	         * countDifferences({4,4,4,4},{1,2,3,4}) returns 3, since '4' is only at the same index ONE time and three others are not
	         * countDifferences({1,2,3},{1,3,2}) returns 2, since '2' and '3' are both present, but different locations
	         * 
	         * */
		 int different = 0;
		 for(int i=0; i<array1.length; i++){
			 if(array1[i] != array2[i])different++;
		 }
	         return different;
	 }
	 
	 public static int longestConsecutiveSequence(int[] array1){
	        /**This method counts the longest consecutive sequence in an array.
	         * It does not matter where the sequence begins
	         * If there are no consecutive numbers, the method should return '1'
	         * 
	         * Examples:
	         * longestSequence({1,2,3,4,5,8,9}) returns '5', since the sequence '1,2,3,4,5' is 5 integers long 
	         * longestSequence({0,9,10,11,4,3,8,9}) returns '3', since '9,10,11' is 3 integers long
	         * longestSequence({0,9,8,11,4,3,7,9}) returns '1', since there are no consecutive integers
	         * */
		 	int length = array1.length;
	        int chain = 1;
	        int x = 0;
	        int y = 0;
	        int[] consecs = new int[length];
	        boolean consecutive = false;
	        for(int i=0; i<length; i++){
	        	if(i+1<length){
	        		if(array1[i]+1 == array1[i+1]){
	        			y=0;
	        			consecutive = true;
	        			y=i+1;
	        			consecs[x] +=1;
	        		}
	        	}
	        	while(consecutive){
	        		//for(int j=0; j<length-i; j++){
	        		if(y+1<length){
	        			if(array1[y]+1 == array1[y+1]){
	    	        		consecs[x] +=1;
	    	        		if(y+1<length){
	    	        			y++;
	    	        		}
	        			}else{
	        				consecutive = false;
	        				consecs[x] +=1;
	        				i=y-1;
	        				x++;
	        			}
	        		}else{
	        			i=length;
	        			consecutive =false;
	        		}
	        	}
	        	
	        	
	        }
	        for(int h=0; h<length;h++){
	        	if(consecs[h] >chain){
	        		chain = consecs[h];
	        	}
	        }
	        return chain;
	 }
	 
	 public static int longestSharedSequence(int[] array1, int[] array2){
		 /**This method counts the longest unbroken, shared sequence in TWO arrays.
		  * The sequence does NOT have to be a consecutive sequence
		  * It does not matter where the sequence begins, the arrays might not be the same length
		  * 
		  * Examples:
		  * longestSequence({9,6,3,4,3,8,9}, {9,6,3,4,3,6,7}) returns '5', since the sequence '9,6,3,4,3' is in 
		  * both arrays and is 5 integers long 
		  * longestSequence({0,9,6,3,4,3,8,9}, {1,2,9,6,3,4,3,6,7}) returns '5', 
		  *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter
		  *           that the sequence begins at different indices 
		  * longestSequence({9,6,1,4,3,6,7,9}, {9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in 
		  * both arrays and is 3 integers long
		  * */

		 int length1 = array1.length;
		 int length2 = array2.length;
		 int[] seq = new int[length1*length2];
		 boolean order = false;
		 int x = 0;
	     int y = 0;
	     int z = 0;
	     int chain = 0;
	     
		 for(int i=0; i<length1; i++){
			 for(int j=0; j<length2; j++){
				 if(array1[i] == array2[j]){
					seq[z] +=1;
					order = true;
					if(i+1<length1){
						x=i+1;
					}else{
						order = false;
						z++;
					}
					if(j+1<length2){
						y=j+1;
					}else{
						order = false;
						z++;
					}
					while(order){
						if(array1[x] == array2[y]){
							seq[z] +=1;
							if(x+1<length1){
								x++;
							}else{
								order = false;
								z++;
							}
							if(y+1<length2){
								y++;
							}else{
								order = false;
								z++;
							}
						}
						else{
							order = false;
							z++;
						}
					}
					
				 }
			 }
		 }
		 for(int h=0; h<length1+length2;h++){
			//System.out.println(seq[h]);
			 if(seq[h] >chain){
				 chain = seq[h];
			 }
		 }
		 return chain;
	 }
	 
	 public static int[] generateDistinctItemsList(int n){
	        /**
	         * This method needs to generate an int[] of length n that contains distinct, random integers
	         * between 1 and 2n 
	         * The method will be tested by verifying that the array you return is n items long,
	         * contains only entries between 1 and 2n (inclusive) and has no duplicates
	         * 
	         * */
		 	int[] random = new int[n];
		 	//int num = (int)(Math.random()*2*n)+1;
		 	boolean hasDupe = true;
		 	int x =0;
		 	
		 	for(int i=0; i<n; i++){
		 		random[i] = (int)(2*n*Math.random())+1;
		 	}
		 	
		 	while(hasDupe){
			 	for(int j=0; j<n;j++){
			 		for(int h=j+1; h<n;h++){
				 		//if(j+1<n){
				 			if(random[j] == random[h]){
				 				random[h] = 0;
				 			}
				 		//}
			 		}
			 	}
			 	
			 	for(int g=0; g<n; g++){
			 		if(random[g] !=0){
			 			x++;
			 		}
			 		if(random[g] == 0){
			 			random[g] = (int)(2*n*Math.random())+1;
			 		}
			 	}
			 	
			 	if(x == n){
			 		hasDupe = false;
			 	}
			 	else{
			 		x=0;
			 	}
		 	}
		 	
	        return random; 
	    }
	 
	 public static int[] cycleThrough(int[] array, int n){
	        /** This problem represents people moving through a line.
	         * Once they get to the front of the line, they get what they've been waiting for, then they 
	         * immediately go to the end of the line and "cycle through" again.
	         * 
	         * This method reorders the array so that it represents what the array would look like
	         * after it had been cycled through an n number of times.
	         * For example, cycleThrough({2,1,5,6}}, 1) after executing, array == {1,5,6,2} 
	         * because '2' (the person at the front of the line) cycled through and is now at the end of the line
	         * 
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 2) after executing, array == {4,2,8,6,2,9,3,7} 
	         * because '3' and '7' (the TWO people at the front of the line) cycled through and are now at the end of the line
	         * 
	         * Likewise,
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 0) after executing, array == {3,7,4,2,8,6,2,9}  (no movement)
	         * and the most interesting case, 
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 49) after executing, array == {7,4,2,8,6,2,9,3}  
	         * Because after cycling through 49 times, everyone had a chance to go through 6 times, but '3'
	         * was able to go through one more time than anyone else
	         * 
	         * CHALLENGE
	         * For extra credit, make your method handle NEGATIVE n
	         * */
		 
		 	for(int i=0; i<n; i++){
		 		int tmp = array[0];
		 		for(int j=0; j<array.length; j++){
			 		if(j+1<array.length){
			 			array[j] = array[j+1];
			 		}else{
			 			array[array.length-1] = tmp;
			 		}
		 		}
		 	}
		 	return array;
	    }
}
