// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/bfs/?layout=old
//count number of nodes on a aperticular level

package Graph;

import java.util.*;

public class CountNodes {
    public static void main(String args[] ) throws Exception {
        Scanner s  = new Scanner(System.in);
        int v = s.nextInt();
   //      int e  = v;
        ArrayList<ArrayList<Integer>>  arr = 
          new ArrayList<ArrayList<Integer>>();
          for(int i =0 ; i < v; i++)
          {
                  arr.add(new ArrayList<Integer>());
          }
          int sv1 = s.nextInt()-1;
          int ev1 = s.nextInt()-1;   
          addEdge(arr,sv1,ev1);
        for(int i =0 ;i <v-2; i++)
        {
           int sv = s.nextInt()-1;
           int ev = s.nextInt()-1;   
           addEdge(arr,sv,ev); 
        }       
       int x = s.nextInt();
       Queue<Integer> q = new LinkedList<>();
       boolean visited[] = new boolean[v+1];
       bfsLevelNodes(arr,q,x,sv1,visited);
       }
       static void addEdge ( ArrayList<ArrayList<Integer>>  arr  ,int u,int v)
        {
                arr.get(u).add(v);
                arr.get(v).add(u);
        }
      
      static void bfsLevelNodes(ArrayList<ArrayList<Integer>>  arr,
      Queue<Integer> q , int x , int sv,boolean visited[])
      {
             q.add(0);
             visited[0]= true;
             int value[] = new int[arr.size()];
             value[0]=1;
             while(!q.isEmpty())
             {
                 sv = q.poll();
                for(int i =0 ; i < arr.get(sv).size();i++)
                {
                   if(!visited[arr.get(sv).get(i)])
                   {
                     q.add(arr.get(sv).get(i));
                     value[arr.get(sv).get(i)]  =1+value[sv]; 
                     visited[arr.get(sv).get(i)] = true;
                   }
                }
   
             }
             int count  =0;
             for(int i = 0; i<value.length;i++)
             {
                     if(value[i]==x)
                     {
                             count++;
                     }
             }
        System.out.print(count); 
      }
   }
   
   
   
   
   
   //20
   //11 1
   //1 2
   //13 3
   //15 4
   //17 5
   //11 6
   //2 7
   //1 8
   //15 9
   //4 10
   //15 12
   //5 13
   //2 14
   //17 15
   //15 16
   //11 17
   //15 18
   //9 19
   //16 20
   //2
   
   //6
   //0 2
   //0 1
   //2 6
   //1 3
   //1 4
   //1 5
   //2
   
   
   //5
   //1 2
   //1 3
   //4 5 
   //3 4