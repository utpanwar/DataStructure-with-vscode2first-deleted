package 186 striver and codingN;
             
                    CODING NINJAS & striver

 1.                FIND NODE INA TREE
  O(n)

https://classroom.codingninjas.com/app/classroom/me/978
/content/14947/offering/132878/problem/1156
public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
    if(root == null)
        return false;
      if(root.data == x)
          return true;
      boolean isnode ;
      
          if(isNodePresent(root.left,x))
              return true;
       if(isNodePresent(root.right,x))
           return true;
      return false;
  }
  
}

1.A CN
O(n)
public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){

      if(null == root)
    {
        return false;
    }
    boolean found = root.data.equals(x);
    if(found)
        return true;
    found = found || isNodePresent(root.left, x);
    if(found)
        return true;
    found = found || isNodePresent(root.right, x);
    return found;
}

}

2 .                     FIND HEIGHT OF A BINARY TREE
https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
o(N)
public static int height(BinaryTreeNode<Integer> root) 
        if (node == null) 
            return 0; 
        Queue<Node> q = new LinkedList(); 
        q.add(node); 
        int height = 0; 
        while (1 == 1)  
        {
            int nodeCount = q.size(); 
            if (nodeCount == 0) 
                return height; 
            height++; 
            while (nodeCount > 0)  
            { 
                Node newnode = q.peek(); 
                q.remove(); 
                if (newnode.left != null) 
                    q.add(newnode.left); 
                if (newnode.right != null) 
                    q.add(newnode.right); 
                nodeCount--; 
            } 
        } 
	}
   
 2b.CN
 o(N)

	public static int height(BinaryTreeNode<Integer> root) {
// 		int count2=0,count = 0,count1=0;
//         if(root == null)
//         {
//             return count2;
//         }
//         count=height(root.left);
//         count1=height(root.right);
//         if(count1>count)
//         {
//             return count1+1;
//         }   
        
//         else return count+1;
// 	}
        		if(root==null)
			return 0;
		int count=1,count1=1;
		 count = count+height(root.left);
		 count1 =count1+height(root.right);
		 if(count>count1)
			 return count;
		 return count1;
		 
	}
	
}

2 .c same
 O(n) beacause recur is 2T(n/2) + k
public class Solution {
    static int h;
      public static int height(BinaryTreeNode<Integer> root) {
         if(root==null)
             return 0;
          
           h = 1+Math.max(height(root.left),height(root.right));
          
          return h;
          
      }
      
  }  

  3.                          MIRROR A BINARY TREE
  CN O(n)
public static void mirror(BinaryTreeNode<Integer> root){
    if(null==root)
        return;
    mirror(root.left);
    mirror(root.right);
    if(root.left!=null && root.right!=null)
    {
        // BinaryTreeNode<Integer> temp = root;
        BinaryTreeNode<Integer> tmp = root.left;
        root.left=root.right;
        root.right=tmp;
    }
   return;
}

3.B GFG O(n)
public static void mirror(BinaryTreeNode<Integer> root){
 
    Queue<BinaryTreeNode<Integer>> q = LinkedList<>();
    q.add(root);
    while(!q.isEmpty())
    {

        BinaryTreeNode<Integer> tmp = q.peek();
        q.poll();
        BinaryTreeNode<Integer> temp = tmp.left;
        tmp.left=tmp.right;
        tmp.right = temp;
        
        if(tmp.left!=null)
        q.add(tmp.left);

        if(tmp.right!=null)
        q.add(tmp.right);
    }

}

4.                         FIND THE DIAMETER OF A TREE
https://classroom.codingninjas.com/app/classroom/me/978/content/14947/offering/132883
O(n*h)
in best case n*nlogn beacause it have T(n) = 2T(n/2) + kn; in complete or may be symetric tree
because in this height in logn 
in worst case skewed tree T(n) = T(n-1) + kn;
public static int diameter(BinaryTreeNode<Integer> root)
{
    if(root == null)
    {
        return 0;
    }
    option1 = height(root.left) + height(root.right);
    option2 = diameter(root.left);
    option3 =diameter(root.right);
    return Math.max(option1,Math,max(option2 option3));
}
int h;
private static int height(BinaryTreeNode<Integer> root)
{
    if(root==null)
      return 0;
    h = 1+Math.max(height(root.left),height(root.right));
    return h;
}

