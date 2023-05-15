package itec220.labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;




public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);
		for (int i = 0; i < 100; i++)
		{
		   numbers.add(i);
		
		}	
		int itemsPerLine = 10;
		Sorts.SortType libsort = (int[] list) -> {Arrays.sort(list); };		
		sortTest("Library Sort", numbers, itemsPerLine,libsort );		
		// What is going on here? with Sorts::countingSort
		sortTest("Counting Sort", numbers, itemsPerLine,Sorts::countingSort );
		// What is going on here? with Sorts::radixSort
		sortTest("Radix Sort", numbers, itemsPerLine,Sorts::radixSort );

	}

	public static void sortTest(String sortName, ArrayList<Integer> listTosort, int itemsPerLine, Sorts.SortType sortMethod)
	{
		
		System.out.println(sortName);
		Collections.shuffle(listTosort);
		// What is going on Here?
		int[] unsorted = listTosort.stream().mapToInt(i -> i).toArray();
		
		
		System.out.println("Before Sorting");
		printList(unsorted,itemsPerLine);
		System.out.println();
		
		sortMethod.integerSort(unsorted);
		
		System.out.println("After Sorting");
		printList(unsorted,itemsPerLine);
		System.out.println();
		
	}
	// warm up
	// fix the error in this method
	// by moving one line of code (do not add or remove any code)
	public static void printList(int[] print, int itemsPerLine)
	{
		
		int count = itemsPerLine;
		for (int i = 0; i < print.length ; i++) {
			
			System.out.format("%4d", print[i]);
			
			if (count == 0)
			{
				System.out.println();
				count = itemsPerLine;
			}
			count--;
		}
		System.out.println();
	}
}
