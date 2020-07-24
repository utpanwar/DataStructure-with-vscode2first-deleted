package 186 striver and codingN.graph;

public class algosofgraph {
    
}
                                    NOTE
very important for discoonected graph this convential krushkal does not works
beacuse ek edge kaam padege so while wali condition chalegi toh jab edgee input
array se access karege toh element hoga hi nahi
so always rember array waale codes hamesha problem karte so arralist preffere kara karo 
array ki jagah better null handeling hoti hai  learn from mr president
qns hakerrank                                                                      


1.                                  KRUSHKAL ALGO
time complexity - 
for sort the array -ElogE
for cycle detetion for (n-1) eddges = O(E*V)
total = ElogE + EV;
edeges can be E^2 or E = v^2 in worst case
total = v2logV2 + v^2 * v  
+


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
        int parent[] = new int[V];
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



2                               KRUSKAL ALGO BY UNION FIND ALGO AND RANK 


time complexity - 
for sort the array -ElogE
for cycle detetion for (n-1) eddges = O(E*logV)
total = ElogE + ElogV; in best
edeges can be E^2 or E = v^2 in worst case
total = v2logV2 + v^2LogV^2 = ElogE or ElogV  in worst
https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/


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
        arr[i].src = s.nextInt()-1;
        arr[i].dst = s.nextInt()-1;
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
    public static int find(int i ,subset subsets [])
    {
        if(subsets[i].parent != i ) 
        {
            subsets[i].parent = find(subsets[i].parent,subsets);
        }
        return subsets[i].parent;
    }
    static void Union(subset subsets[], int x, int y) 
    { 
        int xroot = find( x,subsets); 
        int yroot = find( y,subsets); 
  
        // Attach smaller rank tree under root of high rank tree 
        // (Union by Rank) 
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
  
        // If ranks are same, then make one as root and increment 
        // its rank by one 
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    } 
    public static Edge [] krushkal(Edge arr[] , int V)
    {
        Edge output[] = new Edge[V - 1];
        subset subsets[] = new subset[V];
        for(int i= 0 ;i < V ;i++)
        {
            subsets[i] = new subset();
            subsets[i].parent = i ;
            subsets[i].rank = 0;
        }
        Arrays.sort(arr);
        int count =0 ,i=0;
        while(count < V -1)
        {
            Edge tmp = arr[i];
            int x = find(arr[i].src , subsets);
            int y = find(arr[i].dst , subsets);

            if(x != y)
            {
                output[count] = tmp;
                count++;
                Union(subsets,x,y);
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
class subset
{
    int parent ;
    int rank;
}









3.                              PRIMS  ALGORITHM

