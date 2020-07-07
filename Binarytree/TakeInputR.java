package Binarytree;
import java.util.*;
public class TakeInputR {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput(s);
        s.close();
    }

    public static BinaryTreeNode<Integer> takeInput(Scanner s)
    {
       int rootData = s.nextInt();
       System.out.println("Enter root Data");
       if(rootData==-1)
       {
           return null;
       }
       BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
        
    }
    static void print(BinaryTreeNode<Integer> root)
}



