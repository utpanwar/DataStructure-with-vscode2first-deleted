package 186 striver and codingN;

public class graph1 {

1.                              KRUSHKAL ALGO
with union and rank

// Java program for Kruskal's algorithm to 
// find Minimum Spanning Tree of a given 
//connected, undirected and weighted graph
import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
	// A class to represent a graph edge
	class Edge implements Comparable<Edge> 
	{
		int src, dest, weight;

		// Comparator function used for 
		// sorting edgesbased on their weight
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
	};

	// A class to represent a subset for 
	// union-find
	class subset 
	{
		int parent, rank;
	};

	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges

	// Creates a graph with V vertices and E edges
	Graph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// A utility function to find set of an 
	// element i (uses path compression technique)
	int find(subset subsets[], int i)
	{
		// find root and make root as parent of i 
		// (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent
				= find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	// A function that does union of two sets 
	// of x and y (uses union by rank)
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root 
		// of high rank tree (Union by Rank)
		if (subsets[xroot].rank 
			< subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank 
				> subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as 
		// root and increment its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to construct MST using Kruskal's
	// algorithm
	void KruskalMST()
	{
		// Tnis will store the resultant MST
		Edge result[] = new Edge[V]; 
	
		// An index variable, used for result[]
		int e = 0; 
	
		// An index variable, used for sorted edges
		int i = 0; 
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing
		// order of their weight. If we are not allowed to
		// change the given graph, we can create a copy of
		// array of edges
		Arrays.sort(edge);

		// Allocate memory for creating V ssubsets
		subset subsets[] = new subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new subset();

		// Create V subsets with single elements
		for (int v = 0; v < V; ++v) 
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < V - 1) 
		{
			// Step 2: Pick the smallest edge. And increment
			// the index for next iteration
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			// If including this edge does't cause cycle,
			// include it in result and increment the index
			// of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		// print the contents of result[] to display
		// the built MST
		System.out.println("Following are the edges in "
						+ "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].src + " -- "
							+ result[i].dest
							+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "
						+ minimumCost);
	}

	// Driver Code
	public static void main(String[] args)
	{

		/* Let us create following weighted graph
				10
			0--------1
			| \	 |
		6| 5\ |15
			|	 \ |
			2--------3
				4	 */
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		// Function call
		graph.KruskalMST();
	}
}
// This code is contributed by Aakash Hasija

1.B
union and find

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
	class Edge implements Comparable<Edge> 
	{
		int src, dest, weight;
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
	};
	class subset 
	{
		int parent, rank;
	};

	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all 

	Graph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	int find(subset subsets[], int i)
	{

		if (subsets[i].parent != i)
			subsets[i].parent
				= find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if (subsets[xroot].rank 
			< subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank 
				> subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	void KruskalMST()
	{

		Edge result[] = new Edge[V]; 
		int e = 0; 
		int i = 0; 
		for (i = 0; i < V; ++i)
			result[i] = new Edge();
		Arrays.sort(edge);
		int p[] = new int[V];
		for (i = 0; i < V; ++i)
			p[i] = -1;

		i = 0; 
		while (e < V - 1) 
		{
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
		}
		System.out.println("Following are the edges in "
						+ "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].src + " -- "
							+ result[i].dest
							+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "
						+ minimumCost);
	}

	// Driver Code
	public static void main(String[] args)
	{

		/* Let us create following weighted graph
				10
			0--------1
			| \	 |
		6| 5\ |15
			|	 \ |
			2--------3
				4	 */
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		// Function call
		graph.KruskalMST();
	}
}
// This code is contributed by Aakash Hasija

}



2.                          PRIMS ALGORITHM

package graph;

import java.util.Scanner;

import priority_queue.Priority_queue;

public class Primsalgo {
    
	static int cost,count;
    public static void main(String args[] ) throws Exception {
      Scanner s = new Scanner(System.in);
      int V = s.nextInt();
      int E = s.nextInt();
//      int D = s.nextInt();
      int edge[][] = new int[V][V];
      for(int i =0 ; i< E ; i++)
      {
          int sv = s.nextInt()-1;
          int ev = s.nextInt()-1;
          int we = s.nextInt();
          edge[sv][ev] =we;
          edge[ev][sv] =we;
      }
      boolean visited[] = new boolean[V];
      dfs(visited,0,V,edge);
//      System.out.println(count);
     
    }
    public static void dfs(boolean visited[] , int sr,int V ,int edge[][])
    {
    	int w [] = new int[V];
//    	Priority_queue w = new Priority_queue();
    	int p [] = new int[V];
    	w[0] = 0;
//    	w.insert(0);
    	p[0] = -1;
    	for(int i =1 ; i<V ;i++)
    	{
    		w[i]  = Integer.MAX_VALUE;
    	}
        for(int i =0 ; i<V ; i++)
        {
        	int min = minV(w,visited);
        	visited[min]=true;
        for(int j =0 ; j < V ;j++)	
        {
            if(!visited[j] && edge[min][j]!=0)
            {
                
                if(edge[min][j]<w[j])
                {
                	w[j] = edge[min][j];
                	p[j] = min;
                }
                
            }
        }
         }
        
        for(int i = 1; i<V;i++)
        {
      	  if(p[i]  <i)
      	  {
      		  System.out.println(p[i]+" "+i+" "+ w[i]);
      	  }
      	  else
      		System.out.println(i+" "+p[i]+" "+ w[i]);
        }
    }
    
  public static int  minV(int w[]  , boolean visited [] )
    {
	  {
	    	int minI = -1 ;
	    	for(int i =0 ; i<w.length; i++)
	    	{
	    		if( (minI == -1 || w[i] < w[minI]) && !visited[i])
	    		{
	    			minI = i;
	    		}
	    	}
	    	return minI;
	    }
    }
}

//3 3 25
//1 2 10
//2 3 20
//3 1 30





//5 7
//0 1 7
//0 2 8
//1 2 2
//1 3 6
//2 3 3
//2 4 9
//3 4 6
   
   
   
   
//   1
//   7
//   10
//   1 2 5
//   1 4 3
//   1 5 12
//   1 6 5
//   4 5 1
//   5 6 2
//   5 3 1
//   3 6 16
//   4 7 1
//   2 4 1
//   5
//   1 6
//   2 4
//   3 5
//   3 6
//   1 2  

//   1
//   5
//   7
//   1 2 4
//   1 3 8
//   2 3 2
//   2 4 6
//   3 4 3
//   3 5 9
//   4 5 6
//   1
//   3 5
//   3 5
   