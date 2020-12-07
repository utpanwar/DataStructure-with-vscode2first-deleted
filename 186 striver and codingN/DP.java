186 sttiver and cn


2.                              EGG DROPPING PROBLEM


public class Solution {
    
    public int solve(int n, int k) {
    
        int m[][] = new int[n+1][k+1];
        for(int i =0; i<m.length;i++)
        {
            for(int j= 0; j<m[0].length;j++)
            {
                m[i][j] = -1;
            }
        }
        return helper(n,k,m);
    } 
    public int helper(int n , int k , int m[][])
    {
        
    
        if (k == 1 || k == 0) 
        {
            m[n][k] = k;
            return m[n][k]; 
//             return k;
        }

        // We need k trials for one egg 
        // and k floors 
        if (n == 1) 
        {
            m[n][k] = k;
            return m[n][k];
//             return k; 
        }
        
        if(m[n][k]!=-1)
        {
            return m[n][k];
        }
        
        int min = Integer.MAX_VALUE; 
//         int  res; 

        // Consider all droppings from 
        // 1st floor to kth floor and 
        // return the minimum of these 
        // values plus 1. 
        for (int x = 1; x <= k; x++) { 
            int res = 1+Math.max(helper(n - 1, x - 1,m), 
                        helper(n, k - x,m)); 
            if (res < min) 
                min = res; 
        } 
        m[n][k] = min;
        return m[n][k];
    }
}

3.                                      LOOT HOUSE
RECURSIVE
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return rob(n,0,nums);
    }
    public int rob(int n , int i,int nums[])
    {
        if(n<=i) return 0;
        if(n-1==i) return nums[i];
        int op1 = nums[i]+rob(n,i+2,nums);
        int op2 = nums[i+1]+rob(n,i+3,nums);
        return Math.max(op1,op2);
    }
}



3.dp

import java.util.*;
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int dp[] = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2; i<n;i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[n-1];
    }
    // public int rob(int n , int i,int nums[])
    // {
    //     if(n<=i) return 0;
    //     if(n-1==i) return nums[i];
    //     int op1 = nums[i]+rob(n,i+2,nums);
    //     int op2 = nums[i+1]+rob(n,i+3,nums);
    //     return Math.max(op1,op2);
    // }
}


4.                                      LIS
POOR DP APPROX dp
class Solution {
    public int lengthOfLIS(int[] arr) {
         int n = arr.length;
        if(n==1) return 1;
        if(n==0) return 0;
        int dp[] = new int[n+1];
        dp[0] = 1;
        if(arr[1]>arr[0]) 
        	dp[1] = 2;
        else
        	dp[1] =1;
        for(int i =2 ; i<n;i++)
        {
        	int j = 0;int max =-1;
        	int count =0;
        	while(j<=i)
        	{
        		if(arr[i] > arr[j] )
        		{
        			if(max < dp[j])
        			{
        				max = dp[j];
        				count++;
        			}
        			  
        		} 
        		else if(i==j && count==0)
        			dp[j] =1;
        		j++;
        	}
        	if(count>0) dp[i] = 1+max;
        }
        Arrays.sort(dp);
        return dp[n];
    }
}


4.b
recursive
https://www.youtube.com/watch?v=SHFyIAnjj90


4.c
    
public class Solution {

    static int max_ref;
  public static int lis(int arr[]) {
      int n=arr.length;
      int lis[] = new int[n]; 
        int i,j,max = 0; 

        /* Initialize LIS values for all indexes */
         for ( i = 0; i < n; i++ ) 
            lis[i] = 1; 

         /* Compute optimized LIS values in bottom up manner */
         for ( i = 1; i < n; i++ ) 
            for ( j = 0; j < i; j++ )  
                       if ( arr[i] > arr[j] && lis[i] < lis[j] + 1) 
                  lis[i] = lis[j] + 1; 

         /* Pick maximum of all LIS values */
         for ( i = 0; i < n; i++ ) 
            if ( max < lis[i] ) 
               max = lis[i]; 

          return max; 
 }
}






