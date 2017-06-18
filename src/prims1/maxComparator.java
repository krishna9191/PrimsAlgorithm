package prims1;

import java.util.Comparator;

class maxComparator implements Comparator {
	  public int compare(Object o1, Object o2) {
		  int j1 = Integer.parseInt( (String) o1);
		  int j2 = Integer.parseInt( (String) o2);
	    return (j1 > j2 ? -1 : (j1 == j2 ? 0 : 1));
	  }
}
	  