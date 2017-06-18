/**
 * @author RK
 *
 */
package prims1;
// Ver 1.0:  Wec, Feb 3.  Initial description.

import java.util.Comparator;

public class BinaryHeap<T> implements PQ<T> {
    T[] pq;
    Comparator<T> c;
    int size=0; 
    /** Build a priority queue with a given array q */
    BinaryHeap(T[] q, Comparator<T> comp) {
	size=q.length-1;
    pq = q;
	c = comp;
	//buildHeap();
    }

    /** Create an empty priority queue of given maximum size */
    @SuppressWarnings("unchecked")
	BinaryHeap(int n, Comparator<T> comp) { /* to be implemented */
    	pq = (T[]) new Object[n];
    	c = comp;
    	size=0;
    }

    public void insert(T x) {
	add(x);
    }

    public T deleteMin() {
	return remove();
    }

    public T min() { 
	return peek();
    }

    public void add(T x) { /* to be implemented */
    	if(size==pq.length)
    	{
    		System.out.println("Priority Queue is full");
    		return;
    	}
    	pq[++size]=x;
    	percolateUp(size);
    }

    public T remove() { /* to be implemented */
	if(size==0)
		{
			System.out.println("Priority Queue is empty");
			return null;
		}
    T x = pq[1];
	pq[1] = pq[size];
	pq[size--]=null;
	percolateDown(1);
    	return x;
    }
    
    public T peek() { /* to be implemented */
	return pq[1];
    }

    /** pq[i] may violate heap order with parent */
    void percolateUp(int i) { /* to be implemented */
    	if(i==1)
    		return;
    	if(c.compare(pq[i], pq[i/2])==-1)
    		{ this.swap(i,i/2);
    		
    			percolateUp(i/2);
    		}
    	
    	
    }

    /** pq[i] may violate heap order with children */
    void percolateDown(int i) { /* to be implemented */
    	if(i>size/2)
    		return;
    	int flag1 = c.compare(pq[i],pq[2*i]);
    	int flag2=0;
    	if(2*i+1>size){
    		 flag2 = 0;
    	}
    	else{
    	 flag2 = c.compare(pq[i],pq[2*i+1]);
    	}
    	if(flag1==1 && flag2==1)
    	{
        	int flag3 = c.compare(pq[2*i],pq[2*i+1]);
        	if(flag3==1)
        	{
        		swap(i,2*i+1);
        		percolateDown(2*i+1);
        	}
        	else
        	{
        		swap(i,2*i);
        		percolateDown(2*i);
        	}

    	}
    	else if(flag1 == 1)
    	{
    		swap(i,2*i);
    		percolateDown(2*i);
    	}
    	else if (flag2 == 1)
    	{
    		swap(i,2*i+1);
    		percolateDown(2*i+1);
    	}
    }

    /** Create a heap.  Precondition: none. */
    void buildHeap() {
    	for(int i=size/2;i>0;i--)
		{	
    		percolateDown(i);
		}
    }

	 void swap(int i, int j) {
			T x = this.pq[i];
			this.pq[i]=this.pq[j];
			this.pq[j]=x;
	}

	/* sort array A[1..n].  A[0] is not used. 
       Sorted order depends on comparator used to buid heap.
       min heap ==> descending order
       max heap ==> ascending order
     */
    public static<T> void heapSort(T[] A, Comparator<T> comp) { /* to be implemented */
    	BinaryHeap<T> x = new BinaryHeap<T>(A,comp);
    	int sorted=0;
    	while(sorted!=x.pq.length)
    	{
    	T a = x.pq[1];
    	x.pq[1]=x.pq[x.pq.length-sorted-1];
    	x.pq[x.pq.length-sorted-1]=a;
		sorted++;
		x.size--;
		x.percolateDown(1);
    	}
    }

	public boolean isEmpty() {
		if(size==0)
			return true;
		else
			return false;
	}
    
    
}
