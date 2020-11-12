import java.util.Stack;
import java.util.concurrent.RecursiveAction;

import javax.xml.crypto.NodeSetData;

import org.graalvm.compiler.loop.InductionVariable.Direction;

package 186 striver and codingN;

public class LinkedList {
    


1.                              COUNT NODES IN LinkedList

recursive
public class Solution {

	public static int length(LinkedListNode<Integer> head){
		if(head == null) return 0;
        return 1+length(head.next);
	}
}

ITERATIVE
public static int length(LinkedListNode<Integer> head){
    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Return output and don't print it.
      * Taking input and printing output is handled automatically.
    */
    int count=0;
    while(head!=null)
    {
        count++;
        head=head.next;
    }
    return count;
}


2.                                  Print ith Node

public class Solution {
    // This is in practice mode firdt sol is prev solution
     public static void printIthNode(LinkedListNode<Integer> head, int i){
         int count = 0;
         while(head!=null)
         {
             if(count==i)
             {
                 System.out.println(head.data);
             }
             head=head.next;
             count++;
         }
             
     }
 }

 3.                                DELETE ITH NODE

 public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
    if(head == null) return head;
    
    LinkedListNode<Integer> prev = head;
    LinkedListNode<Integer> curr = null;
    if(head.next!=null)  curr = head.next;
    if(pos==0) return head.next;
    if(pos==1) return head.next.next;
    while(pos-->=1 && curr!=null)
    {
        prev = curr;
        curr = curr.next;
        if(curr == null) return head;
        if(pos == 1)
        {
            prev.next = prev.next.next;
            curr.next=null;
        }
        // pos--;
    }
    return head;
}


CN SOL


public class Solution {

	public static LinkedListNode<Integer> deleteIthNode(LinkedListNode<Integer> head, int pos){
	        int i=0;
        LinkedListNode<Integer> temp1=head;
        LinkedListNode<Integer> temp=head;
         int j=0;
        while(temp1!=null)
        {
            temp1=temp1.next;
            j++;
        }
        if(i==pos)
        {
            head=head.next;
            return head;
        }
        if(pos+1>j)
        {
            return head;
        }
//          if(j==pos)
//          {
//              int m=0;
//              while(m<pos)
//              {
//                 temp1=temp.next;
//                  m++;
//              }
             
//          }
        
        while(i<pos-1)
        {
            temp=temp.next;
            i++;
        }
         temp.next=temp.next.next;
        return head;
	}
}


4.                              FIND A NODE ONDEX IN A LL
public static int indexOfNIter(LinkedListNode<Integer> head, int n) {
    int i=0;
   while(head!=null&&head.data!=n)
   {
       head=head.next;
       i++;
  }
 if(head!=null&&head.data==n)
 {
     return i;
 }
 return -1;
}

5.                              APPEND LASTNTOFIRST

public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n)
{
    if(n == 0 || head == null) return head;
    LinkedListNode<Integer> prev = head;
    LinkedListNode<Integer> curr = head;
    LinkedListNode<Integer> initialhead = head;
    
    for(int i =0; i<n; i++)
    {
        curr = curr.next;
    }
    while(curr.next!=null)
    {
        prev = prev.next;
        curr = curr.next;
    }
    initialhead = prev.next;
    prev.next = null;
    curr.next = head;
    return initialhead;
}


6.                          REMOVE CONSUGATIVE DUPLICATES
public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

    LinkedListNode<Integer> t1=head;
    LinkedListNode<Integer> t2=head.next;
    while(t2!=null)
    {
         if(t1.next==null)
         {
             return head;
         }
         if((int)t1.data!=(int)t2.data)
         {
             t1.next=t2;
             t1=t2;
             t2=t2.next;
         }
         else
         {
             t2=t2.next;
         }
    }
    t1.next=t2;
return head;
}
6.B


public class Solution {
    
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
			if(head==null) return head;
            LinkedListNode<Integer> curr=head;

            while(curr.next!=null)
            {
                
                 if((int)curr.data==(int)curr.next.data)
                	 curr.next = curr.next.next;
                 else curr = curr.next;
               
            }
        return head;
        }
    }




7.                              Print Reverse LinkedList
public static void printReverseRecursive(LinkedListNode<Integer> root) {
    if(root==null)
     {
         return; 
     }
     // print list of head node 
  printReverseRecursive(root.next); 

     // After everything else is printed 
 System.out.print(root.data+" "); 
}