E:\CN\Data Structure with java\11.binary tree
4B. Now tring to do complexity in O(n)
 class pair<T,V>  
 {
     public first;
     public seacond;
 }

 public static int diameter(BinaryTreeNode<Integer> root)
{
    if(root == null)
    {
        Pair <Integer,Intger> output = new Pair<>();
        output.first=0;
        output.seacond=0;
        return output;
    }
    Pair<Integer,Integer> lo = height(root.left);
    Pair<Integer,Integer> ro = height(root.right);
    option2 = diameter(root.left);
    option3 =diameter(root.right);
    return Math.max(option1,Math,max(option2 option3));

    do it youself
}


5.                CONSTRUCT TREE FROM INORDER AND PREORDER

1. O(nlogn) in best t(n)=2T(n/2)+ kn;
   (n^2) in left skewed t(n)=T(n-1)+ kn;


public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in){
		
    return getTreeFromPreorderAndInorderH(pre,in,0,pre.length-1,0,in.length-1);

}

public static BinaryTreeNode<Integer>
getTreeFromPreorderAndInorderH(int[] pre, int[] in,int preS,int preE,int inS,int inE){
if(inS>inE)
    return null;
int root = pre[preS];
BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(root);
int j=inS;
for(int i = inS;i<inE;i++)
{
    if(in[i]!=root)
        j++;
      if(in[i]==root)
        break;
}
int leftInI = inS;
int leftEnI = j-1;
int rightInI=j+1;
int rightInE=inE;

int leftpreI = preS+1;
int length = leftEnI - leftInI+1;
int leftpreE = leftpreI + length-1;
int rightpreI=leftpreE+1;
int rightpreE=preE;

root1.left = getTreeFromPreorderAndInorderH(pre,in, leftpreI,leftpreE, leftInI,leftEnI);
root1.right = getTreeFromPreorderAndInorderH(pre,in, rightpreI,rightpreE, rightInI,rightInE);
return root1;
  }
}


5.B O(n) in all cases t(n) = 2T(n/2) + k;
https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in){
    HashMap<Integer, Integer> map1 = new HashMap<>();
for(int i =0 ;i < in.length;i++)
{
  map1.put(in[i],i);
}
       return getTreeFromPreorderAndInorderH(pre,in,0,pre.length-1,0,in.length-1,map1);
   
}

public static BinaryTreeNode<Integer>
   getTreeFromPreorderAndInorderH(int[] pre, int[] in,int preS,
                                  int preE,int inS,int inE, HashMap<Integer, Integer> map1){
   if(inS>inE)
       return null;
   int root = pre[preS];
  BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(root);
   int j=inS;
   // for(int i = inS;i<inE;i++)
   // {
   //     if(in[i]!=root)
   //         j++;
   //       if(in[i]==root)
   //         break;
   // }
     j=map1.get(root);
   int leftInI = inS;
   int leftEnI = j-1;
   int rightInI=j+1;
   int rightInE=inE;
   
   int leftpreI = preS+1;
   int length = leftEnI - leftInI+1;
   int leftpreE = leftpreI + length-1;
   int rightpreI=leftpreE+1;
   int rightpreE=preE;
   
   root1.left = getTreeFromPreorderAndInorderH(pre,in, leftpreI,leftpreE, leftInI,leftEnI,map1);
    root1.right = getTreeFromPreorderAndInorderH(pre,in, rightpreI,rightpreE, rightInI,rightInE,map1);
   return root1;
}
}



6.                              CONSTRUCT TREE FROM INORDER AND POSTORDER
O(n) in best and worst
public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,
int[] in){

HashMap<Integer, Integer> map1 = new HashMap<>();
for(int i =0 ;i < in.length;i++)
{
map1.put(in[i],i);
}
return getTreeFromPostorderAndInorderH(post,in,0,post.length-1,0,in.length-1,map1);

}

public static BinaryTreeNode<Integer>
getTreeFromPostorderAndInorderH(int[] pre, int[] in,int preS,
                           int preE,int inS,int inE, HashMap<Integer, Integer> map1){
if(inS>inE)
return null;
int root = pre[preE];
BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(root);
int j=inS;
// for(int i = inS;i<inE;i++)
// {
//     if(in[i]!=root)
//         j++;
//       if(in[i]==root)
//         break;
// }
j=map1.get(root);
int leftInI = inS;
int leftEnI = j-1;
int rightInI=j+1;
int rightInE=inE;

int leftpreI = preS;
int length = leftEnI - leftInI+1;
int leftpreE =  leftpreI+length-1;
int rightpreI=leftpreE+1;
int rightpreE=preE-1;

root1.left = getTreeFromPostorderAndInorderH(pre,in, leftpreI,leftpreE, leftInI,leftEnI,map1);
root1.right = getTreeFromPostorderAndInorderH(pre,in, rightpreI,rightpreE, rightInI,rightInE,map1);
return root1;
}
}



