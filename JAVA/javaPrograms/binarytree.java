import java.util.*;
import java.io.*;

public class binarytree{
    public static Scanner in= new Scanner(System.in);
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
          }
      }
    public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }

    public static void preOrder(Node root, ArrayList<Integer> ans){
        if(root==null){
            return ;
        }
        ans.add(root.data);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
       }
    public static void inOrder(Node root, ArrayList<Integer> ans){
        if(root==null){
            return ;
        }       
        inOrder(root.left,ans);
        ans.add(root.data);
        inOrder(root.right,ans);
       }
    public static void postOrder(Node root, ArrayList<Integer> ans){
        if(root==null){
            return ;
        }
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.data);
       }

    
    public static void traversal(Node root){
       ArrayList<Integer> a= new ArrayList<>();
       ArrayList<Integer> b= new ArrayList<>();
       ArrayList<Integer> c= new ArrayList<>();
       preOrder(root,a);
       inOrder(root,b);
       postOrder(root,c);
       System.out.println("Preorder:");
       System.out.print(a);
        System.out.println("\nInorder:");
       System.out.print(b);
       System.out.println("\nPostorder:");
        System.out.print(c);
       }

    public static int heightNode(Node root){
        if(root==null) return -1;
        int leftheight=heightNode(root.left);
        int rightheight= heightNode(root.right);

        return Math.max(leftheight,rightheight) + 1;
       }

    public static int heightEdge(Node root){
        if(root==null) return 0;
        int leftheight=heightEdge(root.left);
        int rightheight= heightEdge(root.right);

        return Math.max(leftheight,rightheight) + 1;

      }

    public static int max(Node root){
        if(root==null) return -(int)1e8;
        int leftmax=max(root.left);
        int rightmax= max(root.right);

        return Math.max(Math.max(leftmax,rightmax),root.data);
       }
    public static int min(Node root){
        if(root==null) return (int)1e8;
        int leftmin=min(root.left);
        int rightmin= min(root.right);

        return Math.min(Math.min(leftmin,rightmin),root.data);
       }

    public static int size(Node root) {
       if(root==null) return 0;
       int leftsize = size(root.left);
       int rightsize = size(root.right);

       return leftsize+rightsize+1;
      }
    
    public static int sum(Node root) {
       if(root==null) return 0;
       int leftsum= sum(root.left);
       int rightsum = sum(root.right);
       return leftsum+rightsum+root.data;
      }
    public static boolean findData(Node root, int data){
        if(root==null) return false;
        boolean res= root.data==data;
        return res || findData(root.left,data)|| findData(root.right,data);
      }
    public boolean rootToNodePath(Node root, int data, ArrayList<Node> ans){
        if(root==null) return false;
         boolean res= (root.data==data) ||  rootToNodePath(root.left, data, ans) ||  rootToNodePath(root.right, data, ans);
         if(res){
             ans.add(root);
         }
         return res;
     }
    public void printAtkDepth(Node root,int k, Node block, ArrayList<Integer> ans){
         if(root==null ||root==block|| k<0) return;
         if(k==0){
             ans.add(root.data);
         }
         printAtkDepth(root.left,k-1,block, ans);
         printAtkDepth(root.right,k-1, block, ans);
     }
     public ArrayList<Integer> distanceK(Node root, Node target, int K) {
      ArrayList<Node>  nodes=new ArrayList<>();
      boolean data=rootToNodePath(root, target.data, nodes);
      if(!data){
        System.out.println("No such node");
      }
      int n = nodes.size();
      Node block = null;
      ArrayList<Integer> result = new ArrayList<>();
      for(int i=0;i<n;i++){
         printAtkDepth(nodes.get(i), K-i, block, result);
         block=nodes.get(i);
      }
      return result;
      }
    
    public static Node removeLeaves(Node node){
      // write your code here
      if(node==null) return null;
      if(node.left==null && node.right==null) return null;
      node.left=removeLeaves(node.left);
      node.right=removeLeaves(node.right);
      return node;
      }

    public static void removeLeaves(Node node, Node par) {
      if (node == null)
          return;
      if (node.left == null && node.right == null) {
          if (par.left == node)
              par.left = null;
          else
              par.right = null;

          return;
      }

      removeLeaves(node.left, node);
      removeLeaves(node.right, node);
     }

  public static Node removeLeaves(Node node) {
    if (node.left == null && node.right == null)
        return null;
    removeLeaves(node, null);

    return node;
     }


    public static class isBSTSolPair {
      int maxEle = -(int) 1e8;
      int minEle = (int) 1e8;
      boolean isBST = true;
     }

  public static isBSTSolPair isBST_(Node node) {
      if (node == null) {
          // isBSTSolPair base = new isBSTSolPair();
          // return base;

          return new isBSTSolPair();
      }

      isBSTSolPair left = isBST_(node.left);
      isBSTSolPair right = isBST_(node.right);

      isBSTSolPair myRes = new isBSTSolPair();
      myRes.isBST = false;
      if (left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle) {
          myRes.isBST = true;
          myRes.maxEle = Math.max(node.data, right.maxEle);
          myRes.minEle = Math.min(node.data, left.minEle);
      }

      return myRes;
     }

  public static class isBalPair {
      int height = -1;
      boolean balanceTree = true;
  }
  public static isBalPair isBal_(Node node) {
      if (node == null)
          return new isBalPair();

      isBalPair left = isBal_(node.left);
      if (!left.balanceTree)
          return left;

      isBalPair right = isBal_(node.right);
      if (!right.balanceTree)
          return right;
      

      isBalPair myRes = new isBalPair();
      myRes.balanceTree = false;
      if (left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1) {
          myRes.balanceTree = true;
          myRes.height = Math.max(left.height, right.height) + 1;
      }

      return myRes;
  }
  public static boolean isBal(Node node) {
      isBalPair ans = isBal_(node);
      return ans.balanceTree;
  }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
    
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        int ht = heightNode(root);
        int hte = heightEdge(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(ht);
        System.out.println(hte);
        traversal(root);
      }
} 
/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
*/