5.                                  LCS
recurssive
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
        int n = text1.length();
        int m = text2.length();
        
        int storage[][] = new int[n+1][m+1];
        for(int i =0 ; i< n;i++)
        {
            for(int j=0;j<m;j++)
            {
                storage[n][m] = -1;
            }
        }
        
        return longestCommonSubsequence(storage,text1,text2);
    }
    public int longestCommonSubsequence(int storage[][] ,String text1, String text2)
    {
         int n = text1.length();
        int m = text2.length();
        if(storage[n][m] !=-1)
        {
            return storage[n][m];
        }
           if(text1.length() == 0 || text2.length() == 0)
           {
               storage[n][m] = 0;
               return storage[n][m];
           }
            // return 0;
        
        if(text1.charAt(0)==text2.charAt(0))
        {
            
    storage[n][m]=1 + longestCommonSubsequence(text1.substring(1),text2.substring(1));
            return storage[n][m];
        }
        else
        {
            int op1 = longestCommonSubsequence(text1.substring(1),text2.substring(1));
            int op2 = longestCommonSubsequence(text1,text2.substring(1));
            int op3 = longestCommonSubsequence(text1.substring(1),text2);
            
                storage[n][m] = Math.max(op1,Math.max(op2,op3));
            return storage[n][m];
        }
    }
}

5.b
dp sol



6.                              0 1 KNAPSACK
recursive
public class Solution {
	
    static int max(int a, int b) { return (a > b)? a : b; } 
	public static int knapsack(int wt[], int val[],int W,   int n){
	
        // Base Case 
    if (n == 0 || W == 0) 
        return 0; 
       
    // If weight of the nth item is more than Knapsack capacity W, then 
    // this item cannot be included in the optimal solution 
    if (wt[n-1] > W) 
       return knapsack( wt, val,W, n-1); 
       
    // Return the maximum of two cases:  
    // (1) nth item included  
    // (2) not included 
    else return max( val[n-1] + knapsack( wt, val,W-wt[n-1], n-1), 
                     knapsack( wt, val,W, n-1) 
                      ); 
	}
}

7.                             EDIT DISTANCE
reursive
                     // very finne soln of cn
class Solution {
	public static int editDistance(String s1, String s2){		
	    if(s1.length()==0 )
	    	return s2.length();
	    	if(s2.length()==0)
	    	   return s1.length();
	    if(s1.charAt(0)==s2.charAt(0))
	    {
	       return editDistance(s1.substring(1),s2.substring(1));
	    }
	    else
	    {   //delete
	       
   			int op1 = editDistance(s1,s2.substring(1));

                 //insert
	        int op2=editDistance(s1.substring(1),s2);
	    	
	    	  //substitute
	    	int op3=editDistance(s1.substring(1),s2.substring(1));
	    	
	     return 1+Math.min(op1, Math.min(op2,op3));
	    }
	}  
}

7..b
dp sol
public static int editDistance(String s1 ,String s2 )
{
    int m =s1.length();
    int n =s2.length();
    int arr[][] =new int[m+1][n+1];
    for(int j=0;j<=s2.length();j++)
    {
        arr[0][j]=j;
    }
    for(int i=0;i<=s1.length();i++)
    {
        arr[i][0]=i;
    }
    for(int i=1;i<=m;i++)
    {
        for(int j=1;j<=n;j++)
        {   // this is mine forward table compare string from first
            // if(s1.charAt(i-1)==s2.charAt(j-1))
            if(s1.charAt(m-i)==s2.charAt(n-j))
            { //this cn compare string from last
                arr[i][j]= arr[i-1][j-1];
            }
            else
            {
                arr[i][j] = 1+ Math.min(arr[i][j-1], Math.min(arr[i-1][j], arr[i-1][j-1]));
            }
        }
    }
    return arr[m][n];
}
}



8.                              MATRIX SUM  INCRESING Subsequence

