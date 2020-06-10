package Graph;
// https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
import java.util.*;

public class countNumOfTrees {
   static Scanner s = new Scanner(System.in);
   static LinkedList<Integer> adj[];
    public static <E> void O(E a)
     {
         System.out.println(a);
     }

    public static <E> void Om(E a)
     {
         System.out.println(a);
     }

    public static  int I()
     {
         int a=s.nextInt();
         return a;
     }
     
     public static void main( String args[])
     {
         int V = I();
         int E = I();
          adj=new LinkedList[V];
         for(int i=0;i<V;i++)
         {
             adj[i]= new LinkedList<>();
         }
         for(int i =0 ;i<E;i++)
         {
             int sv=I();
             int ev=I();
             addEdge(sv,ev);
         }
         O(countTrees(0));
     }
     static void addEdge(int sv,int ev)
     {
        adj[sv].add(ev);
     }
     static int countTrees(int sv)
     {
         int res= 0;
         boolean visited[] = new boolean[adj.length];
         for(int i =0 ;i < sv ; i++)
         {
             if(!visited[i])
             {
                 dfsH(i ,visited);
             }
         }
        return  res;
     }
     static void dfsH(int i ,boolean visited[])
     {
        visited[i] = true; 
		
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[i].listIterator(); 
		while (it.hasNext()) 
		{ 
			int n = it.next(); 
			if (!visited[n]) 
			{ 
				dfsH(n,visited); 
			} 
		} 
     }
}
// 7
// 0 1
// 0 2
// 1 3
// 1 4 
// 1 5
// 2 6
// 2