7.              SUM OF EACH NODE IN A BINARY TREE
O(N)
public static int sum(BinaryTreeNode<Integer> root){

      if (root==null)
         return 0;
     return root.data+sum(root.left)+sum(root.right);
 }
 
}.

7 .B
*/
static int count1,count;
public static int sum(BinaryTreeNode<Integer> root){
    if(root==null)
        return 0;
    count1 +=root.data;
   count += sum(root.left)+sum(root.right);
 return count1;
}


8.                          CHECK TREE IS BALANCED

in best case n*nlogn beacause it have T(n) = 2T(n/2) + kn; in complete or may be symetric tree
because in this height in logn 
in worst case skewed tree T(n) = T(n-1) + kn; and complexity is O(n*n)               
                  
in best case 
public static boolean checkBalanced(BinaryTreeNode<Integer> root){
    if(root==null)
      return true;
    int h1 = height(root.left);
    int h2 = height(root.right);
    if( (h1-h2 < 1) || (h2-h1 < 1) )
      return false;

      if(!checkBalanced(root.left))
         return false;
        if(!checkBalanced(root.right))
          return false;
    return true;      
}
static int h ;
public static int checkHeight(BinaryTreeNode<Integer> root){
    if(root==null)
        return 0;
        h= 1+Math.max(height(root.left)+height(root.right));
}

8 B. 

O(n)
public  static class checkB{
    boolean isBalanced;
    int height;
}

public static boolean checkBalanced(BinaryTreeNode<Integer> root){

    if(root==null)
        return true;
    return checkBalancedH(root).isBalanced;

}



public static checkB checkBalancedH(BinaryTreeNode<Integer> root){
    if(root==null)
    {
        checkB ans = new checkB();
        ans.height=0;
        ans.isBalanced=true;
        return ans;
    }
    checkB leftans = checkBalancedH(root.left);
    if(!leftans.isBalanced)
        return leftans;
    checkB rightans = checkBalancedH(root.right);
    if(!rightans.isBalanced)
        return rightans;
    checkB ans;
    int heightd=0;
    if(leftans.height-rightans.height>=0)
    {
        ans= new checkB();
        heightd = leftans.height-rightans.height;
        ans.height = 1+leftans.height;
        ans.isBalanced=true;
    }
    else
    {
        ans= new checkB();
        heightd = rightans.height-leftans.height;
        ans.height = 1+rightans.height;
        ans.isBalanced=true;
    }
   if(heightd>1)
    {
        ans.isBalanced=false;   
    }
    return ans;      
}

}



9.                         LEVEL ORDER TRAVERSAL
O(n)
public static void printLevelWise(BinaryTreeNode<Integer> root){
		
    Queue<BinaryTreeNode<Integer>>  q = new LinkedList<>(); 
    q.add(root);
    while(1==1)
    {
        int newnode = q.size();
        // BinaryTreeNode<Integer> node =q.poll();
        
       
        if(newnode==0)
            return;
       while(newnode-->0)
       {
           BinaryTreeNode<Integer> node=q.peek();
           System.out.print(node.data+" ");
           if(node.left!=null)
               q.add(node.left);
           if(node.right!=null)
               q.add(node.right); 
          q.poll();  
       }
       System.out.println();
    }
}
   
9.B
QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
QueueUsingLL<BinaryTreeNode<Integer>>  secondry = new QueueUsingLL<>();
primary.enqueue(root);
while(!primary.isEmpty())
{
    BinaryTreeNode<Integer> current = null;
    try{
        current = primary.dequeue();
    }
    catch(QueueEmptyException e){
        
    }
    System.out.print(current.data+" ");
    if(current.left!=null)
    {
        secondry.enqueue(current.left);
    }
    if(current.right!=null)
    {
        secondry.enqueue(current.right);
    }
    if(primary.isEmpty())
    {
        QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondry;
         secondry = primary;
         primary = temp;
         System.out.println();
    }
}
}
}


10.                      REMOVE LEAF NODE

public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
    if(root==null)
    {
        return null;
    }
    if(root.left==null&&root.right==null)
    { 
        // root = null;
        return null;
    }
    root.left=removeAllLeaves(root.left);
    root.right=removeAllLeaves(root.right);
    return root;
}


