package 186 striver and codingN;

1.                      LONGEST COMMON PREFIX SUFFIX

https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1#
class Solution {
    int lps(String s) {
        int l = s.length();
        int a [] = new int[l];
        a[0] = 0;
        // for(int i = 1; i<l; i++)
        int i = 1;
        int j = 0;
        while(i < l)
        {
            // for(int j = 0; j<i; j++)
            // {
                if(s.charAt(i) == s.charAt(j))
                 {
                     a[i] = j + 1;
                     j++;
                     i++;
                 }
                 else
                 {
                     if(j!=0)
                     {
                         j = a[j-1];
                     }
                     else
                     {
                         a[i] = j;
                         i++;
                     }
                 }
            // }
        }
        // Arrays.sort(a);
        return  a[l-1];
    }
}


2.          NUMBER OF CHARACTER SHOULD BE ADDED IN BEGINING TO MAKE STR IS PALINDROME
https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
// Java program for getting minimum character to be 
// added at front to make string palindrome 

class GFG { 

    // function for checking string is palindrome or not 
        static boolean ispalindrome(String s) { 
            int l = s.length(); 
    
            for (int i = 0, j = l - 1; i <= j; i++, j--) { 
                if (s.charAt(i) != s.charAt(j)) { 
                    return false; 
                } 
            } 
            return true; 
        } 
    
    // Driver code 
        public static void main(String[] args) { 
            String s = "BABABAA"; 
            int cnt = 0; 
            int flag = 0; 
    
            while (s.length() > 0) { 
                // if string becomes palindrome then break 
                if (ispalindrome(s)) { 
                    flag = 1; 
                    break; 
                } else { 
                    cnt++; 
    
                    // erase the last element of the string 
                    s = s.substring(0, s.length() - 1); 
                    //s.erase(s.begin() + s.length() - 1); 
                } 
            } 
    
            // print the number of insertion at front 
            if (flag == 1) { 
                System.out.println(cnt); 
            } 
        } 
    } 



2.b
by kmp algo
// Java program for getting minimum character to be 
// added at front to make string palindrome 
import java.util.*; 
class GFG 
{ 

// returns vector lps for given string str 
public static int[] computeLPSArray(String str) 
{ 
	int n = str.length(); 
	int lps[] = new int[n]; 
	int i = 1, len = 0; 
	lps[0] = 0; // lps[0] is always 0 
	
	while (i < n) 
	{ 
		if (str.charAt(i) == str.charAt(len)) 
		{ 
			len++; 
			lps[i] = len; 
			i++; 
		} 
		else
		{ 
			// This is tricky. Consider the example. 
			// AAACAAAA and i = 7. The idea is similar 
			// to search step. 
			if (len != 0) 
			{ 
				len = lps[len - 1]; 
				
				// Also, note that we do not increment 
				// i here 
			} 
			else
			{ 
				lps[i] = 0; 
				i++; 
			} 
		} 
	} 
	return lps; 
} 

// Method returns minimum character to be added at 
// front to make string palindrome 
static int getMinCharToAddedToMakeStringPalin(String str) 
{ 
	StringBuilder s = new StringBuilder(); 
	s.append(str); 
	
	// Get concatenation of string, special character 
	// and reverse string 
	String rev = s.reverse().toString(); 
	s.reverse().append("$").append(rev); 
	
	// Get LPS array of this concatenated string 
	int lps[] = computeLPSArray(s.toString()); 
	return str.length() - lps[s.length() - 1]; 
} 

// Driver Code 
public static void main(String args[]) 
{ 
	String str = "AACECAAAA"; 
	System.out.println(getMinCharToAddedToMakeStringPalin(str)); 
} 
} 

// This code is contributed by Sparsh Singhal 




3.                          CHECK FOR ANAGRAMS
// Java program to check if two strings
// are anagrams of each other
class GFG{

    static int NO_OF_CHARS = 256;
    
    // function to check if two strings
    // are anagrams of each other
    static boolean areAnagram(char[] str1, 
                            char[] str2)
    {
        
        // Create a count array and initialize
        // all values as 0
        int[] count = new int[NO_OF_CHARS];
        int i;
    
        // For each character in input strings,
        // increment count in the corresponding 
        // count array
        for(i = 0; i < str1.length; i++) 
        {
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }
    
        // If both strings are of different 
        // length. Removing this condition 
        // will make the program fail for
        // strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;
    
        // See if there is any non-zero 
        // value in count array
        for(i = 0; i < NO_OF_CHARS; i++)
            if (count[i] != 0) 
            {
                return false;
            }
        return true;
    }
    
    // Driver code
    public static void main(String[] args)
    {
        char str1[] = "geeksforgeeks".toCharArray();
        char str2[] = "forgeeksgeeks".toCharArray();
    
        // Function call
        if (areAnagram(str1, str2))
            System.out.print("The two strings are " +
                            "anagram of each other");
        else
            System.out.print("The two strings are " +
                            "not anagram of each other");
    }
    }
    
    // This code is contributed by mark_85
    


 3.b
 hashing sum
 // Java program to check if two strings
// are anagrams of each other
class GFG{

    static boolean isAnagram(String c, String d)
    {
        if (c.length() != d.length())
            return false;
            
        int count = 0;
    
        // Take sum of all characters of
        // first String
        for(int i = 0; i < c.length(); i++)
        {
            count = count + c.charAt(i);
        }
    
        // Subtract the Value of all the characters
        // of second String
        for(int i = 0; i < d.length(); i++)
        {
            count = count - d.charAt(i);
        }
    
        // If Count = 0 then they are anagram
        // If count > 0 or count < 0 then 
        // they are not anagram
        return (count == 0);
    }
    
