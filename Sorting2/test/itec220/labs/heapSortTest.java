package itec220.labs;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




class heapSortTest { 

	
	public static  Sorts.SortType sort = Sorts::shellSort;
	public static ArrayList<Integer> integer1024;
	public static ArrayList<Integer> integer1025;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		integer1024 = new ArrayList<>();
		integer1025 = new ArrayList<>();
		for (int i = 0; i < 1024; i++) {			
			integer1024.add(i);
			integer1025.add(i);
		}
		
	}
	
	@Test
	void emptyList() {
		
		
		int[] test = new int[0];
		sort.integerSort(test);
		
		assertTrue(test.length == 0);
	}
	
	@Test
	void singleItem() {
		int[] test = {12}; 		
	
		sort.integerSort(test);
		assertAll(()-> assertEquals(12 ,test[0])  );   
	}
	
	@Test
	void twoItems() {
		int[] test = {25, 12}; 
		
		sort.integerSort(test);
		
		assertAll(()-> assertEquals(12 ,test[0]),
				  ()-> assertEquals(25 ,test[1]));
	}

	@Test
	void tenItems() {
		// even number of items
		int[] test = {99, 25, 12 , 33, 13, 66, 19, 78, 85, 5}; 
		
		sort.integerSort(test); 
		
		assertAll(()-> assertEquals(5 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(13 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(25 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(85 ,test[8]),
				  ()-> assertEquals(99 ,test[9]));
	}
	
	
	@Test
	void elevenItems() {
		// even number of items
		int[] test = {99, 25, 12 , 33, 13, 66, 19, 78, 85, 5, 105}; 
		
		sort.integerSort(test);
				
		assertAll(()-> assertEquals(5 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(13 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(25 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(85 ,test[8]),
				  ()-> assertEquals(99 ,test[9]),
				  ()-> assertEquals(105 ,test[10]));
	}
	
	@Test
	void tenItemsWithDups() {
		// even number of items
		int[] test = {99, 99, 12 , 33, 12, 66, 19, 78, 12, 33}; 
		
		sort.integerSort(test); 
		
		assertAll(()-> assertEquals(12 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(12 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(33 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(99 ,test[8]),
				  ()-> assertEquals(99 ,test[9]));
	}
	
	
	@Test
	void elevenItemsWithDups() {
		// even number of items
int[] test = {99, 99, 12 , 33, 12, 66, 19, 78, 12, 33, 99}; 
		
		sort.integerSort(test); 
		
		assertAll(()-> assertEquals(12 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(12 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(33 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(99 ,test[8]),
				  ()-> assertEquals(99 ,test[9]),
				  ()-> assertEquals(99 ,test[10]));
	}
	
	
	@Test
	void reverseOrder() {
		// even number of items
		int[] test = {105, 99, 85 , 78, 66, 33, 25, 19, 13, 12, 5}; 
		
		sort.integerSort(test);
				
		assertAll(()-> assertEquals(5 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(13 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(25 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(85 ,test[8]),
				  ()-> assertEquals(99 ,test[9]),
				  ()-> assertEquals(105 ,test[10]));
	}
	
	@Test
	void inOrder() {
		// even number of items
		int test[] = {5, 12, 13 , 19, 25, 33, 66, 78, 85, 99, 105}; 
	
		sort.integerSort(test);
				
		assertAll(()-> assertEquals(5 , test[0]),
				  ()-> assertEquals(12 ,test[1]),
				  ()-> assertEquals(13 ,test[2]),
				  ()-> assertEquals(19 ,test[3]),
				  ()-> assertEquals(25 ,test[4]),
				  ()-> assertEquals(33 ,test[5]),
				  ()-> assertEquals(66 ,test[6]),
				  ()-> assertEquals(78 ,test[7]),
				  ()-> assertEquals(85 ,test[8]),
				  ()-> assertEquals(99 ,test[9]),
				  ()-> assertEquals(105 ,test[10]));
	}
	
	@Test
	void largeTestEven() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1024);
		Collections.shuffle(listTosort);	
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1024.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
		
	}
	

	@Test
	void largeTestOdd() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1025);
		Collections.shuffle(listTosort);	
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1025.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
	}
	
	@Test
	void largeTestEvenInorder() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1024);
	
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1024.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
	}
	

	@Test
	void largeTestOddInorder() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1025);
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1025.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
		
	}
	
	@Test
	void largeTestEvenReverseOrder() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1024);
		Collections.reverse(listTosort);
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1024.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
		
	}
	

	@Test
	void largeTestOddReverseOrder() {
	
		
		ArrayList<Integer> listTosort = new ArrayList<>(integer1025);
		Collections.reverse(listTosort);
		int[] test = listTosort.stream().mapToInt(i -> i).toArray();
		sort.integerSort(test);
		int[] expected = integer1025.stream().mapToInt(i -> i).toArray();
		assertArrayEquals(expected, test);
		
		
	}
}
