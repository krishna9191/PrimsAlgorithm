package indexedPrims;

import java.util.Comparator;

class VertexMinComparator implements Comparator<Object> {
	  public int compare(Object o1, Object o2) {
		  Vertex j1 = ( (Vertex) o1);
		  Vertex j2 = ( (Vertex) o2);
	    return (j1.d < j2.d ? -1 : (j1.d == j2.d ? 0 : 1));
	  }
}
	  