8.                                  REVERSE LinkedList
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next==null) return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode t = head.next;
        while(curr!=null)
        {
            curr = curr.next;
            t.next = prev;
            prev = t;
            t = curr;
        }
        head.next = null;
        return prev;
    }
}

LEETCODE SOL
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}


RecursiveAction
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}


9.                          FIND THE MIDPOINT OF THE LL

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null)
        {
            
            if(fast.next==null) break; 
                fast = fast.next.next;
            slow = slow.next;
            
        }
        return slow;
    }
}


10.                     PALIMDRONE LL
METHODS
1.a comapre 1st and last element again & again O(n^2)
2.make a new linked list and reverse that
3.reverse half linked list
4. or not change ll only compares throuhg RecursiveAction
4.th one is This

https://classroom.codingninjas.com/app/classroom/me/978/content/14938/offering/132777/problem/330
public class Solution {
    static LinkedListNode<Integer> tmp ;
   public static boolean isPalindrome(LinkedListNode<Integer> head) {
       if(head ==null || head.next==null) return true;
       
        LinkedListNode<Integer> mid = middleNode(head);
        tmp = head;
        boolean f = printReverseRecursive(mid);
       return f;
   }
   
   public static LinkedListNode<Integer> middleNode(LinkedListNode<Integer> head) {
       if(head == null || head.next==null) return head;
       LinkedListNode<Integer> slow = head;
       LinkedListNode<Integer> fast = head;
       while(fast!=null)
       {
           
           if(fast.next==null) break; 
               fast = fast.next.next;
           slow = slow.next;
           
       }
       return slow;
   }
   
   
   public static boolean printReverseRecursive(LinkedListNode<Integer> mid)
   {
     if(mid==null) return true; 
       
       if(!printReverseRecursive(mid.next)) 
           return false;
        
        if(mid.data != tmp.data)
            return false;
        tmp = tmp.next;
      return true;
  }

}

10.b
through Stack
public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> slow = head; 
boolean ispalin = true; 
 Stack<Integer> stack = new Stack<Integer>(); 

while (slow != null) { 
   stack.push(slow.data); 
        slow = slow.next; 
   } 

    while (head != null) { 

      int i = stack.pop(); 
    if (head.data == i) { 
     ispalin = true; 
    } 
   else { 
      ispalin = false; 
     break; 
   } 
        head = head.next; 
} 
       return ispalin; 
} 
}




/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/
11.                         MERGE TWO SORTED LIST
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head =  null;
        ListNode tail =  null;
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        if(l1.val  < l2.val)
        {
            head = l1;
            tail = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            tail = l2;
            l2 = l2.next;
        }
        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val)
            {
                tail = l2;
                l2 = l2.next;
                
            }
        }
    }
}


12.                         REVERSE A LL RECURSIVELY

public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
    if(head == null || head.next == null) return head;
    
    LinkedListNode<Integer> tail = reverseLinkedListRec(head.next);
    // tail.next = head;
     head.next.next = head; 
     head.next = null; 
    return tail;
}


13.                     DELETE NODE RECURSIVELY

static int count;
public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int i) {
     if(head == null || head.next == null)
         return head;
    count++;
    if(count == i-1)
    {
        head.next = head.next.next;
    }
     
    deleteNodeRec(head.next,i);
    return head;
}

BEST sol
public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int i) {
    if(head == null)
        return head;

   if(i == 0)
   {
       return head.next;
   }
    
   LinkedListNode<Integer> tmp =  deleteNodeRec(head.next,i-1);
   head.next = tmp;
   return head;
}


14.                     FIND A NODE IN LL RECURSIVELY
static int count;
	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	if(head == null) 
        {
            count = -1;
            return count;
        }   
        if(head.data == n )
            return count;
        count++;
        int a = findNodeRec(head.next,n);
        return count;
    }
    
 14. B
 public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    if(head == null) 
    {
        // count = -1;
        return -1;
    }   
    if(head.data == n )
        return 0;
    // count++;
    int a = findNodeRec(head.next,n);
    if(a==-1) return a;
    return a+1;
}   



15.                         DELETE EVERY N NODES AFTER M NODES

