import sun.awt.AWTAccessor.InvocationEventAccessor;

package 186 striver and codingN;

public class Arrays {
    
1.                                  find dup;InvocationEventAccessor


import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        HashMap<Integer , Integer > m = new HashMap<>();
        for(int i =0 ;i <nums.length; i++)
        {
            if(m.containsKey(nums[i]))
            {
               return  nums[i];
            }
           else m.put(nums[i] , i); 
        }  
              return 0;
    }
      
}

1.b
sorting 
import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =0 ;i <nums.length; i++)
        {
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return nums[0];
    }
}


1.c

import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
 
      int slow = nums[0];
      int fast = nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
}
}





2                                   FIND MAX REPEATING NUMBER


package string;

//Java program to find the maximum repeating number 
import java.io.*; 

public class MaxRepeating { 

	// Returns maximum repeating element in arr[0..n-1]. 
	// The array elements are in range from 0 to k-1 
	static int maxRepeating(int arr[], int n, int k) 
	{ 
		// Iterate though input array, for every element 
		// arr[i], increment arr[arr[i]%k] by k 
		for (int i = 0; i< n; i++) 
		{
			int a = (arr[i]%k);
			arr[a] = arr[a] + k; 
		}

		// Find index of the maximum repeating element 
		int max = arr[0], result = 0; 
		for (int i = 1; i < n; i++) 
		{ 
			if (arr[i] > max) 
			{ 
				max = arr[i]; 
				result = i; 
			} 
		} 

		/* Uncomment this code to get the original array back 
		for (int i = 0; i< n; i++) 
		arr[i] = arr[i]%k; */

		// Return index of the maximum element 
		return result; 
	} 

	/*Driver function to check for above function*/
	public static void main (String[] args) 
	{ 

		int arr[] = {2, 3, 3, 5, 3, 4, 1, 7}; 
		int n = arr.length; 
		int k=8; 
		System.out.println("Maximum repeating element is: " + 
						maxRepeating(arr,n,k)); 
	} 
} 
/* This code is contributed by Devesh Agrawal */

}


4.                                  SORT 0 1 2 

class Solution {
    public void sortColors(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a[a.length-1];
        for(int i =0 ; i<(a.length-1);i++)
        {
            if(a[low] ==0 && a[mid]==0)
            {
                low++;
                mid++;
            }
            else if(a[low]==1 && a[mid] ==1)
            {
                mid++;
            }
            else if(a[low] > a[mid])
            {
               int tmp = a[low];
               a[low] = a[mid];
                a[mid] = tmp;
                mid++;
            }
            if(a[mid] == 2)
            {
                int tmp = a[mid];
                a[mid] = a[high];
                a[high] = tmp;
                high--;
            }
        }
    }
}

4.b
correct upper is wrong
class Solution {
    public void sortColors(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length-1;
       while(mid <= high)
        {
            if(a[mid]==0)
            {
                 int tmp = a[low];
                 a[low] = a[mid];
                 a[mid] = tmp;
                 low++;
                 mid++;
            }
            else if(a[mid] ==1)
            {
                mid++;
            }
//             else if(a[low] > a[mid])
//             {
              
//                 mid++;
//             }
            // if(a[mid] == 2)
           else
            {
                int tmp = a[mid];
                a[mid] = a[high];
                a[high] = tmp;
                high--;
            }
        }
    }
}

5.                  FIND THE MISSING AND REAPTING

follow up methods
sorting 
freq array
sum and product wala logic
xor
5.c
  




6.                              MERGE TWO SORTED Arrays

 2 ms
 o(N*M)
