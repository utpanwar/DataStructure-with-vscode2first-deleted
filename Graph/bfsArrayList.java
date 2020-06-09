package Graph;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner;

public class bfsArrayList {
    public static void main(String args[])
    {
       Scanner s = new Scanner(System.in);
       int v=s.nextInt();
       int e=s.nextInt();
       int edges[][]=new int[v][v];
       for(int i = 0; i<edges.length;i++)
       {
    	   int sv=s.nextInt();
    	   int ev=s.nextInt();
    	   edges[sv][ev]=1;
    	   edges[ev][sv]=1;
       }
       print(edges,0);
    }
    public static void print(int edges[][],int sv)
    {
    	boolean visited[]=new boolean[edges.length];
    	Queue<Integer> q = new LinkedList<>(); 
    	q.add(0); 	
    	for(int i = 0;i<edges.length;i++)
    	{
    		printHelper(edges, i, visited,q);
    	}
    }
  public static void printHelper(int edges[][],int sv,boolean[] visited, Queue<Integer> q)
    {
    	
//    	q.add(sv);
    	if(!q.isEmpty())
    	{
    		int element = q.remove();
        	System.out.println(element);
        	visited[element]=true;
    	}
    	
//    	int element = q.remove();
    	for(int i = 0; i < edges.length;i++)
    	{
    		if(edges[sv][i]==1 && !visited[i])
    		{
    			q.add(i);
    		}
    	}
    	for(int i = 0 ; i < edges.length;i++)
    	{
    		if(edges[sv][i]==1 && !visited[i])
    		{
    			printHelper(edges,i,visited,q);    	
    		}
    	}
    }
}




// 5
// 5
// 0 1
// 0 2
// 1 3
// 3 4
// 2 4