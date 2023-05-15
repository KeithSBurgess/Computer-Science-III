package itec220.labs;

import java.util.Collections;

public class Sorts {
	
	
	public interface SortType {
		void integerSort(int[] sort);
	}
	
	
	
	/*
	 * Method finds the smallest number in the given array
	 */
	public static int findMin(int[] sort) {
		int min = sort[0];
		for(int i=0;i<sort.length;i++) {				
			if(sort[i] < min) {
				min = sort[i];
			}
		}
		return min;
	} //END findMin
	
	/*
	 * Method finds the biggest number in the given array
	 */
	public static int findMax(int[] sort) {
		int max = sort[0];
		for(int i=0;i<sort.length;i++) {				
			if(sort[i] > max) {
				max = sort[i];
			}
		}
		return max;
	} //END findMAX
	
	/*
	 * Method counts the number of occurrences of the given index number
	 */
	/*public static int countMethod(int[] sort,int index) {
		int x = 0;
		int size = sort.length;

			for(int j=0;j<size;j++) {				
				if(sort[j] == index) {
					x++;
				}
			}
		
		return x;
	} //END countMethod
	*/
	
	/*
	 * Method sorts the 'sort array' given the countList array
	 */
	public static void sortMethod(int[] sort,int[] countList,int[] sortedArray) {
		int num;
		int index;
		for(int i=sort.length-1;i>=0;i--) { //[starting from rear]
			num = sort[i];						//num is the number in the 'sort' array (used to reference index)
			index = countList[num]-1;			//index is the new sorted index for given num
			sortedArray[index] = num;			//stores number in its correctly sorted index
			countList[num] = index;				//store decremented index			
		}
		
		for(int i=0;i<sort.length;i++) {
			sort[i] = sortedArray[i];
		}
		
	} //END sortMethod
	
