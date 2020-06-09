package Graph;

import java.util.*;

public class bfsBylist {
    static  LinkedList<Integer> adj[];
    public static void main(String args [])
    {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        adj = new  LinkedList[V];
        for(int i = 0 ; i< V ; i++)
        {
            adj[i]= new LinkedList<>();
        }  
        for(int i=0;i<E;i++)
        {
            int sv= s.nextInt();
            int ev= s.nextInt();
            addEdge(sv,ev);
        }
        bfs(V);
    }
  static  void  addEdge(int sv , int ev)
    {
        adj[sv].add(ev);
    }
  
  static void bfs(int V)
    {
        boolean visited[]=new boolean[V];
        for(int i =0 ; i< V; i++)
        {
            if(!visited[i])
            {
                bfsH(adj,i,visited);
            }
        }
    }
  static void bfsH( LinkedList<Integer> adj[],int i , boolean visited[])
  {
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(i);
      while(!q.isEmpty())
      {
          i= q.poll();
          System.out.print(i + " ");
          Iterator<Integer> it = adj[i].listIterator();
          while(it.hasNext())
          {
            int n = it.next(); 
            if (!visited[n]) 
            { 
                visited[n] = true; 
                q.add(n); 
            } 
          }
      }
  }  
}
// test case
// 5
// 5
// 0 1
// 0 2
// 1 3
// 3 4
// 2 4