import java.util.*;
import java.io.*;

public class bst{
    public static Scanner in = new Scanner(System.in);
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

      public static int size(Node node) {
        // write your code here
        if(node==null) return 0;
        int leftsize= size(node.left);
        int rightsize = size(node.right);
        return leftsize+rightsize+1;
      }
    
      public static int sum(Node node) {
        // write your code here
        if(node==null) return 0;
        int leftsum = sum(node.left);
        int rightsum = sum(node.right);
        return leftsum+rightsum+node.data;
      }
    
      public static int max(Node node) {
        // write your code here
       Node curr= node;
       while(curr.right!=null){
           curr=curr.right;
       }
       return curr.data;
      }
    
      public static int min(Node node) {
        // write your code here
        Node curr= node;
       while(curr.left!=null){
           curr=curr.left;
       }
       return curr.data;
       
      }
     
      public static boolean find(Node node, int data){
        // write your code here
        Node curr = node;
        while(curr!=null){
            if(curr.data==data) return true;
            else if(curr.data<data) curr=curr.right;
            else curr=curr.left;
        }
        return false;
      }  

      public static Node add(Node node,int data){
          if(node==null) return new Node(data,null,null);
          if(node.data<data){
              node.right=add(node.right,data);
          }else if(node.data>data){
              node.left= add(node.left,data);
          }
          return node;
      }

      public static Node addItr(Node node,int data){
          if(node==null) return new Node(data,null,null);
          Node curr= node;
          Node dNode= new Node(data,null,null);
          while(true){
              if(curr.data==data) break;
             else  if(curr.data<data){
                  if(curr.right!=null){
                    curr= curr.right;
                  }else {
                      curr.right = dNode;
                      break;
                  }
              }else{
                  if(curr.left!=null){
                      curr=curr.left;
                  }else{
                      curr.left=dNode;
                      break;
                  }
              }
          }
          return node;
      }
     
  
    public static Node remove(Node node, int data) {
      // write your code here
      if(node==null){
          return null;
      }
      if(data<node.data){
          node.left= remove(node.left,data);
      }else if(data>node.data){
          node.right = remove(node.right,data);
      }else{
          if(node.left!=null && node.right!=null){
              int lca = max(node.left);
              node.data= lca;
              node.left = remove(node.left,lca);
              return node;
          }else if(node.left!=null){
              return node.left;
          }else if(node.right!=null){
              return node.right;
          }else {
              return null;
          }
      }
      return node;
    }

    
  public static void printInRange(Node node, int d1, int d2) {
    // write your code here
    if(node==null) return;
    printInRange(node.left,d1,d2);
    if(node.data>=d1 && node.data<=d2){
        System.out.println(node.data);
    }
    printInRange(node.right,d1,d2);
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
        boolean res= find(root,70);
        // int ht = heightNode(root);
        // int hte = heightEdge(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(res);
        // System.out.println(ht);
        // System.out.println(hte);
        // traversal(root);
      }
}
/*
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
*/