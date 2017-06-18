/**
 * 
 */
package prims1;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author RK
 *
 */
public class Prims1 {

	public static int getMST(Graph g) {
		int wmst=0;
		Edge e = null;
		Vertex src = g.verts.get(1);
		Vertex u,v;
		src.seen=true;
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>(g.numEdges,new EdgeMinComparator());
		List<Edge> edgeList = src.Adj;
		Iterator<Edge> itr = edgeList.iterator();
		while(itr.hasNext())
		{
			 e = itr.next();
			pQueue.add(e);
		}
		while(!pQueue.isEmpty())
		{
			e= pQueue.poll();
			if(e.From.seen && e.To.seen)
				continue;
			if(e.From.seen)
			{
				u = e.From;
				v=e.To;
			}
			else
			{
				u= e.To;
				v=e.From;
			}
			v.parent = u;
			wmst = wmst+e.Weight;
			v.seen = true;
			itr = v.Adj.iterator();
			while(itr.hasNext())
			{
				Edge f = itr.next();
				if( ! (f.otherEnd(v).seen) )
				{
					pQueue.add(f);
				}
			}
			
		}
			
		
		return wmst;
	}

	
	
}
