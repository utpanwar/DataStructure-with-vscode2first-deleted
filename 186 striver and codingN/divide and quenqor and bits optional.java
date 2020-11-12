import java.lang.reflect.Array;

divide and quenqor

1.                            FIND SINGLE ELEMENT INT DUPLICATES ARRARY IN NLOGN
https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/
class Solution {
    public int singleNonDuplicate(int[] a)
    {
        int n = a.length;
        if(n==1) return a[0];
         if(a[0]!= a[1] )
             return a[0];
         if(a[n-1]!= a[n-2] )
            return a[n-1];
        return binarsearch(a);
    }

    
    public int binarsearch(int a[])
    {
        int mid  = (a.length) / 2;
        int low = 0;
        int high = a.length;
        while(low <= high)
        {
            mid = low + (high - low) /2;
            
            if(a[mid-1]!= a[mid] && a[mid + 1]!= a[mid] )
              return a[mid];
            if(mid%2 == 0)
             {
                 if(a[mid + 1] == a[mid])
                   low = mid + 1;
                 else
                   high = mid -1;
             }
             else if(mid%2 !=0)
             {
                 if(a[mid - 1] == a[mid])
                     low = mid + 1;
                else
                    high = mid - 1;
             }
        }
                 
        return -1;
}
}


2.                       find the rotated index in rotated array
https://practice.geeksforgeeks.org/problems/rotation4723/1#
int findKRotation(int a[], int n)
{
    // int n = a.length;
    if(n==1) return 0;
    if(a[0] < a[n-1]) return 0;
    return binarsearch(a,n);
}


public int binarsearch(int a[] , int n)
{
    // int mid  = (n-1) / 2;
    int mid = n >>1;
    int low = 0;
    int high = n-1;
    int prev = 0 , next = 0;
    while(low <= high)
    {
        mid = low + high >> 1;
        prev = a[(mid + n - 1) % n];
        next =  a[(mid+1) % n];
        
        if(prev > a[mid] && a[mid] < next )
          return mid;
          
        else if(a[0] <= a[mid])
         {
            low = mid + 1;
         }
         else 
         {
             high = mid - 1;
         }
    }
             
    return -1;
}

3.                              SEARCH A ELEMENT IN THE ROTAted Array
DO YOUSELF AGAIN
/* Java program to search an element in 
sorted and rotated array using 
single pass of Binary Search*/

class Main { 
	// Returns index of key in arr[l..h] 
	// if key is present, otherwise returns -1 
	static int search(int arr[], int l, int h, int key) 
	{ 
		if (l > h) 
			return -1; 

		int mid = (l + h) / 2; 
		if (arr[mid] == key) 
			return mid; 

		/* If arr[l...mid] first subarray is sorted */
		if (arr[l] <= arr[mid]) { 
			/* As this subarray is sorted, we 
			can quickly check if key lies in 
			half or other half */
			if (key >= arr[l] && key <= arr[mid]) 
				return search(arr, l, mid - 1, key); 
			/*If key not lies in first half subarray, 
		Divide other half into two subarrays, 
		such that we can quickly check if key lies 
		in other half */
			return search(arr, mid + 1, h, key); 
		} 

		/* If arr[l..mid] first subarray is not sorted, 
		then arr[mid... h] must be sorted subarry*/
		if (key >= arr[mid] && key <= arr[h]) 
			return search(arr, mid + 1, h, key); 

		return search(arr, l, mid - 1, key); 
	} 

	// main function 
	public static void main(String args[]) 
	{ 
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 }; 
		int n = arr.length; 
		int key = 6; 
		int i = search(arr, 0, n - 1, key); 
		if (i != -1) 
			System.out.println("Index: " + i); 
		else
			System.out.println("Key not found"); 
	} 
} 
]


4.                  MEDIAN OF TWO SORTED ARRAY (SAME SIZE )

class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2)
    {
        int n = a1.length;
        int m = a2.length;
        if(n == 1 && m == 1)
        {
            double res = (a1[0] + a2[0]) / 2.0;
            return res;
        }
        return  findMedianSortedArraysH(a1,a2,0,n-1,0,m-1);
    }
    public double findMedianSortedArraysH(int a[] ,int b[] , int a1 ,int a2 , 
                                          int b1 ,int b2 )
    {
        
        if( (a2 - a1) == 1 &&  (b2 - b1) == 1 )
        {
              double res = (Math.max(a[a1] ,b[b1]) + Math.min(a[a2] , b[b2])) / 2.0;
            return res;
        }
        int start = (a2 + a1) / 2;
        int end  =  (b1 + b2) / 2;
        int m1 = a[start];
	    int m2 = b[end];
        if(m1 == m2 ) return m1;
        if(m1 < m2)
        {
            return findMedianSortedArraysH(a,b,start, a2 , b1 ,end);
        }
        else
        {
            return findMedianSortedArraysH(a,b,a1, start ,end ,b2);
        }
    }
}

5.                      MEDIAN OF TWO SORTED ARRAY (DIFFERENT SIZE())
https://leetcode.com/problems/median-of-two-sorted-arrays/
see also leetcode solution

VERY IMPORTANT QUESTION
https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/?ref=lbp
















