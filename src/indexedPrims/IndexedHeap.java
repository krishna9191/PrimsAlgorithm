package indexedPrims;

// Ver 1.0:  Wec, Feb 3.  Initial description.

import java.util.Comparator;

public class IndexedHeap<T extends Index> extends BinaryHeap<T> {
	/** Build a priority queue with a given array q */
	IndexedHeap(T[] q, Comparator<T> comp) {
		super(q, comp);
	
	}

	/** Create an empty priority queue of given maximum size */
	IndexedHeap(int n, Comparator<T> comp) {
		super(n, comp);
	}

	/** restore heap order property after the priority of x has decreased */
	void decreaseKey(T x) {
		/*if(x.getIndex()==3)
		{
			System.out.println();
		}*/
		percolateUp(x.getIndex());
	}
	

}
