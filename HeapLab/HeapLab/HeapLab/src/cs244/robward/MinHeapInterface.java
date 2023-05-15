package cs244.robward;

import java.util.ArrayList;

public interface MinHeapInterface<Element extends Comparable<Element>> {
	
	/**
	 *  Adds an object to this heap.
	 * @param Key This Student's new name.  
	 * @param Value The value Student's new name.  
	 */
	public void add(Element element);
	/**
	 *   Clears all elements from the Heap.
	 */
    void clear() ;
     /**
 	 *   Returns the Min element.
 	 */
    Element get();
     /**
  	 *    Tests if queue is empty.
  	 */
    boolean	isEmpty() ;
    
     /**
  	 *    Returns the element on top of heap but don't remove it.
  	 */
    Element	peek() ;
    
     /**
  	 *    Returns the element on top of heap and removes it.
  	 */
    Element	pop() ;

     /**
  	 *    Returns the number of elements in this heap.
  	 */
     int	size() ;
     /**
   	 *    Returns a string representation of this heap.
   	 */
     String	toString() ;
     
     /**
     *    Update position of the item at the index position in the array.
     */
    void update(int index);
     
  
    /**
   	 *    Returns a copy of the elements in their current position.
   	 */
    ArrayList<Element>	toArrayList() ;
   
	
}