	/*
	 * START of countingSort
	 */
	public static void countingSort(int[] sort)
	{
		int size;
		int min;
		int max;
		
		size = sort.length;		
		min = findMin(sort);
		max = findMax(sort);		
		size = (max-min)+1;
		
		int[] countList = new int [size];	//Declaring new array of length 'size' to store counts
		
		/*(int i=0;i<size;i++) {
			countList[i] = countMethod(sort,i); //countMethod Call

		}*/
		
		//counts how many times each number occurs
        for (int i = 0; i < sort.length; i++) {
            int current = sort[i] - min;
            countList[current] += 1 ;
        }
		
		
		for(int i=0;i<size-1;i++) {		//Adjusts countList (by adding counts) for sorting
			countList[i+1] = countList[i] + countList[i+1];
		}
		
		int[] sortedArray = new int [size]; //Creates new array to store sorted data
		sortMethod(sort,countList,sortedArray);	//sortMethod Call

		

	} //END countingSort
	
	
	//------------------------------------------------------------------------------------
	
	
	/*
	 * Method sorts the 'sort array' given the countList array
	 */
	public static void sortDigitMethod(int[] sort,int[] countList,int size,int divideBy) {
		int num;
		int index;
		int[] sortedArray = new int [size]; //Creates new array to store sorted data
		
		for(int i=sort.length-1;i>=0;i--) { 	//[starting from rear]
			num = (sort[i]/divideBy)%10;		//num is the number in the 'sort' array (used to reference index)
			index = countList[num]-1;			//index is the new sorted index for given num
			sortedArray[index] = sort[i];		//stores number in its correctly sorted index
			countList[num] = index;				//store decremented index			
		}
		
		for(int i=0;i<sort.length;i++) {	//Updates sort array
			sort[i] = sortedArray[i];
		}
		
	} //END sortdigitMethod
	
	
	/*
	 * START of radixSort
	 */
	public static void radixSort(int[] sort)
	{	
		int temp;
		int size;
		int min;
		int max;
		int digits = 0; //counts the max number of digits [loop counter]
		int divideBy = 1;
		
		size = sort.length;		
		min = findMin(sort);
		max = findMax(sort);		
		size = (max-min)+1;
		temp = max;
		
		while(temp>0) {	//gets max number of digits
			temp /= 10;
			digits++;
		}
		

		//Loops through each digit
		while(digits > 0) {
			
			int[] countList = new int [10];	//Declaring new array of length 10 to store counts of digits	

			
			//counts how many times each number occurs
	        for (int i = 0; i < sort.length; i++) {
	            int current = (sort[i]/divideBy)%10;
	            countList[current] += 1 ;
	        }
			
			
			for(int i=0;i<10-1;i++) {		//Adjusts countList (by adding counts) for sorting
				countList[i+1] = countList[i] + countList[i+1];
			}
	        
			sortDigitMethod(sort,countList,size,divideBy);	//sortDigitMethod Call
			
			digits--;		//Update loop counter
			divideBy *= 10;	//Update divideBy

		} //END while loop
		
	}//END radixSort
	
	
//------------------------------------------------------------------------------------
	
	
	/*
	 * START of shellSort
	 */
	public static void shellSort(int[] sort)
	{
		//int[] sort = {5,10,15,20,25,35,40,45,50, 10};	//TEST ARRAY
		
		for(int gap = sort.length/2; gap > 0;gap/=2) {
			for(int i=gap;i<sort.length;i++) {
				int temp = sort[i];				
				int j;
				for(j=i;j>=gap && sort[j-gap]>temp;j-=gap) {
					sort[j]=sort[j-gap];
				}//END for
				sort[j]=temp;

			}//END for

		}//END for
		
		
		
		/*for(int k=0;k<sort.length;k++) { //TEST Function to print array
			System.out.print(sort[k]+" ");
		}
		System.out.println();*/

		
	}//END shellSort
	
	
//---------------------------------------------------------------------------------
	
	
	public static void merge(int[] sort,int[] dest,int destIndex,int start1,int end1, int start2, int end2) {
		while(start1 <= end1 || start2 <= end2) {
			
			while(start1<= end1 && (start2 > end2 || sort[start1] < sort[start2])) {
				dest[destIndex++]=sort[start1++];
			}
			
			while(start2 <= end2 && (start1 > end1 || sort[start2] < sort[start1])) {
				dest[destIndex++] = sort[start2++];
			}
	
		}
	}	
	
	
	public static void mergeSort(int[] sort) {
		//int[] sort = {5,10,15,20,7,9,23,50,80};
        int[] dest = new int[sort.length];
        int destIndex=0;
        int start1,end1,start2,end2;
        
        start1=0;
        end1=3;
        start2=4;
        end2=8;
        
        System.out.println("Before Merge Sort");
        for(int k=0;k<sort.length;k++) { //TEST Function to print array
    		System.out.print(sort[k]+" ");
         }
    	System.out.println();
        
    	merge(sort,dest,destIndex,start1,end1,start2,end2);	//METHOD CALL
        
        System.out.println("After Merge Sort");
        
        for(int k=0;k<dest.length-1;k++) { //TEST Function to print array
		System.out.print(dest[k]+" ");
        }
	System.out.println();
           
        
	}//END mergeSort
	
//-------------------------------------------------------------------
	
	//1. HEAPIFY	2. SORT (Just need to extract top value each time by swapping with last element then heapify)
	
	static void heapify(int[] sort,int length,int index) {
		int temp; //Used for swapping
		int max = index;
		int lChildIndex = index*2+1;
		int rChildIndex = (index*2)+2;
		
		if (lChildIndex < length && sort[lChildIndex] > sort[max]) {
			max = lChildIndex;
		}
		
		if (rChildIndex < length && sort[rChildIndex] > sort[max]) {
			max = rChildIndex;
		}
		
		if (max != index) {
			temp = sort[index];
			sort[index] = sort[max];
			sort[max] = temp;
			heapify(sort,length,max);
		}
	} //END heapify
	
	
	public static void heapSort(int[] sort)
	{
		//int[] sort = {22,16,18,8,6,15,11,4,3};	//TEST ARRAY
		
		int length = sort.length;

		for (int i=length/2-1; i >= 0; i--) {
			heapify(sort,length,i);
		}		
		for (int i=length-1; i >= 0; i--) { //SWAP ROOT with last index, heapify again w/ reduced length
			int temp = sort[0];
			sort[0] = sort[i];
			sort[i] = temp;
			heapify(sort,i,0);
		}
		
		
	}//END heapSort

}