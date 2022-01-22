import java.util.*;
import java.io.*;
public class generictree{
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

      public static int size(Node node){
        // write your code here
        int sz=0;
        for(Node child : node.children){
            sz+=size(child);
        }
        return sz+1;
      }

      public static int max(Node node) {
        // write your code here
        int max = -(int)1e8;
        for(Node child : node.children){
            max = Math.max(max(child),max);
        }
        max= Math.max(node.data,max);
        return max;
      }

      public static int height(Node node) {
        // write your code here
        int ht = -1;
        for(Node child : node.children){
            ht = Math.max(height(child),ht);
        }
        ht+=1;
        return ht;
      }

      public static boolean find(Node node, int data) {
        // write your code here
        if(node.data==data) return true;
        for(Node child: node.children){
            boolean f= find(child,data);
            if(f){
                return true;
            }
        }
        return false;
      }

      public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
        if(node.data==data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }
        for(Node child : node.children){
            ArrayList<Integer> ans = nodeToRootPath(child,data);
            if(ans.size()>0){
                ans.add(node.data);
                return ans;
            }
        }
        return new ArrayList<>();
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