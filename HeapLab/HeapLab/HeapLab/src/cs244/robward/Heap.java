package cs244.robward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class Heap<Element extends Comparable<Element>> implements MinHeapInterface<Element> { //MIN HEAP!!!

	private ArrayList<Element> elements = new ArrayList<>();
	private Comparator<Element> comparator = (E1, E2) -> (E1.compareTo(E2));
	public Heap() {
		super();
		elements.add(null); 
	}
	public Heap( Comparator<Element> comparator) {
		super();
		this.comparator = comparator ; 
		elements.add(null); 
	}
	@Override
	public void add(Element element) {
		
		elements.add(element); 
		percolateUp(elements.size()-1);
	}

	int percolateUp(int index)
	{
		if (index == 1) {
			return (1);
		}
		int parentIndex = index/2;
		int comp = comparator.compare(elements.get(index),elements.get(parentIndex));
		if(comp < 0) { // if index < parentIndex comp = -1 (Min Heap)
			Collections.swap(elements,index,parentIndex);
		}
		//Collections.swap(elements,1,elements.size()-1);
		//
		return(parentIndex); //return new index of number
		
	} //END percolatUp
	
	int percolatDown(int index)
	{
		int lChildIndex = index*2;
		int rChildIndex = (index*2)+1;
		int childComp;
		int lcomp;
		int rcomp;
		
		if (rChildIndex > elements.size()-1 && lChildIndex < elements.size()-1) { //If rChild outOFbounds & lChild inBounds
			lcomp = comparator.compare(elements.get(index),elements.get(lChildIndex)); //compare parent & lChild
			if(lcomp > 0) {	//If parent > lChild
				Collections.swap(elements,index,lChildIndex); //swap parent and lChild
				return (lChildIndex); //return new index of the number
			}
		} //END if
		
		else if (lChildIndex > elements.size()-1 && rChildIndex < elements.size()-1) {	//If lChild outOFbounds & rChild inBounds
			rcomp = comparator.compare(elements.get(index),elements.get(rChildIndex)); //compare parent & rChild
			if(rcomp > 0) {	//If parent > rChild
				Collections.swap(elements,index,rChildIndex); //swap parent and rChild
				return (rChildIndex); //return new index of the number
			}
		} //END else if
		
		
		
		else if (lChildIndex < elements.size()-1 && rChildIndex < elements.size()-1) {	//If lChild inBounds & rChild inBounds

			childComp = comparator.compare(elements.get(lChildIndex),elements.get(rChildIndex)); //compare lChild & rChild
			lcomp = comparator.compare(elements.get(index),elements.get(lChildIndex)); //compare parent & lChild
			rcomp = comparator.compare(elements.get(index),elements.get(rChildIndex)); //compare parent & rChild
			if (childComp > 0 && lcomp > 0) { //if lChild > rChild && parent > lChild
				Collections.swap(elements,index,lChildIndex); //swap parent and lChild
				return (lChildIndex); //return new index of the number
			} //END if
			else if (childComp < 0 && rcomp > 0){	//if rChild > lChild && parent > rChild
				Collections.swap(elements,index,rChildIndex); //swap parent and rChild
				return (rChildIndex); //return new index of the number
			} //END else if

		} //END else if
		
		return(index);
		
	} //END percolatDown
	
	@Override
	public void clear() {
		elements = new ArrayList<>();
		elements.add(null);
		
	}

	@Override
	public Element get() {
		
		return peek();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elements.size() == 1;
	}

	@Override
	public Element peek() {
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		return elements.get(1);
	}

	@Override
	public Element pop() {
			
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		Collections.swap(elements, 1, elements.size() - 1);
		Element temp = elements.remove(elements.size() - 1);
		if(!isEmpty())
		{
			percolatDown(1);
		}
		
		return temp;
	}

	@Override
	public int size() {
		
		return elements.size() - 1;
	}

	@Override
	public void update(int index) {
		percolateUp(index);
		percolatDown(index);
		
	}

	@Override
	public ArrayList<Element> toArrayList() {
		
	
		ArrayList<Element> copy = new ArrayList<>();
		elements.forEach(value -> copy.add(value));
	   
		return copy;
	}

}
