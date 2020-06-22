package Graph;
// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
import java.util.ArrayList;
import java.util.Scanner;

public class DetechCycleinDirectedGraph {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	       int v = s.nextInt();	
	       int e = s.nextInt();	
	       ArrayList<ArrayList<Integer>> arr = 
	    		   new ArrayList<ArrayList<Integer>>();
	       for(int i =0 ; i < v; i++)
	       {
	    	   arr.add(new ArrayList<Integer>());
	       }
	       for(int i =0 ;i < e; i++)
	       {
	    	    int sv = s.nextInt();
	    	    int ev = s.nextInt();
	    	    addEdge(arr,sv,ev);
	       }
//	       ArrayList<Integer> m=new ArrayList<Integer>();
	       boolean visited[]= new boolean[v];
	       boolean a =true;
	       for(int i= 0 ; i < v;i++)
	       {
               if(!visited[i])	    	   
	    	   a=a & !dfs(arr,visited,i,i);
	       }
	       System.out.print(a);
	}
	static void addEdge(ArrayList<ArrayList<Integer>> arr,int sv ,int ev)
    {
    	arr.get(sv).add(ev);
//    	arr.get(ev).add(sv);
    }
	
	static boolean dfs(ArrayList<ArrayList<Integer>> arr,boolean visited[],int src,int prev)
	{
		if(prev!=src)
		{
			visited[prev]=true;
		}
		if(visited[src] && visited[prev])
		{
			return false;
		}
		
		for(int i= 0 ; i < arr.get(src).size();i++)
		{
			if(!dfs(arr,visited,arr.get(src).get(i),src))
			{
//				visited[src]=true;
				return false;
			}
			
		}
		return true;
	}
}

//4
//6
//0 1
//0 2
//1 2
//2 0
//2 3
//3 3

//failss this sol
//29 4
//6 21 17 12 2 11 9 11