11.                  LEVEL WISE LinkedList
O(n)
https://classroom.codingninjas.com/app/classroom/me/978/content/14947/offering/132898/problem/78
public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		
    if(root==null)
    {
        ArrayList<Node<BinaryTreeNode<Integer>>> arr = null;
        return arr;
    }
   
   Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
    ArrayList<Node<BinaryTreeNode<Integer>>> arr = new ArrayList<>();
   q.add(root);
   while(1==1)
   {
       int size=q.size();
       if(size==0)
       {
            return arr;
       }
       Node<BinaryTreeNode<Integer>> head=null;
       while(size-->0)
       {
           BinaryTreeNode<Integer> tmp = q.poll();
           if(head==null)
           {
               head= new Node<BinaryTreeNode<Integer>>(tmp);
           }
           else
           {
               Node<BinaryTreeNode<Integer>> temp = head;
               while(temp.next!=null)
               {
                   temp=temp.next;
               }
              Node node= new Node<BinaryTreeNode<Integer>>(tmp);
               temp.next = node;
           }
            
          if(tmp.left!=null)
              q.add(tmp.left);
            if(tmp.right!=null)
              q.add(tmp.right);
       }
          arr.add(head);
   }
    
}

12.                         ZIGZAG TREE
time = O(n)+O(n)
space = O(n)+O(n-1)
using queue and stack
https://classroom.codingninjas.com/app/classro
// om/me/978/content/14947/offering/132898/problem/82
public static void printZigZag(BinaryTreeNode<Integer> root) {

    //  best sol
  QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<>();
      Stack<BinaryTreeNode<Integer>> s = new Stack<>();
      s.push(root);
      int count=3;
      while(!s.isEmpty())
      {
        <BinaryTreeNode<Integer> stack = s.pop();
        System.out.print(stack.data);

        if(count%2==0)
        {
            if(s.right!=null)
            q.enqueue(s.right);

            if(s.left!=null)
            q.enqueue(s.left);
        }
        else
        {
            if(s.left!=null)
            q.enqueue(s.left);

            if(s.right!=null)
            q.enqueue(s.right);
        }
        if(s.isEmpty())
        {
            while(!q.isEmpty())
            {
                if(q.size()>0)
                s.push(q.dequeue())
            }
            System.out.println();
            count++;
        }
      }


12.B
complexity same
using two stacks
public static void printZigZag(BinaryTreeNode<Integer> root) {

    //  best sol
  Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
      Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
      s1.push(root);
      int count=2;
      while(!s1.isEmpty())
      {
        BinaryTreeNode<Integer> tmp = s1.pop();
        if(count%2==0)
        System.out.print(tmp.data+" ");
        if(tmp.left!=null)
          s2.push(tmp.left);
          if(tmp.right!=null)
          s2.push(tmp.right);
          if(s1.isEmpty())
          {System.out.println();
            while(!s2.isEmpty())
            {
              BinaryTreeNode<Integer> tmp1= s2.pop();
                s1.push(tmp1);
                if(count%2==0)
                System.out.print(tmp1.data+" ");
            }
            // System.out.println();
            count++;
          }  
      }
   }}
 
   

  13.                      NODES WITOUT SIBLINGS
  O(n)
  import java.util.ArrayList;
  public class Solution {
  
      public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
          
        if(root==null)
            return ;
         
          if(root.left==null||root.right==null)
              if(root.right!=null)
                  System.out.println(root.right.data);
          }
          printNodesWithoutSibling(root.left);
          printNodesWithoutSibling(root.right);
  
      }
  }

  14. iterartive                     LEFT VIEW OF THE TREE


  public static void leftview(BinaryTreeNode<Integer> root)
  {
    Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
    q.add(root);
    while(1==1)
    {
        int s = q.size();
        System.out.print(q.peek()+" ");
        if(0==s)
        return;
        while(s-->0)
        {
            BinaryTreeNode<Integer> tmp = q.poll();
            if(tmp.left!=null)
            {
                q.add(tmp.left);
            }
            if(tmp.right!=null)
            {
                q.add(tmp.right);
            }
        }
    }
  }

  14.B iterative
  static void leftViewUtil( node root ) 
{ 
    if (root == null) 
        return; 
  
    // add root 
    q.add(root); 
  
    // Delimiter 
    q.add(null); 
  
    while (q.size() > 0)  
    { 
        node temp = q.peek(); 
  
        if (temp != null) 
        { 
  
            // Prints first node 
            // of each level 
            System.out.print(temp.data + " "); 
  
            // add children of all nodes at 
            // current level 
            while (q.peek() != null) 
            { 
  
                // If left child is present 
                // add into queue 
                if (temp.left != null) 
                    q.add(temp.left); 
  
                // If right child is present 
                // add into queue 
                if (temp.right != null) 
                    q.add(temp.right); 
  
                // remove the current node 
                q.remove(); 
  
                temp = q.peek(); 
            } 
  
            // add delimiter 
            // for the next level 
            q.add(null); 
        } 
  
        // remove the delimiter of 
        // the previous level 
        q.remove(); 
    } 
} 

