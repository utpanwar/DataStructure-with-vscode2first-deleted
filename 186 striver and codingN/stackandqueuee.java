1.                                      NEXT GREATE RELEMEENTG
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        if(nums2.length == 0) return nums2;
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(nums2[0]);
        int i = 0;
        
        while(i < nums2.length)
        {
            if(nums2[i] > st.peek())
            {
                while(st.size()!=0 && st.peek() < nums2[i] )
                {
                    hm.put(st.pop(),nums2[i]);
                }
                st.push(nums2[i]);
            }
            else
                st.push(nums2[i]);
            i++;
        }
        
        int j =0;
        while(j < nums1.length)
        {
            if(hm.containsKey(nums1[j]))
            {
                nums1[j] = hm.get(nums1[j]);
            }
            else
            {
                nums1[j] = -1;
            }
            j++;
        }
        return nums1;
    }
}

1.B
best approach
class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] numbers) {
        
        HashMap<Integer,Integer>  poss =  new HashMap<Integer,Integer>();
        int[] res =  new int[findNums.length];
        
        for( int i = 0; i< numbers.length; i++){
            poss.put(numbers[i], i);
        }
        
        
        for( int i = 0; i< findNums.length; i++){
            res[i] = -1 ; 
                
            for(int j=poss.get(findNums[i]); j < numbers.length; j++ ){
               
                if( findNums[i] < numbers[j]  ){
                    res[i] = numbers[j] ;  
                    break;
                }
                
            }
        }

        return res ; 
    }
}

2.                                      NGE 2
THIS SOLUTION IS MINE IT CAN not pass -ive test cases
class Solution {
    public int[] nextGreaterElements(int[] nums)
    {
        if(nums.length == 0) return nums;
        
        // HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> s = new Stack<>();
        // Queue<Integer> q = new LinkedList<Integer>();
        int res[] = new int[nums.length];
        Arrays.fill(res,-1);
        // st.push(0);
        int i = 0;
        
        while(i < nums.length)
        {
            if( st.size()!= 0 && nums[st.peek()] < nums[i] )
            {
                while(st.size()!=0 && nums[st.peek()] < nums[i] )
                {
                   int tmp = st.pop();
                   s.push(tmp);
                   if(res[tmp] == -1 ) res[tmp] = nums[i];
                }
                if(s.size()!= 0)
                {
                    while(s.size()!=0)
                    {
                        st.push(s.pop());
                    }
                }
                st.push(i);
            }
            else
                st.push(i);
            i++;
        }
        
        for(int j =0 ; j < nums.length; j++)
        {
            int tmp = st.pop();
            if(res[tmp] == -1)
            {
                int k = 0;
                while(k<nums.length)
                {
                    if(nums[k] > nums[tmp])
                    {
                        res[tmp] = nums[k];
                        break;
                    }
                    k++;
                }
            }
        }
        return res;
        
//         int j =0;
//         int ele = st.pop();
//         int tmp = 1000000;
//         while(st.size()!=0)
//         {
//             int tmp1 = st.pop();
//             if(nums[tmp1] > nums[ele])
//             {
//                 tmp = tmp1;
//             }
//             j++;
//         }
//         if(tmp != 1000000) res[res.length-1] = nums[tmp];
        
    }
}