N IS traversing of a1 and m is ordering of a2
import java.util.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        if(n == 0 && m ==0) return;
         if(m == 0 || n==0)
        {
            if(m == 0)
            {
                for(int i = 0 ; i<n; i++)
                {
                    nums1[i] = nums2[i];
                }
            }
          // else
          //   {
          //       for(int i = 0 ; i<m; i++)
          //       {
          //           nums2[i] = nums1[i];
          //       }
          //   } 
             return;
        }
        
        for(int i =0 ; i< m; i++)
        {
            if(nums1[i] > nums2[j])
            {
                int tmp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = tmp;
                // System.out.print(nums1[i]+" ");
                Arrays.sort(nums2);
            }
            // else System.out.print(nums1[i]+" ");
        }
        // for(int a : nums2)
        //     System.out.print(a+" ");
       
        for(int i =m; i<m+n; i++)
        {
            nums1[i] = nums2[i-m];
        }
    }
    
}

6. c
0 ms
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i<n; i++){         // We choose these
            nums1[nums1.length - 1 - i] = nums2[i];  //working backwards, 
        }
        Arrays.sort(nums1); //the order does n
    }
}


6.B gap method




7.                              MERGE TWO INTERVALS
LEETCODE
package string;
import java.util.*;
public class IntervalPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int intervals [][] = {{1,3} ,{2,6},{8,10},{15,18}};
     int a[][] = Solu.merge(intervals);
     for(int i[] : a)
     {
    	 System.out.println(i);
     }
	}

}
class Solu {
    public static int[][] merge(int[][] intervals) {
       
        ArrayList<int[]> res = new ArrayList<int[]>();
        if(intervals.length==0 || intervals == null)
            return res.toArray(new int[0][]);
         Arrays.sort(intervals , (a,b)-> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int [] i : intervals)
        {
            if(i[0] <= end)
            {
                end = Math.max(end,i[1]);
            }
            else
            {
                res.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}

8.                          MAKE MATRIX ZERO
https://leetcode.com/problems/set-matrix-zeroes/submissions/
8.A. IF matrix have only positive elements
O(n*m)+O(n+m)+O(1)
bruteforce
class Solution {
    public void setZeroes(int[][] m) {
        for(int i =0 ; i<m.length; i++)
        {
            for(int j = 0; j<m[0].length; j++)
            {
                if(m[i][j] == 0)
                {
                    for( int k = 0; k < m.length; k++)
                    {
                        if(m[k][j] != 0)
                           m[k][j] = -1; 
                    }
                    for(int k = 0; k< m[0].length;k++)
                    {
                        if(m[i][k] != 0)
                           m[i][k] = -1; 
                    }
                }
            }
        }
         for(int i =0 ; i<m.length; i++)
        {
            for(int j = 0; j<m[0].length; j++)
            {
              if(m[i][j] == -1)
                  m[i][j] = 0;
            }
         }        
    }
}
8.b
it passes all the test cases
O(n*m + n*m)+O(n)+O(m)
two corresponding arrays
class Solution {
    public void setZeroes(int[][] m) {
        int a[] = new int[m.length];
        int b[] = new int[m[0].length];
        Arrays.fill(a,-1);
        Arrays.fill(b,-1);
        for(int i =0 ; i<m.length; i++)
        {
            for(int j = 0; j<m[0].length; j++)
            {
                if(m[i][j] == 0)
                {
                    a[i] = 0;
                    b[j] = 0;
                }
            }
        }
         for(int i =0 ; i<m.length; i++)
         {
             
                if(a[i] == 0)
                {
                    for( int k = 0; k < m[0].length; k++)
                    {
                        if(m[i][k] != 0)
                           m[i][k] = 0; 
                    }
                }
         }  
             for(int j = 0; j<m[0].length; j++)
              {
                 if(b[j] == 0)
                 {
                     for(int k = 0; k< m.length;k++)
                    {
                        if(m[k][j] != 0)
                           m[k][j] = 0; 
                    }
                 }
              }  
        
     }
}


8c. variation of 8a
O(m*n) + O(m*n+ n+m)
class Solution {
    static int max = 999999;
    public void setZeroes(int[][] arr) {
    
    for(int i=0 ; i<arr.length ; i++)
       for(int j=0; j<arr[0].length ; j++)
         {
             // if any node containing 0 , we iterate respective row and column's
			 // and modify all nodes which contain value >0
             if(arr[i][j]==0)  
                 changeTheArray(arr , i , j);
         }
     
    // change all  the max to  0 , for final result
     for(int i=0 ; i<arr.length ; i++)
       for(int j=0; j<arr[0].length ; j++)
           if(arr[i][j]==max) arr[i][j]=0;
}

static void changeTheArray(int[][] arr, int i, int j)
{
   
       //change all the row elemnts to max , except which containing 0
       for(int x=0 ; x<arr[0].length ; x++)
       {
           if(arr[i][x]==0) continue;
           arr[i][x]=max;
       }

        //change all the col elemnts to max , except which containing 0
       for(int x=0 ; x<arr.length ; x++)
       {
           if(arr[x][j]==0) continue;
           arr[x][j]=max;
       }
   
 }
}

8 d.
2. O(n*m + m*m) + O(1)
  inside make the tmp array
class Solution {
    public void setZeroes(int[][] m) {
        boolean col = true;
        // int a[] = new int[m.length];
        // int b[] = new int[m[0].length];
        // Arrays.fill(a,-1);
        // Arrays.fill(b,-1);
        for(int i =0 ; i<m.length; i++)
        {
             if(m[i][0] == 0) col = false;
            for(int j = 1; j<m[0].length; j++)
            {
               
                if(m[i][j] == 0)
                {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }
        
        for(int i =m.length-1 ; i>=0; i--)
         {
           for( int j = m[0].length-1; j>=1 ; j--)
            {
                if(m[i][0] == 0 || m[0][j] ==0)
                    m[i][j] = 0; 
            }
            if(col==false) m[i][0] = 0;
         }
        
            
        // System.out.print(col);
     }


Q.                          PASCAL TRIANGLE
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
          List<Integer> ans ,pre = null ;
        for(int i = 0 ; i< numRows; i++)
        {
            ans = new LinkedList<>();
            // ans.add(1);
            for(int j = 0; j <=i; j++)
            {
                // int a = 
                if(j == 0 || j== i)
                    ans.add(1);
                else ans.add(pre.get(j-1) + pre.get(j));
            }
            // ans.add(1);
            pre = ans;
            res.add(ans);
        }
        return res;
    }
}


9.                          NEXT PERMUTATION

package debug;
import java.util.*;
public class Nextpermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int a[] = new int[l];
		for(int i =0 ; i<l; i++)
		{
			a[i] = s.nextInt();
		}
		Solm.nextPermutation(a);
	}

}


 class Solm {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

10.                               INVERSIONS OF ARRAY
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
// 		int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int a [] = new int[n];
            for(int i = 0 ;i < n;i++)
            {
                a[i] = s.nextInt();
            }
            System.out.println(mergem(a));
        }
	}
	public static int mergem(int  a[])
	{
	    int tmp[] = new int[a.length];
	    return mergeS(a,tmp,0,a.length-1);
	}
	public static int mergeS(int  a[],int tmp[] , int low ,int high)
	{
	   
	   int mid = 0;
	   int count = 0;
	   if(low<high)
	   {
	   //   mid = high >> 1;
	      mid = (low + high) / 2;
	      count += mergeS(a,tmp,0,mid);
	      count += mergeS(a,tmp,mid+1,high);
	      count += merge(a,tmp,low,mid,high);
	   }
	   return count;
	}
	public static int merge(int [] a,int [] tmp,int low,int mid,int high)
	{
	    int count = 0;
	    int i = low;
	    int j = mid+1;
	    int k = low;
	    while(i <= mid && j <= high)
	    {
	        if(a[i] <= a[j])
	           tmp[k++] = a[i++];
	       else
	       {
	            tmp[k++] = a[j++];
	            count +=(mid - i);
	       }
	         
	    }
	    while(i <= mid -1)
	    {
	        tmp[k++] = a[i++];
	    }
	    while( j<= high)
	    {
	        tmp[k++] = a[j++];
	    }
	    for(int m = low ;m <=high ; m++)
	    {
	        a[m] = tmp[m];
	    }
	    return count;
	}
}

