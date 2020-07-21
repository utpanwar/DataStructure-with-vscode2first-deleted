package 186 striver and codingN.graph;

public class algosofgraph {
    
}

1.                                  KRUSHKAL ALGO
time complexity - 
for sort the array -ElogE
for cycle detetion for (n-1) eddges = O(E*V)
total = ElogE + EV;
edeges can be E^2 or E = v^2 in worst case
total = v2logV2 + v^2 * v  



it is used for finding minimum spanning tree
implementiing this through Edge list or array

class Edge implements Comparable<Edge>
{
    int src ;
    int dst;
    int wei;
    public int compareTo(){
        return this.wei - o.wei;
    }
   
}

public static void main(String args[])
{
   Scanner s =  new Scanner(System.in);
   int V = s.nextInt();
   int E = s.nextInt();
   Edge arr = new Edge();
   for(int i = 0;i<E;i++)
   {
       arr[i] = new Edge();
        arr[i].src= s.nextInt();
        arr[i].dst= s.nextInt();
        arr[i].wei= s.nextInt();
    }
     kruskal(arr,V);
}
public static void findEdge(int v, int parent[])
{
    if(parent[v]==v)
     return v;
   
    return findEdge(parent[v],parent);
}
public static void kruskal(Edge arr , int V)
{
   Arrays.sort(arr);
   Edge output = new  Edge[n-1];
   int parent = new int[V];
   for(int i =0;i < V ; i++)
   {
       parent[i] = i;
   }
   int i = 0;
   int count = 0;
   while(count<=n-1)
   {
       int currentEdge = input[i];
       int srcParent = findparent(currentEdge.src ,parent);
       int dstParent = findparent(currentEdge.dst ,parent);
       if(scrParent ! = dstParent)
       {
           output[count] = curentEdge;
           count++;
           parent[srcParent] = desParent;  // it is union here
       }


   }
}



2                               KRUSKAL ALGO BY UNION FIND ALGO


time complexity - 
for sort the array -ElogE
for cycle detetion for (n-1) eddges = O(E*logV)
total = ElogE + ElogV; in best
edeges can be E^2 or E = v^2 in worst case
total = v2logV2 + v^2LogV^2 = ElogE or ElogV  in worst
https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/


3.                              PRIMS  ALGORITHM

