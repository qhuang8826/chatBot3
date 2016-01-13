package Introduction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] test = {1,7,8,8,12};
//		int[] test2 = {-2,4,5};
		int[] test3 = {10,9,8,7,5,7,0,2,12,11};
		//selectionSort(test);
		//bubbleSort(test);
		//int[] combined = merge(test,test2);
		//int[] combined = mergeSort(test3);
		quickSort(test3, 0, test3.length-1);
		System.out.println(Arrays.toString(test3));
		//System.out.println(Arrays.toString(combined));
		//System.out.println("10! is " + factorial(-1));
	}
	
	public static int factorial(int n) {
		if(n<2)return 1;
		return n*factorial(n-1);
	}

	public static void swap(int[] array, int a, int b) {
		int placeholder = array[a];
		array[a] = array[b];
		array[b] = placeholder;
	}

	public static void selectionSort(int[] array){
		for(int i=0; i<array.length;i++){//2ms  n+1
			int tempMin = i;//1ms    n
			for(int j=i; j<array.length;j++){//(n/2)(n+1)
				if(array[j]<array[tempMin]){//1ms    n
					tempMin = j;//1ms     n
					System.out.println("index "+i+" tempMin="+tempMin);
				}
				
			}
			System.out.println(Arrays.toString(array));
			swap(array,i,tempMin);//1ms    n
			System.out.println("We swap "+i+" and "+tempMin+" resulting in" +Arrays.toString(array));
		}
	}//2n+2+n+2n+2+n+n+n= 8n+4
	
	public static int[] bubbleSort(int[] array){
		for(int i=0; i<array.length;i++){
			for(int j=1; j<array.length-i;j++){
					if(array[j]<array[j-1]){
						swap(array,j,j-1);
						//System.out.println(Arrays.toString(array));
					}
			}
		}
		return array;
	}
	
	public static int[] merge(int[] a, int[] b){
		int i=0;
		int j=0;
		int k=0;//index in result
		int[] result = new int[a.length+b.length];
		while(i<a.length && j <b.length){
			if(a[i]<b[j]){
				result[k]=a[i];
				i++;
			}
			else{
				result[k]=b[j];
				j++;
			}
			k++;
		}
		while(i<a.length){
			//add the rest of a
			result[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length){
			//add the rest of b
			result[k]=b[j];
			j++;
			k++;
		}
		return result;
	}
	
	public static int[] mergeSort(int[]array){
		if(array.length == 1){
			return array;
		}
		int half = (array.length)/2;
		int[] half1 = new int[half];
		int[] half2 = new int[array.length-half];
		for(int i=0; i<half1.length; i++){
			half1[i] = array[i];
		}
		for(int j=0; j<half2.length; j++){
			half2[j] = array[half+j];
		}
		System.out.println(Arrays.toString(half1) + " and " + Arrays.toString(half2));
		return merge(mergeSort(half1),mergeSort(half2));
		
	}
	
	static int count = 0;
	public static void quickSort(int[] array,int start, int end){
//		if(count<100){
//			count++;
//		
		if(start==end)return;
		int pivotIndex = (end+start)/2;
		//System.out.println("Attempting to quickSort array from " +
		//		start + " to " + end+". The pivotIndex is "+pivotIndex);
		//if(pivotIndex ==1)return;
		int pivot = array[pivotIndex];
		//System.out.println("Pivot is "+ pivot);
		int i=start;
		int j=end;
		while(i<=j){
			if(array[i]>=pivot && array[j]<=pivot){
				System.out.println("Swapping the "+array[i]+" and "+array[j]);
				swap(array,i,j);
				i++;
				j--;
			}
			if(array[i]<=pivot ){
				i++;
			}
			if(array[j]>pivot){
				j--;
			}
		}
		quickSort(array,start,j);
		quickSort(array,j+1,end);
		System.out.println("Result is: "+Arrays.toString(array));
	}
	//}
}
