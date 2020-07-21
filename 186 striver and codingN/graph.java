                                    NOTES
 1.GRAPH - in the conected component of graph there will be always (v-1) 
 edges
 2.IN DIRECTED GRAPH -and max number of edge in graph is v(v-1)  
 3. IN UNDIRECTED GRAPH v(v-1) /  2 ; beacause single edge work as a two edegs in DIRECTED gr                                                                   
                      
 
 * we can implements garaph with 3 type of approach
 1. Edges class wala array
    space - O(E^2) if(complete)
 2.adjeceny MATRIX
    space - (E^2)
 3.adjeceny list
  space - O(e+v);   


                                    IMPLENTATIONS  

1.A                                  MATRIX

public static void main(String [] args)
{
    Scanner s = new Scanner(System.in);
    int V = s.nextInt();
    int E = s.nextInt();
    int edge[]][] = new int[V][V];
    for(int i = 0; i<edges.length(row);i++)
       {
    	   int sv=s.nextInt();
    	   int ev=s.nextInt();
    	   edges[sv][ev]=1;
    	   edges[ev][sv]=1;
       }

}