    // Driver code
    public static void main(String[] args)
    {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";
    
        // Function call
        if (isAnagram(str1, str2))
            System.out.print("The two strings are " + 
                            "anagram of each other");
        else
            System.out.print("The two strings are not " + 
                            "anagram of each other");
    }
    }
    
    // This code is contributed by mark_85
   3.c
    with the hasing if the element of seacond string enter in hash table return false
    
    

 4.                             COUNT AND SAY
 https://leetcode.com/problems/count-and-say/submissions/
class Solution {
    public String countAndSay(int n) {
       if (n<=0) {
            return null;
        }
        String result="1";
        int j=1;
        while(j++<n){
        StringBuilder sb = new StringBuilder();
        int count=1;
        for(int i=1; i<result.length(); i++){
            if(result.charAt(i)==result.charAt(i-1)){
                count++;
            }else{
               sb.append(count);
                sb.append(result.charAt(i-1));
                count=1;
            }
        }
            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            result = sb.toString();
        }
        return result;
    }
}   


5.                              COMPARE TEO VERSIONS NUMBERS
public int compareVersion(String v1, String v2) {
    int var1 = 0 ,var2 = 0;
   for(int i = 0 , j = 0; i <v1.length() || j< v2.length(); i++ ,j++ )
   {
      
       while(i < v1.length() && v1.charAt(i)!= '.')
       {
           var1 = var1*10 + (v1.charAt(i) - '0');
               i++;
       }
        while(j < v2.length() && v2.charAt(j)!= '.')
       {
           var2 = var2*10 + (v2.charAt(j) - '0');
               j++;
       }
       if(var1 < var2) return -1;
       else if(var1 > var2) return 1;
       var1 = var2 = 0;
       
   }
    return 0;
}


5.b
public int compareVersion(String a, String b) {
    for (int i = 0, j = 0, m, n; i < a.length() || j < b.length(); i++, j++) {
        m = n = 0;
        while (i < a.length() && a.charAt(i) != '.') m = m * 10 + a.charAt(i++) - '0';
        while (j < b.length() && b.charAt(j) != '.') n = n * 10 + b.charAt(j++) - '0';
        if (m > n) return 1;
        if (m < n) return -1;
    }
    return 0;
}



6.                      REVERSE A WORD INA STRING
do once yourself
// Java program to reverse a string
// s = input()
public class ReverseWords 
{

	public static void main(String[] args)
	{
		String s[] = "i like this program very much".
										split(" ");
		String ans = "";
		for (int i = s.length - 1; i >= 0; i--) 
		{
			ans += s[i] + " ";
		}
		System.out.println("Reversed String:");
		System.out.println(ans.substring(0, 
								ans.length() - 1));
	}
}

6.B                         LONGEST PALINDROME STRING 
VERY IMPORTATNT QNS IT IS HALF DO ON LEETCODE AND GFG
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        int i1 = 0; int j1 = 0;
        int j2 = 0;int i2 =0;
         int max = -5;
        int dp [][] = new int[l][l];
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j<=i+1; j++)
            {
                if(i == j)
                {
                     dp[i][j] = 1;
                     i1 = i; 
                     j1 = j;
                     if( (j1 -i1) > max )
                     {
                         i2 = i; 
                         j2 = j;
                         max = j2 -i2;
                     }
                        
                }
                   
                else if(j!=s.length() && s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = 1;
                     i1 = i; 
                     j1 = j;
                    if( (j1 -i1) > max )
                     {
                         i2 = i; 
                         j2 = j;
                         max = j2 -i2;
                     }
                    // System.out.println(max+" "+i2+" "+j2);
                }
            }
        }
         // System.out.println(max+" "+i2+" "+j2);
        
        // System.out.println(max+" "+i1+" "+j1);
        for(int j = 2; j<s.length(); j++)
        {
                for(int i =0; i<s.length()-2; i++)
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        if(dp[i+1][j-1] == 1)
                        {
                            dp[i][j] = 1;
                             i1 = i; 
                             j1 = j;
                             if( (j1 -i1) > max )
                             {
                                 i2 = i1; 
                                 j2 = j1;
                                 max = j2 -i2;
                                 System.out.println(max+" "+i1+" "+j1);
                             }
                        }
                            
                    }
                    // j++;
                }
        }
       
//         int index = -1;
//        for(int i = 0; i < s.length(); i++)
//         {
//            if(dp[i][s.length()-1] >max)
//            {
//                max = dp[i][s.length()-1];
//                index = i;
//            }
               
//         }
        // System.out.println(i2+" "+j2);
        return s.substring(i2,j2+1);
    }
}



7.                                      MAKE AOTIE
WRONG
class Solution {
    THIS IS WRONG
    public int myAtoi(String s) {
        int v = 0;
        for(int i = 0; i< s.length(); i++)
        {
            int tmp  = (s.charAt(i) - '0');
            System.out.println(tmp);
           if(tmp == -16)
               continue;
            if(tmp < 0 && tmp!= -16)
            {
                // v = (v*10) + tmp;
            }
            else if(tmp == -16)
                return v;
            else if(tmp > 9)
                return 0;
            
             v = (v*10) + tmp; 
        }
        return v;
    }
}

SAHI
sahi


class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }
}