14C. Recursive
class BinaryTree { 
    Node root; 
    static int max_level = 0; 
  
    // recursive function to print left view 
    void leftViewUtil(Node node, int level) 
    { if(root==null)
        return ; 
      if(max_level< level)
     {  System.out.print(node.data+" ");
       max_level = level;}

       leftViewUtil(node.left, level + 1); 
        leftViewUtil(node.right, level + 1);
    }


    15.                          PRINT BOTTOM OF THE TREE 
   this is not working
    public static void botttom(BinaryTreeNode<Integer> root)
    {
        Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> q2 = new LinkedList<>();
        q1.add(root);
        while(1==1)
        {
            int s = q1.size();
            q2 = q1;

            if(0==s)
            return;
            int count1 = 0;
            while(s-->0)
            {   
                count1++;
                BinaryTreeNode<Integer> ele = q1.poll();
                if(ele.left!=null)
                 q1.add(ele.left);
                 if(ele.right!=null)
                 q1.add(ele.right);

                 if(ele.left==null && ele.right==null)
                 {
                     System.out.print(ele.root+" ");
                 }
                //  count1-1<=count2<=count1+1
                if(count1==1)
                {
                    BinaryTreeNode<Integer> tmp = q2.peek();
                    if(tmp.right!==null)
                    {
                        tmp = tmp.right;
                        if(tmp.right==null && tmp.left == null)
                        System.out.print(ele.root);
                    }
                }
                 while(2-->0)
                 {
                     int a = count1-1;
                     int b = count1-a;
                     BinaryTreeNode<Integer> tmp = null;
                     while(a-->0)
                     {
                         tmp = q2.poll();
                     }
                     if(tmp.left==null || tmp.right==null)
                     System.out.print(ele.root+" ");
                     while(b-->0)
                     {
                        tmp = q2.poll();
                     }
                     if(tmp.left==null || tmp.right==null)
                     System.out.print(ele.root+" ");
                 }
            }
        }
        
    }

15 . B
this works
class Node 
{ 
    int data; //data of the node 
    int hd; //horizontal distance of the node 
    Node left, right; //left and right references 
  
    // Constructor of tree node 
    public Node(int key) 
    { 
        data = key; 
        hd = Integer.MAX_VALUE; 
        left = right = null; 
    } 
} 
  
//Tree class 
class Tree 
{ 
    Node root; //root node of tree 
  
    // Default constructor 
    public Tree() {} 
  
    // Parameterized tree constructor 
    public Tree(Node node) 
    { 
        root = node; 
    } 
  
