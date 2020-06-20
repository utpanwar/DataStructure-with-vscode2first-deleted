// detech cycle
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#ExpectOP
// this soln fails on s
// //29 4
// //6 21 17 12 2 11 9 11
it gives TLE error
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] = new boolean[V];
        boolean a=true;
        for(int i = 0; i< V;i++)
        {
            if(!visited[i])
            a= a & isCyclicH(adj,visited,i);
        }
        return !a;
    }
    
    static boolean isCyclicH(ArrayList<ArrayList<Integer>> adj, boolean visited[],int src)
    {
        if(visited[src])
          return false;
          
        visited[src]=true;
        
        for(int i = 0 ; i < adj.get(src).size(); i++)
        {
            if(!isCyclicH(adj,visited,adj.get(src).get(i)))
				return false;
        }
       return true;
    }
}





