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
//    above line handles when it is not haing right pointer         
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

Space Complexity : O(1)O(1).            
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
log(n) in best 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
     if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left , p, q);
        return root;
    }
}   
