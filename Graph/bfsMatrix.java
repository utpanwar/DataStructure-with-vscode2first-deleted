package Graph;
//  this is not handle the dissconnected Graph
import java.util.*;

public class bfsMatrix {
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int v =s.nextInt();
        int e =s.nextInt();
        int edges[][] = new int[v][v];
        for(int i = 0; i<e;i++)
        {
            int sv=s.nextInt();
            int ev=s.nextInt();
            edges[sv][ev]=1;
            edges[ev][sv]=1;
        }
        print(edges, 0);
    }

    public static void print(int edges[][],int sv)
    {
        boolean visited[] = new boolean[edges[0].length];
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        while(!q.isEmpty())
        {
            int q1 = q.poll();
            visited[q1]=true;
            System.out.println(q1);
            for(int i =0;i<edges.length;i++)
            {
                if(edges[q1][i]==1 && !visited[i])
                {
                    q.add(i);
                }
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

// 4
// 4
// 0 1
// 0 2
// 1 3
// 1 4