11.                             STOCK BUY AND SELL
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        int min = 100000000;
        int i =0;
        while(i<prices.length)
        {
            if(prices[i] < min)
            {
                min = prices[i];
            }
            if((prices[i] - min) > 0 && p < (prices[i] - min))
                  p = prices[i] - min;
            i++;
        }
        return p;
    }
}


12.                             SEARCH IN A MATRIX
using bs in each row
https://leetcode.com/problems/search-a-2d-matrix/submissions/
class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        for(int i =0; i<m.length; i++)
        {
            if(binarys(m,t,i))
                return true;
        }
        return false;
    }
    
    public boolean binarys(int arr [][] , int x, int i )
    {
        int l = 0, r = arr[0].length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[i][m] == x) 
                return true; 
  
            // If x greater, ignore left half 
            if (arr[i][m] < x) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return false; 
    }
}

12.b
using piontre from last element of first row
class Solution {
    public boolean searchMatrix(int[][] ma, int t) {
        int n = ma.length; 
        if(n ==0 ) return false;
        int m = ma[0].length;
        int i = 0;
        int j = m-1;
        while(i <n && j>=0)
        {
            if(ma[i][j] == t)
                return true;
            if(ma[i][j] > t)
                j--;
            else
                i++;
        }
        return false;
    }
}