public class Solution {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N)
    {
        if(M == 0) return null;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> t = null;
        int count =0;
        while (curr!=null)  
        {  
            // Skip M nodes  
            for (count = 1; count < M && curr != null; count++)  
                curr = curr.next;  

            // If we reached end of list, then return  
            if (curr == null)  
                return head;  

            // Start from next node and delete N nodes  
            t = curr.next;  
            for (count = 1; count <= N && t != null; count++)  
            {  
                 LinkedListNode<Integer> temp = t;  
                 t = t.next;  
            }  

            // Link the previous list with remaining nodes  
            curr.next = t;  

            // Set current pointer for next iteration  
            curr = t;  
        }
        return head;
    }
}


16.                             SWAP NODES IN ALL
in this for diff cases
1. i=0,j=1 head is changed
2.i=0,j=2,3,4,5head is changed
3. i=1, j=2,3,4,5 return head
4. i =0,j=5
this is cn solution my sol is below and see ho i handeled them
public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
    if(i==j) return head;
    
    LinkedListNode<Integer> curr = head;
    LinkedListNode<Integer> prev  = null;
    LinkedListNode<Integer> p1 = null;
    LinkedListNode<Integer> c1 = null;
    LinkedListNode<Integer> p2 = null;
    LinkedListNode<Integer> c2 = null;
    int pos = 0;
   
    while(curr!=null)
    {
        if(pos == i)
        {
            p1 = prev;
            c1 =curr;
        }
        else if(pos == j)
        {
            p2 = prev;
            c2 = curr;
        }
        prev = curr;
        curr= curr.next;
        pos += 1;
    }
    
    if(p1!= null)
        p1.next = c2;
    else
        head = c2;
    
    if(p2!=null)
        p2.next = c1;
    else
        head = c1;
    
    LinkedListNode<Integer> tmp = c2.next;
    c2.next = c1.next;
    c1.next = tmp;
    return head;
}


16.b


public class Solution {

	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
	   	LinkedListNode<Integer> p1 = null;
        LinkedListNode<Integer> c1 = head;
        LinkedListNode<Integer> p2 = null;
        LinkedListNode<Integer> c2 = head;
        if(i==j) return head;
        if(i > j)
        {
            int tmp = i;
            i = j;
            j =tmp;
        }
        if(i == 0)
        {
            p1 =c1;
        }
        
        int a = i;
        int b = j;
        while(a-->0)
        {
            p1 = c1 ;
            c1 = c1.next;
        }
        while(b-->0)
        {
            p2 = c2 ;
            c2 = c2.next;
        }
        // while(j-->0)
        // {
        //     i--;
        //     if(i == 0)
        //     {
        //         c1 = p1.next;
        //     }
        //     else if(i>0)
        //         p1 = p1.next;
        //     if(j==0)
        //     {
        //         c2 = p2.next;
        //     }
        //     else
        //     {
        //         p2 = p2.next;
        //     }
        // }
          if(i == 0 )
          {
        	  if(j-i == 1)
        	  {
        		  p1.next = c2.next;
        		  c2.next = p1;
        		  return c2;
        	  }
        	  else
        	  {
        		  LinkedListNode<Integer> tmp = p1.next;
                  p1.next = c2.next;
                  c2.next = tmp;
                  p2.next = p1;
                  return c2; 
        	  }
        	 
          }
        else
        {
            p1.next = c2;
        	p2.next = c1;
        	c1.next = c2.next;
        	c2.next = p2;
        }	
           return head;  
	}

}

// 1
// 1 2 3 4 5 -1
// 1 3 



17.                           DELETE A NODE FROM BACK SIDE
https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        n--;
        ListNode fast = head;
        ListNode slow = head;
        for(int i =0 ;i<=n;i++)
        {
            fast = fast.next;
        }
        if(fast == null) return slow.next;
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
           
            
        slow.next = slow.next.next;
        return head;
}
}

18.                             DELELTE A NODE IF YOU GIVEN THAT NODE
https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    
    }
}

19.                             REVERSE LL ANTICLOCKWIAW OR IN FORWARD Direction
https://leetcode.com/problems/rotate-list/submissions/6
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        int count =0;
        for(int i = 0; i<k; i++)
        {
             
            if(fast == null) break;
            count++;
            if(fast!=null)
                fast = fast.next;
           
        }
        if(fast == null)
        {
            if(count == k) return head;
            else
            {
                k = (k%count);
                if(k== 0) return head;
                // while(k>count)
                // k = k - a;
                fast = head;
                  for(int j = 0; j<k; j++)
                  {
                      fast = fast.next;
                  }
            }
        }    
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}





















}


