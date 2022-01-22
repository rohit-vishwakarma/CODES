import java.util.*;
public class tree{
    public static Scanner in= new Scanner(System.in);
    static class Node {
        int data;
        Node left=null;
        Node right=null;

        Node(int data){
            this.data = data;
        }
    }
    public static void insert(Node node, int data){
        if(data<node.data){
            if(node.left!=null){ insert(node.left,data);}
            else{
                node.left = new Node(data);
            }
        }else if(data > node.data){
            if(node.right!=null) insert(node.right,data);
            else{
                node.right = new Node(data);
            }
        }
    }
    public static int size(Node node){
        if(node==null) return 0;
        int leftsize = size(node.left);
        int rightsize = size(node.right);
        return leftsize+rightsize+1;
    }
    public static int sum(Node node){
        if(node==null) return 0;
        int leftsum = sum(node.left);
        int rightsum = sum(node.right);
        return leftsum+rightsum+node.data;
    }
    public static int max(Node node){
        if(node==null) return -(int)1e8;
        int leftmax = max(node.left);
        int rightmax = max(node.right);
        return Math.max(Math.max(leftmax,rightmax),node.data);
    }
    public static int min(Node node){
        if(node==null) return (int)1e8;
        int leftmin = min(node.left);
        int rightmin = min(node.right);
        return Math.min(Math.min(leftmin,rightmin),node.data);
    }
    public static void traversal(Node node){
        if(node!=null){
            traversal(node.left);
            System.out.print(node.data+" ");
            traversal(node.right);
        }
    }
    public static boolean findData(Node node, int data){
        if(node==null) return false;
        return node.data==data || findData(node.left,data)|| findData(node.right,data);
    }
    public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
    }
    public static void printKLevelsDown(Node node, int k){
        // write your code here
        if(node == null || k<0) return ;
        if(k==0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right, k-1);
    }
    public static Node removeLeaves(Node node){
        if(node==null) return null;
        if(node.left==null && node.right == null) return null;
        node.left=removeLeaves(node.left);
        node.right=removeLeaves(node.right);
        return node;
    }
    public static void main(String args[]){
        // tree t1 = new tree();
        int n = in.nextInt();
        Node root = new Node(in.nextInt());
        for(int i=0;i<n-1;i++){
            insert(root,in.nextInt());
        }
       
      int k=in.nextInt();
      System.out.println("Inorder Traversal:");
      tree.traversal(root);
      System.out.println();
      printKLevelsDown(root,k);
      display(root);
      System.out.println(findData(root,87));
    }
}
/*
9
50 25 12 37 30 75 62 70 87
3
*/