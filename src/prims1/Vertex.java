package prims1;

/**
 * @author RK
 *
 */
/**
 * Class to represent a vertex of a graph
 * 
 *
 */

import java.util.*;

public class Vertex {
	public int name; // name of the vertex
	public boolean seen; // flag to check if the vertex has already been visited
	public Vertex parent; // parent of the vertex
	public int distance; // distance to the vertex from the source vertex
	public List<Edge> Adj, revAdj; // adjacency list; use LinkedList or
									// ArrayList
	public int d;
	int position;

	/**
	 * Constructor for the vertex
	 * 
	 * @param n
	 *            : int - name of the vertex
	 */
	Vertex(int n) {
		name = n;
		seen = false;
		parent = null;
		Adj = new ArrayList<Edge>();
		d = Integer.MAX_VALUE;
		revAdj = new ArrayList<Edge>(); /* only for directed graphs */
	}

	/**
	 * Method to represent a vertex by its name
	 */
	public String toString() {
		return Integer.toString(name);
	}

	}


