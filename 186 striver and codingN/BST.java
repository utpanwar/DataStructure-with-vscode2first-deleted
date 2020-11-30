https://expertmitra.com/ mock interview

1.                          Populating Next Right Pointers in Each Node


https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
https://www.geeksforgeeks.org/connect-nodes-at-same-level/
it is only 5 % faster
it usees O(n) space beacuse queue is increse on each level of tree
import java.util.*;
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(1==1)
        {
            int size = q.size();
            if(size == 0)
                return root;
            while(size-->0)
            {
                Node tmp = q.poll();
                
                if(size!=0)
                    tmp.next = q.peek();
                if(tmp!=null && tmp.left!=null)
                    q.add(tmp.left);
                
                 if(tmp!=null && tmp.right!=null)
                    q.add(tmp.right);
            }
            
        }
    }
}

1.B 
Recursive
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
best solution 100 percnt faster or no extra space 
class Solution {
    public Node connect(Node root) {
        if(root!=null) nextPointer(root);
        return root;
    }
    public static void nextPointer(Node root)
    {
        if(root == null)
            return;
        if(root.left!=null && root.right!=null)
            root.left.next = root.right;
            // if (root.right != null)
            // root.right.next = (root.next != null) ? root.next.left : null;
            // this could be a way
        if(root.right!=null && root.next!=null)
            root.right.next = root.next.left;

        if(root.left!=null && root.right==null && root.next!=null)
            root.left.next = root.next.left;
//    above line handles when it is not having right pointer         
        nextPointer(root.left);
          nextPointer(root.right);
        return;
        
    }  
    
    
1.C 
Leetcode disscusion
smart traversal with O(1) space and O(N) time complexity
    // return connectSmartIter(root);
this sol is best than the 1 beacause it usees O(1) space see it
not uses the queue it uses single pointer every time which is constant   
    public Node connectSmartIter(Node root) {
        if(root == null) {
            return root;
        }
        
        Node curr = root;
        while(curr != null) {
            Node temp = curr;
            while(temp != null) {
                
                if(temp.left != null) temp.left.next = temp.right;
                if(temp.right != null && temp.next != null)temp.right.next = temp.next.left;
                temp = temp.next;
            }
            // if(temp.left != null)
            curr = curr.left;
            // else
            // curr = null;
        }
        
        return root;
        
    }

1.D
ye qns queueu k alawa two stack se bhi kiya ja sakata hai
https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/  








2.                          SEARCH A NODE IN BST
best - O(logh)
worst in skewed tree O(n)

public Node search(Node root, int key) 
{ 
    if (root==null || root.key==key) 
        return root; 
  

    if (root.key > key) 
        return search(root.left, key); 
    return search(root.right, key); 
} 




3.                      MAKE A BST FROM PREORDER
https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
do again you have see this
Node constructTree(int pre[], int size) { 
    return constructTreeUtil(pre, index, 0, size - 1, size); 
}
Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {



}

3.b
https://leetcode.com/problems/construct-binar
y-search-tree-from-preorder-traversal/discuss/873759/Java-0ms-solution-Recursive-solution
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder,int l,int r){
        if(l>r)return null;
        
        TreeNode node=new TreeNode(preorder[l]);
        int i=l+1;
        while(i<preorder.length&&preorder[i]<=preorder[l]){
           i++;
        }
        node.left=construct(preorder,l+1,i-1);
        node.right=construct(preorder,i,r);
        return node;
    }
}
3.https://leetcode.com/problems/construct-binary-search
-tree-from-preorder-traversal/discuss/589801/JAVA-3-WAYS-TO-DO-THE-PROBLEM!-O(N)-APPROACH





4.                  CHECK A BT IS A BST OR NOT

this approach is fails
boolean isBST(Node root)
{
    if(root == null) return true;
    if(root.left! = null && root.left.data < root.data) isBST(root.left);
    else return false;

    if(root.right! = null && root.right.data < root.data) isBST(root.right);
    return false;
} 

4.B
best - nlogn 
worst - n^2
int isBST(Node node) 
{
    if(root === null) return false;
    if(root.left!=null && maxvalue(root.left) > root.data ) return false;
    if(root.right!=null && minvalue(root.right) < root.data ) return false;
    if(!isBST(root.left)) return false;
    if(!isBST(root.right)) return false;
    return true;
}

4.C bhai karo isse jaldi
https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/










5.                               LCA IN BST
LEETCODE ITERATIVE  
Time Complexity : O(N)O(N), where NN is the number of nodes
 in the BST. In the worst case we might be visiting all the nodes of the BST.
best - O(h)
Space Complexity : O(1) constant.            
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
  
5.B
leet code solution most faster
O(n) in worst
O(h) in best 
O(1) if ignore stack
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
     if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left , p, q);
        return root;
    }
}  











