package Graph;
// geeksforgeeks.org/minimum-number-of-edges-between-two-vertices-of-a-graph/
import java.util.*;

public class countNodesbetV {
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
        int sn = s.nextInt();
        int en = s.nextInt();
        bfs(sn,en);
    }
  static  void  addEdge(int sv , int ev)
    {
        adj[sv].add(ev);
        adj[ev].add(sv);
    }
  
  static void bfs(int sn,int en)
    {
        boolean visited[]=new boolean[adj.length];
        for(int i =0 ; i< adj.length; i++)
        {
            if(!visited[i])
            {
                bfsH(adj,sn,en,visited);
            }
        }
    }
  static void bfsH( LinkedList<Integer> adj[],int sn,int en, boolean visited[])
  {
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(sn);
      visited[sn]=true;
      int value[] = new int[adj.length]; 
    //   value[sn]=1+value[sn];
    Arrays.fill(value, 1);
      while(!q.isEmpty())
      {
          sn= q.poll();
          
        //   System.out.print(i + " ");
          Iterator<Integer> it = adj[sn].listIterator();
          while(it.hasNext())
          {
            int n = it.next(); 
            if (!visited[n]) 
            { 
                value[n]  =1+value[sn]; 
                visited[n] = true; 
                q.add(n); 
            } 
          }
      }
      for(int i =0 ;i < adj.length;i++)
      {
          if(value[en]==i)
          {
              System.out.println(value[en]);
          }
      }

    }  
}

// 6
// 4
// 1 2
// 1 3
// 4 5 
// 3 4
// 1
// 5