    // Method that prints the bottom view. 
    public void bottomView() 
    { 
        if (root == null) 
            return; 
  
        // Initialize a variable 'hd' with 0 for the root element. 
        int hd = 0; 
  
        // TreeMap which stores key value pair sorted on key value 
        Map<Integer, Integer> map = new TreeMap<>(); 
  
         // Queue to store tree nodes in level order traversal 
        Queue<Node> queue = new LinkedList<Node>(); 
  
        // Assign initialized horizontal distance value to root 
        // node and add it to the queue. 
        root.hd = hd; 
        queue.add(root); 
  
        // Loop until the queue is empty (standard level order loop) 
        while (!queue.isEmpty()) 
        { 
            Node temp = queue.remove(); 
  
            // Extract the horizontal distance value from the 
            // dequeued tree node. 
            hd = temp.hd; 
  
            // Put the dequeued tree node to TreeMap having key 
            // as horizontal distance. Every time we find a node 
            // having same horizontal distance we need to replace 
            // the data in the map. 
            map.put(hd, temp.data); 
  
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd-1. 
            if (temp.left != null) 
            { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            } 
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd+1. 
            if (temp.right != null) 
            { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            } 
        } 
  
        // Extract the entries of map into a set to traverse 
        // an iterator over that. 
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
    } 
}

16.                         TOP VIEW OF A TREE
O(n)
public static void bottom(BinaryTreeNod<Integer> root) 
{ 
    if (root == null) 
        return; 

    // Initialize a variable 'hd' with 0 for the root element. 
    int hd = 0; 

    // TreeMap which stores key value pair sorted on key value 
    Map<Integer, Integer> map = new TreeMap<>(); 

     // Queue to store tree nodes in level order traversal 
    Queue<BinaryTreeNod<Integer>>  queue = new LinkedList<>(); 

    // Assign initialized horizontal distance value to root 
    // node and add it to the queue. 
    root.hd = hd; 
    queue.add(root); 

    // Loop until the queue is empty (standard level order loop) 
    while (!queue.isEmpty()) 
    { 
        BinaryTreeNod<Integer>  temp = queue.remove(); 

        // Extract the horizontal distance value from the 
        // dequeued tree node. 
        hd = temp.hd; 

        // Put the dequeued tree node to TreeMap having key 
        // as horizontal distance. Every time we find a node 
        // having same horizontal distance we need to replace 
        // the data in the map. 
        if(!map.containsKey(hd))
        map.put(hd, temp.data); 

        // If the dequeued node has a left child add it to the 
        // queue with a horizontal distance hd-1. 
        if (temp.left != null) 
        { 
            temp.left.hd = hd-1; 
            queue.add(temp.left); 
        } 
        // If the dequeued node has a left child add it to the 
        // queue with a horizontal distance hd+1. 
        if (temp.right != null) 
        { 
            temp.right.hd = hd+1; 
            queue.add(temp.right); 
        } 
    } 

    // Extract the entries of map into a set to traverse 
    // an iterator over that. 
    Set<Entry<Integer, Integer>> set = map.entrySet(); 

    // Make an iterator 
    Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 

    // Traverse the map elements using the iterator. 
    while (iterator.hasNext()) 
    { 
        Map.Entry<Integer, Integer> me = iterator.next(); 
        System.out.print(me.getValue()+" "); 
    } 
} 
}

// 1 2 3 -1 4 -1 -1 -1 5 -1 6 -1 -1

16.B try it recur version
https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
working in compiker  code
class View
{
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
       class QueueObj
        {
            Node node;
            int hd;
            QueueObj(Node node,int hd)
            {
             this.node = node;
             this.hd = hd; 
            }
        }        
          Queue<QueueObj> q = new LinkedList<QueueObj>();
          Map<Integer , Node> map1 = new TreeMap<>();
          q.add(new QueueObj(root,0));
        
        
        while(!q.isEmpty())
        {
            QueueObj ele = q.poll();
            
            if(!map1.containsKey(ele.hd))
            {
                map1.put(ele.hd , ele.node);
            }
            
            if(ele.node.left!=null)
            {
              q.add(new QueueObj(ele.node.left,ele.hd-1));   
            }
            if(ele.node.right!=null)
            {
                q.add(new QueueObj(ele.node.right,ele.hd+1));
            }
        }
        for(Map.Entry<Integer,Node> me:map1.entrySet()){
            System.out.print(me.getValue().data+" ");
        }
    }
}


17.                             FIND LCA

18.                             TREES ARE IDENTICAL OR NOT
https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
(n) < O(m) = O(n)
boolean identicalTrees(Node a, Node b)  
    { 
      if(a==null && b== null )
       return true;
       

    //    if(a.data!=b.data)
    //     return false;

        if( a!=null && b!=null )
            return
     (a.data==b.data identicalTrees(a.left,b.left) && identicalTrees(a.right,b.right));
    return false;
    }    

19.                              MAXIMUMM PATH SUM
o(N)   
https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/                
int findMaxUtil(Node node, Res res) 
    { 
  
        // Base Case 
        if (node == null) 
            return 0; 
  
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int l = findMaxUtil(node.left, res); 
        int r = findMaxUtil(node.right, res); 
  
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(l, r) + node.data, 
                                  node.data); 
  
  
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, l + r + node.data); 
  
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    }     


    20.                     FLATTERBNN A BINARRY TREE INTO LINKED LIST
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    https://www.youtube.com/watch?v=vssbwPkarPQ
    O(n)
    while(!s.isEmpty())
    {
        Stack<TreeNode> node = s.pop();
        if(node.right!=null)
        {
            s.push(node.right);
        }
        if(node.left!=null)
        {
            s.push(node.left);
        }
        if(!s.isEmpty())
        {
            node.right = s.peek();
        }
        node.left = null;
    }
