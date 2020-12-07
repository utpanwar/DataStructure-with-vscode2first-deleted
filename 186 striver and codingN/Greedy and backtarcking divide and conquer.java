 GREEDY
 https://leetcode.com/wayne1116/ solve this man problem
1.                            N MEETING IN ONE ROOM 






2.                          ACTIVITY SELECTION PROBLEM
public static void printMaxActivities(int s[], int f[], int n) 
    { 
    int i, j; 
       
    System.out.print("Following activities are selected : n"); 
       
    // The first activity always gets selected 
    i = 0; 
    System.out.print(i+" "); 
       
    // Consider rest of the activities 
    for (j = 1; j < n; j++) 
    { 
         // If this activity has start time greater than or 
         // equal to the finish time of previously selected 
         // activity, then select it 
         if (s[j] >= f[i]) 
         { 
              System.out.print(j+" "); 
              i = j; 
          } 
     } 
    } 



3.                                          FIND MINIMUM NUMBER OF COINS
static void findMin(int V) 
    { 
        // Initialize result  
        Vector<Integer> ans = new Vector<>(); 
  
        // Traverse through all denomination  
        for (int i = n - 1; i >= 0; i--) 
        { 
            // Find denominations  
            while (V >= deno[i])  
            { 
                V -= deno[i]; 
                ans.add(deno[i]); 
            } 
        } 
  
        // Print result  
        for (int i = 0; i < ans.size(); i++) 
        { 
            System.out.print( 
                " " + ans.elementAt(i)); 
        } 
    }  
    
    


 BACKTRACKING
 
 1.                                 N QUUEN PROBLEM
optimising remains and solve leetcode also
https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
 /*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int p;
	public static void main (String[] args) throws Exception{
        // BufferedReader br =  new  BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        int  t = s.nextInt();
        // String s []  = br.readLine().split(" ");
        // int t = Integer.valueOf(s[0]);
        int  i = 1;
        while(t-->0)
        {
            // String name [] = br.readLine();
            // int n = Integer.valueOf(s[i++]);
            int n = s.nextInt();
            p = 0;
            int board[][] = new int[n][n];
            boolean f = solveNq(board,0,n);
            if(p==0)  System.out.print(-1);
            System.out.println();
        }
        
	}   
    public static boolean solveNq(int board[][], int i, int n)
    {
        if(i==n)
        {   p =1;
            System.out.print("[");
            for(int x = 0; x<n; x++)
            {
                for(int j =0 ; j < n; j++)
                {
                    if(board[x][j] == 1 )
                     {
                         System.out.print(j+1 +" ");
                        //  t =1;
                     }
                    //  else
                    //   System.out.print("_ ");
                }
                // System.out.println();
            }
            System.out.print("] ");
            // if(t == 0)  
            return false;
        }
        for(int j = 0; j<n; j++)
        {
            if(isQueen(board,i,j,n))
            {
                board[i][j] = 1; 
                boolean q = solveNq(board,i+1,n);
                if(q) return true;
                 board[i][j] = 0;
            }
           
        } 
        return false;
    }
    
    public static boolean isQueen(int [][] board, int i ,int j,int n)
    {
        for(int x = i-1 ; x>=0; x--)
        {
            if(board[x][j] == 1 )
               return false;
        }
        
        int x = i ;
        int y = j;
        while(x>=0 && y<n)
        {
            if(board[x][y] == 1)
             return false;
            x--;
            y++;
        }
        
        int m = i ;
        int k = j;
        while(m>=0 && k>=0)
        {
            if(board[m][k] == 1)
               return false;
            m--;
            k--;
        }
        return true;
    }
    
  
}


2.                              RAT IN A MAZE
class GfG {
    static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> printPath(int[][] m, int n)
    {
         String ans= "";
         res.clear();
	        boolean f =  printPathH(m,0,0,n,ans);
	        
	        ArrayList<String> re = new ArrayList<>();
	        re.clear();
	        for(String s : res)
	        {
	        	re.add(s);
	        }
	        return re;
    }
    
    public static boolean printPathH(int[][] m, int i ,int j, int n,String ans)
    {
        if(m[i][j] == 0) return false;
          if(m.length-1 == i && m[0].length-1 == j)
	         {   res.add(ans);
	            return false; }
	        
	        for(int g = 0; g<4; g++)
	        {
	            if(g==0)
	            {  
	                if( (i-1) >=0 )
	                { if(m[i-1][j]!=-1) {
	                    if(m[i-1][j] != 0)
	                    {   m[i][j] = -1;
	                        ans = ans + 'U' + ""; 
	                        if(printPathH(m,i-1,j,n,ans))
	                          return true;
	                        ans = ans.substring(0, ans.length() - 1); m[i][j] = 1;
	                    }}
	                }
	            }
	            
	            if(1 == g)
	            {
	                // leftward
	                if( (j-1) >=0 )
	                {   if(m[i][j-1]!=-1) {
	                    if(m[i][j-1] != 0)
	                    {  m[i][j] = -1;
	                        ans = ans + 'L' + "";
	                        if(printPathH(m,i,j-1,n,ans))
	                          return true;
	                        ans = ans.substring(0, ans.length() - 1); m[i][j] = 1;
	                    }}
	                }
	            }
	            
	            if(g == 2)
	            {
	                // Downward
	                if( (i+1) < n)
	                {    if(m[i+1][j]!=-1) {
	                    if(m[i+1][j] != 0)
	                    {   m[i][j] = -1;
	                        ans = ans + 'D' + "";
	                        if(printPathH(m,i+1,j,n,ans))
	                          return true;
	                        ans = ans.substring(0, ans.length() - 1); m[i][j] = 1;
	                    }}
	                }
	            }
	            
	            if(g == 3)
	            {
	                if( (j+1) < m[0].length )
	                {  if(m[i][j+1]!=-1) {
	                    if(m[i][j+1] != 0)
	                    {  m[i][j] = -1;
	                        ans = ans + 'R' + "";
	                        if(printPathH(m,i,j+1,n,ans))
	                          return true;
	                        ans = ans.substring(0, ans.length() - 1); m[i][j] = 1;
	                    }}
	                }
	            }
	        }  
	        return false;
    }
    
}

3.                             WORD BREAK 
https://leetcode.com/problems/word-break-ii/discuss/958294/DFS-with-Memoization-Code
these are others solutions see them also
my  recursive solution
class Solution {
    List<String> res = new LinkedList<>();
    String j = "";
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> h = new HashSet<>();
        for(String m : wordDict)
        {
            h.add(m);
        }String ans = "";
        wordBreakH(s,ans,h);
        return res;
    } 
    public void  wordBreakH(String s ,String ans, HashSet<String> h)
    {
          if(s.length() == 0)
          {
              ans = ans.substring(0,ans.length()-1);
              res.add(ans);
              return;
          }
            for(int i =0 ; i<s.length(); i++)
            {
                String left = s.substring(0,i+1);
                if(h.contains(left))
                {
                    // j = j + left+" ";
                    String right = s.substring(i+1);
                    wordBreakH(right , ans+left+" ", h);
                    // if(j.length()!=0)
                    // {
                    //     j = j.substring(0,j.length()-1);
                    //     res.add(0,j);
                    // }    
                    // j = "";
                }
            }
        }
    }