6.                                INORDER SUCCESSER IN  A BST
my solution
time complexity-O(h)
Node store = null;
	public Node inorderSuccessor(Node root,Node x)
         {
            if(root==null) return root;
            
            if(root.data == x.data) 
            {
                
            if(root.right!=null)
            {
                or simply call fun over here minvalue(root.right);
                Node tmp = root.right;
	            		 if(tmp.left==null) return root.right;
	            		 else
	            		 {
	            			 while(tmp.left!=null)
	            			 {
	            				 tmp =tmp.left;
	            			 }
	            			 return tmp;
	            		 }
            }
            else return store;
            }
             Node lcl = null;
                    
          if(x.data < root.data) 
            {
                store = root;
                lcl= inorderSuccessor(root.left,x);
            }
        else
             lcl = inorderSuccessor(root.right,x); 
             
    //   if(lcl!=null)
    //      {
    //         if(lcl.right!=null) return lcl.right;
    //         if(lcl.right == null && root.data > lcl.data) return store;
    //         else return store;
    //      }
         
    return lcl;
 }

}



7.                      FIND THE KTH SMAALEST ELEMENT INA A BST
DO INORDER TRAVERSAL
TIME - O(n) [FOR FORMING AN Array]+O(1)[fetching a single element from the array] 
SPACE- O(N)[size of aaraay is n which is extra space]
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
       int  a  =   kthSmallestH(root,k,arr); 
        return arr.get(k-1);
        
    }
    public int kthSmallestH(TreeNode root, int k,ArrayList<Integer> arr) {
     if(root == null) return -1;
        
        int a = kthSmallestH(root.left,k,arr);
        // if(a!=-1)
            arr.add(root.val);
        int b =  kthSmallestH(root.right,k,arr);
        // arr.add(root.data);
        return 0;
    }
}

7.B
https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
time - O(n)
space - O(h) because recursion is  a stack
this can be done with -negative aaproACH I FAILS THERE
class Solution {
    int  count = 0;
     public int kthSmallest(TreeNode root, int k) {
         if( root==null) 
             return 0;
        int a = kthSmallest(root.left,k);
        if (a != 0) 
            return a; 
       
        count++; 
        if (count == k) 
            return root.val; 
       
        return  kthSmallest(root.right,k); 
       
     }
 }


 7C.
try to understand this code
https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/729692/Clear-Java-100
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k)[0];
    }
    public int[] dfs(TreeNode n, int k) {
        if (n == null) return new int[]{-1, 0};
        int[] l = dfs(n.left, k);
        if (l[0] != -1) return new int[]{l[0], -1};
        else {
            if (l[1] == k - 1) return new int[]{n.val, -1};
            int[] r = dfs(n.right, k - l[1] - 1);
            if (r[0] != -1) return new int[]{r[0], -1};
            return new int[]{-1, l[1] + r[1] + 1};
        }
    }
}

7.D
https://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/
do this

7.E
O(h) O(h)

8.                      CONVERT BINARY TREE TO INORDER LinkedList or DLL
both have O(n) complexity and O(h) space   
  1. 
    singlie list INORDER typr
    class Solution {
        //	Stack<TreeNode> s  = new Stack<>();
            TreeNode prev = null;
            TreeNode head = null;
              public void flatten(TreeNode root) {
                    if(root == null)
                        return ;
        
                   flatten(root.left);
                    if (prev == null)  
                        head = root; 
                    else
                    { 
                        root.left = null; 
                        prev.right = root; 
                    } 
                    prev = root;
                    flatten(root.right);
        
                }
        }
     
     
    1.B
    Doubley Linked LIst inorder type
    void BinaryTree2DoubleLinkedList(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    }     




9.                      FIND A TRIPLET SUM TO ZERO IN  Balanced BINARYST    

1. Ffirst we have to understand the how to find the sum of triplet in
array in O(n^2) complexity.
1a naive approch.
O(n^3) and O(1);
boolean find3Numbers(int A[], int arr_size, int sum) 
{ 
    int l, r; 

    // Fix the first element as A[i] 
    for (int i = 0; i < arr_size - 2; i++) { 

        // Fix the second element as A[j] 
        for (int j = i + 1; j < arr_size - 1; j++) { 

            // Now look for the third number 
            for (int k = j + 1; k < arr_size; k++) { 
                if (A[i] + A[j] + A[k] == sum) { 
                    System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]); 
                    return true; 
                } 
            } 
        } 
    } 

    // If we reach here, then no triplet was found 
    return false; 
}
 

1.b
https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
must see abouve
uses the two-pointer technique. 
O(n^2) and space O(1);
1.c
using hashing

NOW lets Start

9.A
The Brute Force Solution 
time = O(n)[inorder into array] + O(n^2)[two pointers] 
space = O(h)[recursion] + O(n) [arrayuList]+O(1);
class Solution {
    ststic ArrayList<Integer> arr = new ArrayList<>();
    static public void  inorder(Node root)
    {
        if(root == null ) return ;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
        return;
    }
  
