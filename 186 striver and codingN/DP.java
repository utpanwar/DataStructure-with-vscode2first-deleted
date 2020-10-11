186 sttiver and cn

1.                          LCS
TIME - 2^N

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        
        if(text1.charAt(0)==text2.charAt(0))
        {
            return 1 + longestCommonSubsequence(text1.substring(1),text2.substring(1));
        }
        else
        {
            int op1 = longestCommonSubsequence(text1.substring(1),text2.substring(1));
            int op2 = longestCommonSubsequence(text1,text2.substring(1));
            int op3 = longestCommonSubsequence(text1.substring(1),text2);
            return Math.max(op3,op2);
        }
        
    }
}


1.b
Memoization



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



dp

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