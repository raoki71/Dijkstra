package edu.iastate.coms3110.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


/**
 * @param <T>
 */
public class BinaryMinHeap<T> extends PurePriorityQueue<T> {
    private ArrayList<T> heap = new ArrayList<T>();
    private HashMap<T, Integer> location = new HashMap<T, Integer>();

    public BinaryMinHeap(Comparator<T> comp) {
        super(comp);
    }

    /**
     * 
     *
     * @return The number of elements in the heap
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Adds an element to the heap.
     *
     * @param item An element not in the heap that will be added to it.
     */
    @Override
    public void add(T item) {
    	location.put(item, heap.size());
        heap.add(heap.size(), item);
        keyDecreased(item);
    }

    /**
     * 
     *
     * @return Returns the minimum element of the heap without removing it.
     */
    @Override
    public T getMin() {
        return heap.get(0);
    }

    /**
     * Removes the minimum element from the heap and returns it.
     *
     * @return The minimum element that was in the heap when the method was invoked.
     */
    @Override
    public T extractMin() {
    	T min = getMin();
    	heap.set(0, heap.get(size()-1));
    	location.replace(heap.get(size()-1), 0);
    	heap.remove(size()-1);
    	location.remove(min);
    	minHeapify(0);
        return min;
    }

    /**
     * Anytime the key decreases for an element in the heap, this method must be
     * invoked to restored the heap property. Here, key refers to the value
     * determining the ordering of heap elements as used in the Comparator.
     *
     * @param item An item in the heap that has had its key decreased.
     */
    @Override
    public void keyDecreased(T item) {
        Integer i = location.get(item);
        while(i > 0 && comp.compare(heap.get(parent(i)), item) == 1) {
        	T temp = item;
        	heap.set(i, heap.get(parent(i)));
        	location.replace(heap.get(parent(i)), i);
        	heap.set(parent(i), temp);
        	location.replace(temp, parent(i));
        	i = parent(i);
        }
    }
    
    private int parent(int i) {
    	return (i / 2);
    }
    
    private int left(int i) {
    	return 2 * i;
    }
    
    private int right(int i) {
    	return 2 * i + 1;
    }
    
    
    /**
     * Maintains the min-heap property
     * @param i
     */
    private void minHeapify(int i) {
    	int l = left(i);
    	int r = right(i);
    	int smallest;
    	if(l < heap.size() && (comp.compare(heap.get(l), heap.get(i)) == -1)) {
    		smallest = l;
    	} else {
    		smallest = i;
    	}
    	if(r < heap.size() && (comp.compare(heap.get(r), heap.get(smallest)) == -1)) {
    		smallest = r;
    	}
    	if(smallest != i) {
    		T temp = heap.get(i);
    		heap.set(i, heap.get(smallest));
    		location.replace(heap.get(smallest), i);
    		heap.set(smallest, temp);
    		location.replace(temp, smallest);
    		minHeapify(smallest);
    	}
    }
    
//	public void printlist() {
//	for(int i = 0; i < heap.size(); i++) {
//		if(i == 0) System.out.print("[");
//		System.out.print(heap.get(i));
//		if(i != heap.size()-1) {
//			System.out.print(", ");
//		} else {
//			System.out.println("]");
//		}
//	}
//}
}