   static void find triplet(int sum)
   {
       for(int  i= 0 ; i<arr.size()-2; i++)
       {
          int j = i+1;
          int h = arr.size()-1;
          while(j<h)
          {
              if(arr.get(i)+arr.get(j)+arr.get(h) ==  sum)
              {
                  print(a[i] + a[j]+ a[h]);

              }
              else if(arr.get(i)+arr.get(j)+arr.get(h) < sum)
              j++;
              else
              h--;
          } 
       }
   } 
}  

9.B
time = O(n)[inorder into array] + O(n^2)[Hashing] 
space = O(h)+O(n)+O(1) 
only two pointer can be replaced with hashing
static void find triplet(int sum)
{
    for(int  i = 0; i< arr.size()-1;i++)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int j = i+1 ; j<arr.size(); j++ )
        {
            if (s.contains(curr_sum - A[j])) { 
                System.out.printf("Triplet is %d, %d, %d", A[i], 
                                  A[j], curr_sum - A[j]); 
                return true; 
            } 
            s.add(A[j]); 
        }
    }
}

9.C 
IMPORTANT
CONVERT DLL
https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
must do these qns in the last sugestion
fun(root)
{
    Stack s =null; s.push(r.r) && s.ush(1)
    while(size-->0)
    {
        tmp = s.peek();
        if(tmp.left!=null)
         s.push(tmp.left.right)
         s.pushtmp.(left)


         if(tmp.left&& r =null)
         pop upt to 1 element 
        
    }
}


10.                    INORDER TRAVERSAL WITHOUT RECURSION


10.                     PAIR WITH A GIVEN SUM
// Java implementation of the approach
import java.util.*;

class GFG
{

// Node of the binary tree
static class node 
{
	int data;
	node left;
	node right;
	node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
};

// Function to find a pair with given sum
static boolean existsPair(node root, int x)
{
	// Iterators for BST
	Stack<node > it1 = new Stack<node>(), it2 = new Stack<node>();

	// Initializing forward iterator
	node c = root;
	while (c != null)
	{
		it1.push(c);
		c = c.left;
	}

	// Initializing backward iterator
	c = root;
	while (c != null)
	{
		it2.push(c);
		c = c.right;
	}
		
	// Two pointer technique
	while (it1.peek() != it2.peek()) 
	{

		// Variables to store values at
		// it1 and it2
		int v1 = it1.peek().data, v2 = it2.peek().data;

		// Base case
		if (v1 + v2 == x)
			return true;

		// Moving forward pointer
		if (v1 + v2 < x) 
		{
			c = it1.peek().right;
			it1.pop();
			while (c != null)
			{
				it1.push(c); 
				c = c.left;
			}
		}

		// Moving backward pointer
		else
		{
			c = it2.peek().left;
			it2.pop();
			while (c != null)
			{
				it2.push(c);
				c = c.right;
			}
		}
	}
	
	// Case when no pair is found
	return false;
}

// Driver code
public static void main(String[] args)
{
	node root = new node(5);
	root.left = new node(3);
	root.right = new node(7);
	root.left.left = new node(2);
	root.left.right = new node(4);
	root.right.left = new node(6);
	root.right.right = new node(8);

	int x = 5;

	// Calling required function
	if (existsPair(root, x))
		System.out.print("Yes");
	else
		System.out.print("No");

}
}

// This code is contributed by 29AjayKumar

10.b
// JAVA program to find a pair with 
// given sum using hashing 

import java.util.*; 

class GFG 
{ 

	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 

	static Node NewNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	static Node insert(Node root, int key) 
	{ 
		if (root == null) 
			return NewNode(key); 
		if (key < root.data) 
			root.left = insert(root.left, key); 
		else
			root.right = insert(root.right, key); 
		return root; 
	} 

	static boolean findpairUtil(Node root, int sum, 
								HashSet<Integer> set) 
	{ 
		if (root == null) 
			return false; 

		if (findpairUtil(root.left, sum, set)) 
			return true; 

		if (set.contains(sum - root.data)) 
		{ 
			System.out.println("Pair is found (" + 
								(sum - root.data) + 
								", " + root.data + ")"); 
			return true; 
		} 
		else
			set.add(root.data); 

		return findpairUtil(root.right, sum, set); 
	} 

	static void findPair(Node root, int sum) 
	{ 
		HashSet<Integer> set = new HashSet<Integer>(); 
		if (!findpairUtil(root, sum, set)) 
			System.out.print("Pairs do not exit" + "\n"); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Node root = null; 
		root = insert(root, 15); 
		root = insert(root, 10); 
		root = insert(root, 20); 
		root = insert(root, 8); 
		root = insert(root, 12); 
		root = insert(root, 16); 
		root = insert(root, 25); 
		root = insert(root, 10); 

		int sum = 33; 
		findPair(root, sum); 

	} 
} 

// This code is contributed by PrinciRaj1992 


11.                    BST ITERATOR

