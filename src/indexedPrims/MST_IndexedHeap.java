package indexedPrims;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Comparable;

public class MST_IndexedHeap {
    static final int Infinity = Integer.MAX_VALUE;

    static int PrimMST(Graph g)
    {	Vertex[] pq = new Vertex[g.numNodes+1];
    	pq[0]=null;
        int wmst = 0;
        Vertex src = g.verts.get(1);
        src.d=0;
        Iterator<Edge> itr;
        int i=0;
        Iterator<Vertex> itr1 =g.verts.iterator();
        itr1.next();
        while(itr1.hasNext())
        {
        	Vertex v = itr1.next();
        	v.position = ++i;
        	pq[i] = v;
        }
        IndexedHeap pQueue = new IndexedHeap(pq,new VertexMinComparator());
        while(!pQueue.isEmpty())
        {
        	Vertex u = (Vertex) pQueue.remove();
        	wmst += u.d;
        	 itr = u.Adj.iterator();
        	 while(itr.hasNext())
        	 {	Edge e =itr.next();
        		 Vertex v =  e.otherEnd(u);
        		 if(!v.seen && e.Weight<v.d)
        		 {
        			 v.d = e.Weight;
        			 v.parent= u;
        			 pQueue.decreaseKey(v);
        		 }
        	 }
        	
        }

        return wmst;
    }

    public static void main(String[] args) 
    {   Scanner in = new Scanner(System.in);
		Graph g = Graph.readGraph(in,false);
		long time1 = System.currentTimeMillis();
		int wmst1 = PrimMST(g);
		System.out.println(wmst1);
		long time2 = System.currentTimeMillis();
		long totalTime = time2 - time1;
		System.out.println("indexed Priority Queue of Vertices");
		System.out.println("time=" +totalTime);
    }
}