12.
using binary search in whole matrix
class Solution {
    public boolean searchMatrix(int[][] ma, int t) {
        int  n = ma.length;
        if(n==0) return false;
        int k = ma[0].length;
        int l = 0 ;
        int h = (n*k) -1;
        // int r = ma[0].length ; 
        
        while (l <= h)
        { 
            int m = (l + (h - l) / 2); 
            if (ma[m/k][m % k] == t) 
                return true; 
  
            if (ma[m/k][m%k] < t) 
                l = m + 1; 
            else
                h = m - 1; 
        } 

        return false; 
     
    }

}

13.                         MAJORITY ELEMENT IN A ARRAY
it is moore algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ele = 0;
        for(int i =0 ; i< nums.length; i++)
        {
            if(cnt == 0)
            {
                ele = nums[i];
            }
            if(ele == nums[i])
                cnt++;
            else
                cnt--;
        }
        return ele;
    }
}




14.                             GET UNIQUE GRIDS
class Solution {
    public int uniquePaths(int m, int n) {
        int mat[][] = new int[m][n];
        int res = uniquePathsH(mat ,0,0);
        return res;
    }
    public int uniquePathsH(int mat[][], int i , int j)
    {
        if(i>mat.length-1 || j>mat[0].length-1) 
	            return 0;
	        if(i == mat.length-1 && j == mat[0].length-1)
	            return 1;
	        int a = uniquePathsH(mat,i,j+1);
	        int b = uniquePathsH(mat,i+1,j);
	        return  a+b; 
    }
}

dp
class Solution {
    public static int uniquePaths(int m, int n) {
             int mat[][] = new int[m][n];
             for(int i =0 ;i<mat.length;i++)
             {
                 for(int j =0 ;j < n; j++)
                 {
                     mat[i][j]= -1;
                 }
             }
             for(int i =n-1; i>=0; i--)
             {
                 mat[m-1][i] = 1;
             }
             for(int i =m-1; i>=0; i--)
             {
                 mat[i][n-1] = 1;
             }
             int res = uniquePathsH(mat ,0,0);
             return res;
         }
         public static int uniquePathsH(int mat[][], int i , int j)
         {
 //	        if(i>mat.length-1 || j>mat[0].length-1) 
 //	            return 0;
 //	        if(i == mat.length-1 && j == mat[0].length-1)
 //	            return 1;
             int m = mat.length;
             int n = mat[0].length;
             for( i = m-2; i>=0;i--)
             {
                 for( j =n-2; j>=0; j--)
                 {
                     mat[i][j] = mat[i+1][j] + mat[i][j+1];
                 }
             }
             return  mat[0][0]; 
         }
 }