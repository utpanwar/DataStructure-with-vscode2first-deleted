package 186 striver and codingN.graph;

public class disjointSet {
    
}

1.                          SIMPLE UNION FIND ALGORITHM
time - O(n);
O(n) beacause recur is 2T(n/2) + k
T(n) = T(n-1) + k; - it is O(n) in skewed tree
//find is like the virtual tree
PUBLIC static void find(int key,int parent[])
{
    if(parent[key] == key)
    return key; // then key itself is a  parent or root repersation it has no childern
    
    return find(parent[key] , parent); //then traverse upto root 
}
void Union(int parent[], int x, int y) 
    { 
        int xset = find(parent, x); 
        int yset = find(parent, y); 
        parent[xset] = yset; 
    } 


 2.                     UNION RANK BY COMPRESION
 IN this the tree never be skewed so the time complexity is always Log(n)
 because it is always to be balanced tree
 
 class DisjointUnionSets { 
    int[] rank, parent; 
    int n; 
  
    // Constructor 
    public DisjointUnionSets(int n) 
    { 
        rank = new int[n];  //initialy all ranks is 0
        parent = new int[n]; 
        this.n = n; 
        makeSet(); 
    } 
  
    // Creates n sets with single item in each 
    void makeSet() 
    { 
        for (int i = 0; i < n; i++) { 
            // Initially, all elements are in 
            // their own set. 
            parent[i] = i; 
        } 
    } 

    int find(int key )
    {
        if(parent[key]!=key)
        {
            parent[key]= find(parent[x]); 
        }
        return parent[key];
    }

    void union(int x, int y)
    {
        int xRoot = find(x);
        int yRoot = find(x);
        if (xRoot == yRoot) 
            return;
        if(rank[xRoot] < rank[yRoot])
        {
            parent[xRoot] = yRoot;
        }
        else if(rank[xRoot] > rank[yRoot])
        {
            parent[yRoot] = xRoot;
        }
        else
        {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] +1;

        }
    }
 

3.                    Union-Find Algorithm DETECT CYCLE IN A graph

// A union by rank and path compression 
// based program to detect cycle in a graph 
class Graph 
{ 
int V, E; 
Edge[] edge; 

Graph(int nV, int nE) 
{ 
	V = nV; 
	E = nE; 
	edge = new Edge[E]; 
	for (int i = 0; i < E; i++) 
	{ 
		edge[i] = new Edge(); 
	} 
} 

// class to represent edge 
class Edge 
{ 
	int src, dest; 
} 

// class to represent Subset 
class subset 
{ 
	int parent; 
	int rank; 
} 

// A utility function to find 
// set of an element i (uses 
// path compression technique) 
int find(subset [] subsets , int i) 
{ 
if (subsets[i].parent != i) 
	subsets[i].parent = find(subsets, 
							subsets[i].parent); 
	return subsets[i].parent; 
} 

// A function that does union 
// of two sets of x and y 
// (uses union by rank) 
void Union(subset [] subsets, 
		int x , int y ) 
{ 
	int xroot = find(subsets, x); 
		int yroot = find(subsets, y); 

	if (subsets[xroot].rank < subsets[yroot].rank) 
		subsets[xroot].parent = yroot; 
	else if (subsets[yroot].rank < subsets[xroot].rank) 
		subsets[yroot].parent = xroot; 
	else
	{ 
		subsets[xroot].parent = yroot; 
		subsets[yroot].rank++; 
	} 
} 
		
// The main function to check whether 
// a given graph contains cycle or not 
int isCycle(Graph graph) 
{ 
	int V = graph.V; 
	int E = graph.E; 

	subset [] subsets = new subset[V]; 
	for (int v = 0; v < V; v++) 
	{ 

		subsets[v] = new subset(); 
		subsets[v].parent = v; 
		subsets[v].rank = 0; 
	} 

	for (int e = 0; e < E; e++) 
	{ 
		int x = find(subsets, graph.edge[e].src); 
		int y = find(subsets, graph.edge[e].dest); 
		if(x == y) 
			return 1; 
		Union(subsets, x, y); 
	} 
return 0; 
} 

// Driver Code 
public static void main(String [] args) 
{ 
/* Let us create the following graph 
	0 
	| \ 
	| \ 
	1-----2 */

int V = 3, E = 3; 
Graph graph = new Graph(V, E); 

// add edge 0-1 
graph.edge[0].src = 0; 
graph.edge[0].dest = 1; 

// add edge 1-2 
graph.edge[1].src = 1; 
graph.edge[1].dest = 2; 

// add edge 0-2 
graph.edge[2].src = 0; 
graph.edge[2].dest = 2; 

if (graph.isCycle(graph) == 1) 
	System.out.println("Graph contains cycle"); 
else
	System.out.println("Graph doesn't contain cycle"); 
} 
} 

// This code is contributed 
// by ashwani khemani 
https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
 
4.
https://www.geeksforgeeks.org/union-find
-algorithm-union-rank-find-optimized-path-compression/?ref=rp
more optimized
  