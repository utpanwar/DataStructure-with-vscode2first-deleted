package 186 striver and codingN;

public class Hashing {
    

1.                           TWO sum

import java.util.*;
import java.io.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++)
        {
            hm.put(nums[i],i);
        }
        // int res [] = new int[2];
        for(int i = 0; i<nums.length; i++)
        {
            int a = target - nums[i];
            if(hm.containsKey(a) &&  hm.get(a) != i)
            {
                // res[0] = i;
                // res[1] = hm.get(a);
                return new int[] { i, hm.get(a) };
            }
        }
        // return res;
         throw new IllegalArgumentException("No two sum solution");
    }
}
1.B
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
}


3.                                      LCS
Hashing
naive sol
class Solution {
    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}

3.b
Hashing
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num = new HashSet<Integer>();
        for (int i : nums)
        {
            num.add(i);
        }
        int count = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(!num.contains(nums[i] - 1))
            {
                int tcount = 1;
                while(num.contains(nums[i]+tcount)) tcount++;
                if(count < tcount) count = tcount;
            }
            
        }
        return count;
    }
}


3.c
union and find
https://leetcode.com/problems/longest-consecutive-
sequence/discuss/947055/Java-O(N)-Union-Find-%2B-thought-process


4.                          LONGEST SUM TO 0

class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum =0 ;
        int len = 0;
        for(int i =0 ; i < n; i++)
        {
            sum +=arr[i];
            int max = 0;
            if(sum == 0) len = i+1;
            else {
            if(hm.containsKey(sum))
            {
                max = i - hm.get(sum);
            }
            else
            {
                hm.put(sum,i);
            } }
            if(len < max ) len = max;
        }
        return len;
    }
}



6.                             LENGTH OF LONGEST SUBSTRING
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
         if(s.length() == 1) return 1;
        char [] c = s.toCharArray();
        int len = 0;
        for(int i =0; i<c.length; i++)
        {
           for(int j = i+1; j<=c.length; j++)
           {
               if(isUnique(s.substring(i,j)))
               {
                   len  = Math.max(len , (j-i));
               }
           }
        }
        return len;
    }
    
     public boolean isUnique(String s)
     {
         for(int i =0; i<s.length(); i++)
         {
            for(int j = i+1; j<s.length(); j++)
            {
               if(s.charAt(i) == s.charAt(j))
               {
                   return false;
               }
             }
          }
         return true;
     }
 }


 6.B

 class Solution {
    public int lengthOfLongestSubstring(String s) {
               if(s.length() == 0) return 0;
	         if(s.length() == 1) return 1;
	        char [] c = s.toCharArray();
	        Set<Character> hm = new HashSet<>();
	        int len = 0;
	        int i = 0;
	        int j = 0; int n = s.length();
	        while(i < n && j < n)
	        {
	            if(!hm.contains(c[j]))
	            {
	                hm.add(c[j]);
	                len = Math.max(len, (j - i+1));
	                j++;
	            }
	            else
	            {
	                while(hm.contains(c[j]))
	                {
	                    hm.remove(c[i]);
	                    i++;
	                }
	                len = Math.max(len, (j - i+1));
	                hm.add(c[j++]); 
                }
	        }
	        return len;
	    }
}


6.C
leetcode has same code see beauty of code
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}