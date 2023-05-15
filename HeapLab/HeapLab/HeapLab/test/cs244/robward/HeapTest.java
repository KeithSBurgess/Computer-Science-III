package cs244.robward;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class HeapTest {

	
	@Test
	void peekOnEmpty() {
		Heap<Integer> heap = new Heap<>();
		
		 assertThrows(NoSuchElementException.class, () -> { heap.peek();  });
		
	}
	
	@Test
	void getOnEmpty() {
		Heap<Integer> heap = new Heap<>();
		
		 assertThrows(NoSuchElementException.class, () -> { heap.get();  });
		
	}
	
	@Test
	void popOnEmpty() {
		Heap<Integer> heap = new Heap<>();
		
		 assertThrows(NoSuchElementException.class, () -> { heap.pop();  });
		
	}
	
	@Test
	void addOnEmpty() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addOnEmptyMaxHeap() {
		Heap<Integer> heap = new Heap<>((val1, val2) -> val2.compareTo(val1));
		heap.add(50);
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addSmallerFirstLevel() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(40);
		
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addSmallerFirstLevelMax() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(40);
		
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addLargerFirstLevel() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addRightChildSmaller() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(40);
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), heap.peek()) 			
		
				 );
		
	}
	
	@Test
	void addRightChildLarger() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), heap.peek()) 			
		
				 );
		
	}
	@Test
	void addRightChildLargerget() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), heap.get()) 			
		
				 );
		
	}
	@Test
	void addLeftChildLevel2MinValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(40);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), actual.get(1)), 			
				    () -> assertEquals(new Integer(50), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(60), actual.get(4)) 
				 );
		
	}
	
	
	@Test
	void clear() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(40);
		heap.clear();
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertTrue(heap.isEmpty())
				   
				 );
		
	}
	@Test
	void clearThenAddLeftChildLevel2MinValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(40);
		heap.clear();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(40);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), actual.get(1)), 			
				    () -> assertEquals(new Integer(50), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(60), actual.get(4)) 
				 );
		
	}
	
	
	@Test
	void addLeftChildLevel2MaxValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(80);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), actual.get(1)), 			
				    () -> assertEquals(new Integer(60), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) 
				 );
		
	}
	
	@Test
	void addLeftChildLevel2MidValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(55);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), actual.get(1)), 			
				    () -> assertEquals(new Integer(55), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(60), actual.get(4)) 
				 );
		
	}
	
	@Test
	void addRightChildLevel2MaxValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(80);
		heap.add(90);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), actual.get(1)), 			
				    () -> assertEquals(new Integer(60), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) ,
				    () -> assertEquals(new Integer(90), actual.get(5)) 
				 );
		
	}
	
	@Test
	void addRightChildLevel2MinValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(80);
		heap.add(40);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(40), actual.get(1)), 			
				    () -> assertEquals(new Integer(50), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) ,
				    () -> assertEquals(new Integer(60), actual.get(5)) 
				 );
		
	}
	@Test
	void addRightChildLevel2MidValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(80);
		heap.add(55);
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(50), actual.get(1)), 			
				    () -> assertEquals(new Integer(55), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) ,
				    () -> assertEquals(new Integer(60), actual.get(5)) 
				 );
		
	}
	
	@Test
	void popLastValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		
		assertAll(	
				  () -> assertEquals(new Integer(50), heap.pop()) ,
				    ()->assertTrue(heap.isEmpty()),
				    () -> assertEquals(0, heap.size()) 			
				   
				 );
		
	}
	
	@Test
	void popSecondToLastValue() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		assertAll(	
				  () -> assertEquals(new Integer(50), heap.pop()) ,
				    ()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(1, heap.size()) 			
				   
				 );
		
	}
	
	@Test
	void popWithLevel2RightChild() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(60);
		heap.add(70);
		heap.add(80);
		heap.add(55);
		Integer val = heap.pop();
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	() -> assertEquals(new Integer(50), val),
				    ()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(55), actual.get(1)), 			
				    () -> assertEquals(new Integer(60), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) 
				   
				 );
		
	}
	
	@Test
	void popWithLevel2RightChildSmaller() {
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(70);
		heap.add(60);
		heap.add(80);
		heap.add(65);
		Integer val = heap.pop();
		ArrayList<Integer> actual = heap.toArrayList();
		assertAll(	() -> assertEquals(new Integer(50), val),
				    ()->assertFalse(heap.isEmpty()),
				    () -> assertEquals(new Integer(60), actual.get(1)), 			
				    () -> assertEquals(new Integer(65), actual.get(2)), 
				    () -> assertEquals(new Integer(70), actual.get(3)), 			
				    () -> assertEquals(new Integer(80), actual.get(4)) 
				   
				 );
		
	}
}
