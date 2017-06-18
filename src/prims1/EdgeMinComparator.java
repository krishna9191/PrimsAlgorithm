package prims1;

import java.util.Comparator;

class EdgeMinComparator implements Comparator<Object> {
	  public int compare(Object o1, Object o2) {
		  Edge j1 = ( (Edge) o1);
		  Edge j2 = ( (Edge) o2);
	    return (j1.Weight < j2.Weight ? -1 : (j1.Weight == j2.Weight ? 0 : 1));
	  }
}
	  