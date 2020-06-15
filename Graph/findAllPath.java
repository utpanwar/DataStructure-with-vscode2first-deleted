package Graph;
// https://www.geeksforgeeks.org/print-paths-given-source-destination-using-bfs/
import java.util.*;

//utility function for printing 
//the found path in graph 

public class findAllPath
{ 
	public static void main(String []args)
	{
		int v = 4; 
		ArrayList<ArrayList<Integer>> g = new 
				ArrayList<ArrayList<Integer>>();
		for(int i =0;i < v;i++)
		{
			g.add(new ArrayList<Integer>());
		}
		g.get(0).add(3);
		g.get(0).add(1);
		g.get(0).add(2);
		g.get(1).add(3);
		g.get(2).add(0);
		g.get(2).add(1);

		int src = 2, dst = 3; 
		findpaths(g, src, dst, v); 
	}

	
static void printpath(ArrayList<Integer> path) 
{ 
	int size = path.size(); 
	for (int i = 0; i < size; i++) 
		System.out.print(path.get(i)+ " ");
	System.out.println();
} 

//utility function to check if current 
//vertex is already present in path 
static boolean isNotVisited(int x, ArrayList<Integer> path) 
{ 
	int size = path.size(); 
	for (int i = 0; i < size; i++) 
		if (path.get(i) == x) 
			return false; 
	return true; 
} 

//utility function for finding paths in graph 
//from source to destination 
static void findpaths(ArrayList<ArrayList<Integer>> g, int src, 
								int dst, int v) 
{ 
	// create a queue which stores 
	// the paths 
//	queue<vector<int> > q; 
    Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
	// path vector to store the current path 
//	vector<int> path; 
    ArrayList<Integer> path  = new ArrayList<>();	
//	path.push_back(src); 
    path.add(src);
	q.add(path); 
	while (!q.isEmpty()) { 
		path = (ArrayList<Integer>) q.peek(); 
		q.poll(); 
		int last = path.get(path.size() - 1); 

		// if last vertex is the desired destination 
		// then print the path 
		if (last == dst) 
			printpath(path);		 

		// traverse to all the nodes connected to 
		// current vertex and push new path to queue 
		for (int i = 0; i < g.get(last).size(); i++) { 
			int x = g.get(last).get(i);
			if (isNotVisited(x, path)) { 
				ArrayList<Integer> newpath= new ArrayList<>(path); 
				newpath.add(g.get(last).get(i)); 
				q.add(newpath); 
			} 
		} 
	} 
} 
 
} 