9.                              MCM
dp sol

public class Solution {

	
	public static int mcm(int[] p){

        /* For simplicity of the program, one extra row and one 
        extra column are allocated in m[][].  0th row and 0th 
        column of m[][] are not used */
        int n=p.length;
        int m[][] = new int[n][n]; 
  
        int i, j, k, L, q; 
  
        /* m[i,j] = Minimum number of scalar multiplications needed 
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where 
        dimension of A[i] is p[i-1] x p[i] */
  
        // cost is zero when multiplying one matrix. 
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
        // L is chain length. 
        for (L=2; L<n; L++) 
        { 
            for (i=1; i<n-L+1; i++) 
            { 
                j = i+L-1; 
                if(j == n) continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k=i; k<=j-1; k++) 
                { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n-1]; 

	}
}


10.                                 COIN CHANGE
recursive
// Recursive java program for 
// coin change problem. 
import java.io.*; 

class GFG { 
	
	// Returns the count of ways we can 
	// sum S[0...m-1] coins to get sum n 
	static int count( int S[], int m, int n ) 
	{ 
		// If n is 0 then there is 1 solution 
		// (do not include any coin) 
		if (n == 0) 
			return 1; 
		
		// If n is less than 0 then no 
		// solution exists 
		if (n < 0) 
			return 0; 
	
		// If there are no coins and n 
		// is greater than 0, then no 
		// solution exist 
		if (m <=0 && n >= 1) 
			return 0; 
	
		// count is sum of solutions (i) 
		// including S[m-1] (ii) excluding S[m-1] 
		return count( S, m - 1, n ) + 
			count( S, m, n-S[m-1] ); 
	} 
	
	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
		int arr[] = {1, 2, 3}; 
		int m = arr.length; 
		System.out.println( count(arr, m, 4)); 
		
		
	} 

} 

// This article is contributed by vt_m. 


11.                         SUBSET SUM
// Java program to print the count of 
// subsets with sum equal to the given value X 
import java.util.*; 

class GFG 
{ 

// Recursive function to return the count 
// of subsets with sum equal to the given value 
static int subsetSum(int arr[], int n, int i, 
					int sum, int count) 
{ 
	// The recursion is stopped at N-th level 
	// where all the subsets of the given array 
	// have been checked 
	if (i == n) 
	{ 

		// Incrementing the count if sum is 
		// equal to 0 and returning the count 
		if (sum == 0) 
		{ 
			count++; 
		} 
		return count; 
	} 

	// Recursively calling the function for two cases 
	// Either the element can be counted in the subset 
	// If the element is counted, then the remaining sum 
	// to be checked is sum - the selected element 
	// If the element is not included, then the remaining sum 
	// to be checked is the total sum 
	count = subsetSum(arr, n, i + 1, sum - arr[i], count); 
	count = subsetSum(arr, n, i + 1, sum, count); 
	return count; 
} 

// Driver code 
public static void main(String[] args) 
{ 
	int arr[] = { 1, 2, 3, 4, 5 }; 
	int sum = 10; 
	int n = arr.length; 

	System.out.print(subsetSum(arr, n, 0, sum, 0)); 
} 
} 

// This code is contributed by 29AjayKumar 

12.                             PALIMDROME PARTITIONING
print number of partionining
class Solution{
    static int palindromicPartition(String str)
    {
        if(str.length() == 0) return 0;
        if(checkP(str)) return 0;
        return palindromicPartitionH(str);
    }
    static int palindromicPartitionH(String s)
    {
        if(s.length() == 0) return 0;
        if(checkP(s)) return 0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i <s.length(); i++)
        {
            if(checkP(s.substring(0,i+1)))
            {
                 min = Math.min(min, 1 + palindromicPartitionH(s.substring(i+1)) );
            }
           
        }
        return min;
    }
    
    static boolean checkP(String s)
    {
        int i = 0;int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j) )
            {
                return false;
            }
            i++;j--;
        }
        return true;
    }
}


