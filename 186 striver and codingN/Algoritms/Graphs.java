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

hakerearth-https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
import java.util.*;

class TestClass {
    
    public static void main(String args[] )  {
    Scanner s = new Scanner(System.in);
    int V = s.nextInt();
    int E = s.nextInt();
    Edge arr[] = new Edge[E];
    for(int  i=0 ; i< E ; i++)
    {
    	arr[i] = new Edge();
        arr[i].src = s.nextInt();
        arr[i].dst = s.nextInt();
        arr[i].wei = s.nextInt();
    }
     Edge output[] = krushkal(arr,V);
     int sum = 0;
     for(int i = 0 ; i<V-1;i++)
     {
         sum  = sum + output[i].wei;
        //  if(tmp.src < tmp.dst)
        //  {
        //      System.out.println(tmp.src+ " "+tmp.dst);
        //  }
        //  else
        
     }
      System.out.println(sum);
    }
    public static int find(int i ,int parent [])
    {
        if(parent[i] == i ) return i;
        return find(parent[i],parent);
    }
    public static Edge [] krushkal(Edge arr[] , int V)
    {
        Edge output[] = new Edge[V - 1];
        int parent[] = new int[V+1];
        for(int i= 0 ;i < V ;i++)
        {
            parent[i] = i ;
        }
        Arrays.sort(arr);
        int count= 0 ;
        int  i=0 ;
        while(count < V -1)
        {
            Edge tmp = arr[i];
            int srcP = find(tmp.src,parent);
            int dstP = find(tmp.dst,parent);
            if(srcP != dstP)
            {
                output[count] = tmp;
                count++;
                parent[srcP] = dstP;
            }
            i++;
        }
        return output;
    }
}

class Edge  implements  Comparable<Edge>
    {
        int src ; 
        int dst ; 
        int wei;
        public int compareTo(Edge o){
        return this.wei - o.wei; }
    }


//4 



2                               KRUSKAL ALGO BY UNION FIND ALGO


time complexity - 
for sort the array -ElogE
for cycle detetion for (n-1) eddges = O(E*logV)
total = ElogE + ElogV; in best
edeges can be E^2 or E = v^2 in worst case
total = v2logV2 + v^2LogV^2 = ElogE or ElogV  in worst
https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/


3.                              PRIMS  ALGORITHM

