package Binarytree;

 public class  BinaryTreeNode<T>
{
    
    BinaryTreeNode(T data)
    {
        this.data=data;
    }
    
   T data;
   BinaryTreeNode<T> left;
   BinaryTreeNode<T> right;
}