package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;

// import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.LinkedList;

public class Diaset {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;
       Node parent = null;
        Node(int data) {
            this.data = data;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int diameter_01(TreeNode root) {
        if (root == null)
            return 0;
        int ld = diameter_01(root.left);
        int rd = diameter_01(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(Math.max(ld, rd), lh + rh + 2);
    }

    // {diameter,height}
    public static int[] diameter_02(TreeNode root) {
        if (root == null) {
            return new int[] { 0, -1 };
        }

        int[] lp = diameter_02(root.left);
        int[] rp = diameter_02(root.right);

        int[] myAns = new int[2];
        myAns[0] = Math.max(Math.max(lp[0], rp[0]), lp[1] + rp[1] + 2);
        myAns[1] = Math.max(lp[1], rp[1]) + 1;

        return myAns;
    }

    public static int diameter_03(TreeNode root, int[] dia) {
        if (root == null)
            return -1;

        int lh = diameter_03(root.left, dia);
        int rh = diameter_03(root.right, dia);

        dia[0] = Math.max(dia[0], lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    // leetcode 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0 ? true : false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    // leetcode 113
    public void pathSum(TreeNode root, int targetSum, List<Integer> smallAns, List<List<Integer>> ans) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            base.add(root.val);
            ans.add(base);
            return;
        }

        smallAns.add(root.val);

        pathSum(root.left, targetSum - root.val, smallAns, ans);
        pathSum(root.right, targetSum - root.val, smallAns, ans);

        smallAns.remove(smallAns.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        pathSum(root, targetSum, smallAns, ans);
        return ans;

    }

    public static class leafToLeafPair {
        int LTLMaxSum = -(int) 1e9; // Leaves to Leaves Max Sum
        int NTLMaxSum = -(int) 1e9; // Node to Leaves Max Sum.
    }

    public static leafToLeafPair maxLeafSum(Node root) {
        if (root == null) {
            return new leafToLeafPair();
        }

        if (root.left == null && root.right == null) {
            leafToLeafPair base = new leafToLeafPair();
            base.NTLMaxSum = root.data;
            return base;
        }

        leafToLeafPair lRes = maxLeafSum(root.left);
        leafToLeafPair rRes = maxLeafSum(root.right);

        leafToLeafPair myRes = new leafToLeafPair();
        myRes.LTLMaxSum = Math.max(lRes.LTLMaxSum, rRes.LTLMaxSum);

        if (root.left != null && root.right != null) {
            myRes.LTLMaxSum = Math.max(myRes.LTLMaxSum, lRes.NTLMaxSum + root.data + rRes.NTLMaxSum);
        }

        myRes.NTLMaxSum = Math.max(lRes.NTLMaxSum, rRes.NTLMaxSum) + root.data;
        return myRes;
    }

    int maxPathSum(Node root) {
        int ans = maxLeafSum(root).LTLMaxSum;
        int ans2 = maxLeafSum(root).NTLMaxSum;

        return ans != -(int) 1e9 ? ans : Math.max(ans, ans2);
    }
// Leetcode 124
    public class NTNpair{
        int maxPossibleAns = -(int)1e9;
        int NTNMaxSum = 0;
    }

    public int getMax(int... arr){
        int maxEle = arr[0];
        for(int ele : arr){
            maxEle = Math.max(maxEle, ele);
        }
        return maxEle;
    }

    public NTNpair maxPathSum02(TreeNode root){
        NTNpair myAns = new NTNpair();
        if(root == null){
            return myAns;
        }
        NTNpair left = maxPathSum02(root.left);
        NTNpair right = maxPathSum02(root.right);

        int oneSidemax = Math.max(left.NTNMaxSum, right.NTNMaxSum) + root.val;
        myAns.maxPossibleAns = getMax(left.maxPossibleAns, right.maxPossibleAns, root.val, oneSidemax, left.NTNMaxSum +root.val+ right.NTNMaxSum);

        myAns.NTNMaxSum = Math.max(oneSidemax, root.val);

        return myAns;

    }

    public int maxPathSum(TreeNode root){
        return maxPathSum02(root).maxPossibleAns;
    }

    //Leetcode 968
     // -1: camera required, 0: camera covered, 1: have a camera
     public int minCameraCover_(TreeNode root, int[] countOfCamera) {
        if(root == null){
            return 0;
        }
         int lr = minCameraCover_(root.left, countOfCamera);
         int rr = minCameraCover_(root.right, countOfCamera);
         
         if(lr == -1 || rr == -1){
             countOfCamera[0]++;
             return 1;
         }
         if(lr ==1 || rr==1){
             return 0;
         }
         return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        int[] countOfCamera = new int[1];
        int Myans = minCameraCover_(root, countOfCamera);
        if(Myans == -1){
            countOfCamera[0]++;
        }
        return countOfCamera[0];
    }

    // leetcode 337
    public int[] houseRobIII(TreeNode root){
        if(root == null){
            return new int[2];
        }
        
        int[] lr = houseRobIII(root.left);
        int[] rr = houseRobIII(root.right);
        
        int[] myans = new int[2];
        myans[0] = lr[1] + rr[1]+ root.val;
        myans[1]= Math.max(lr[0], lr[1])+ Math.max(rr[0],rr[1]);
        
        return myans;
    }
    
    public int rob(TreeNode root) {
       int[] ans = houseRobIII(root);
        
        return Math.max(ans[0], ans[1]);
           
      }

    //leetcode 1372

    public int[] longestZigZag_(TreeNode root) {
        if(root == null){
            return new int[]{-1,-1,-1};
        }
        int[] lans = longestZigZag_(root.left);
        int[] rans = longestZigZag_(root.right);
        
        int[] myans = new int[3];
        myans[0] = lans[1]+1;
        myans[1] = rans[0]+1;
        myans[2]= Math.max(Math.max(lans[2],rans[2]), Math.max(myans[0], myans[1]));
        
        return myans;
        
    }
    public int longestZigZag(TreeNode root) {
        int[] myans = longestZigZag_(root);
        return myans[2];
    }

    // leetcode 889

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n=pre.length;
        return construct(pre,0,n-1,post,0,n-1);
    }
    
    public TreeNode construct(int[] pre,int psi,int pei,int[] post,int ppsi,int ppei){
        if(psi>pei) return null;
        
        TreeNode root=new TreeNode(pre[psi]);
        if(psi==pei) return root;
        int idx=ppsi;
        while(post[idx]!=pre[psi+1]) idx++;
        
        int tnel=idx-ppsi+1;
        root.left=construct(pre,psi+1,psi+tnel,post,ppsi,idx);
        root.right=construct(pre,psi+tnel+1,pei,post,idx+1,ppei+1);
        
        return root;
    }

    // leetcode 297

    public void serializePreorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val + " ");
        serializePreorder(root.left, sb);
        serializePreorder(root.right, sb);
    }

    public String serializePreorder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreorder(root, sb);
        return sb.toString();
    }

    public TreeNode deserializePreorder(String[] arr, int[] idx) {
        if (idx[0] > arr.length || arr[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        int i = idx[0]++;
        int val = Integer.parseInt(arr[i]);
        TreeNode root = new TreeNode(val);
        root.left = deserializePreorder(arr, idx);
        root.right = deserializePreorder(arr, idx);

        return root;
    }

    public TreeNode deserializePreorder(String str) {
        String[] arr = str.split(" ");
        int[] idx = new int[1];

        return deserializePreorder(arr, idx);
    }

    public String serializeLevelorder(TreeNode root) {
        if (root == null)
            return "";
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        StringBuilder sb = new StringBuilder();

        while (que.size() != 0) {
            TreeNode rnode = que.removeFirst();
            if (rnode == null) {
                sb.append("# ");
                continue;
            } else
                sb.append(rnode.val + " ");

            que.addLast(rnode.left);
            que.addLast(rnode.right);
        }

        return sb.toString();
    }

    public TreeNode deserializeLevelorder(String str) {
        if (str.length() == 0)
            return null;

        LinkedList<TreeNode> que = new LinkedList<>();
        String[] arr = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        que.addLast(root);

        int i = 1, n = arr.length;
        while (i < n) {
            TreeNode rnode = que.removeFirst();
            if (i < n && !arr[i].equals("#")) {
                TreeNode lci = new TreeNode(Integer.parseInt(arr[i]));
                rnode.left = lci;
                que.addLast(lci);
            }
            i++;

            if (i < n && !arr[i].equals("#")) {
                TreeNode rci = new TreeNode(Integer.parseInt(arr[i]));
                rnode.right = rci;
                que.addLast(rci);
            }
            i++;
        }

        return root;
    }
// inorder successor
    public Node inorderSuccessor(Node root) {

        // Node succ = null;
        Node right = root.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }

            return right;
        }

        while (root.parent != null && root.parent.left != root) {
            root = root.parent;
        }

        return root.parent;
    }

    // HomeWork Question:    https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1
    Node buildTree(int inord[], int level[])
    {
        //your code here
        int n = inord.length;
        Node root = helper(inord,level,0,n-1,n);
        return root;
    }
   
    
    Node helper(int in[], int lev[], int si, int ei, int len){
        if(len<=0) return null;
        Node root = new Node(lev[0]);
        
        int idx = 0;
        while(lev[0]!=in[idx]) idx++;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i= si; i<idx; i++){
            hs.add(in[i]);
        }
        int[] llevel = new int[hs.size()];
        int[] rlevel = new int[ei - si - hs.size() ];
        int li =0, ri =0;
        for(int i = 1 ; i<len ; i++){
            if(hs.contains(lev[i])){
                llevel[li++] = lev[i];
            }else{
                rlevel[ri++]= lev[i];
            }
        }
        root.left = helper(in, llevel, si, idx-1, idx - si);
        root.right = helper(in, rlevel, idx+1, ei, ei -idx);
        
        return root;
    }

    // https://www.geeksforgeeks.org/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree/

    public static boolean checkSameTree(int[] in, int[] pre, int[] post){
        int n = in.length;
        TreeNode root = preOrIn(pre, 0, n-1, in, 0, n-1);
        // ArrayList<Integer> pre2 = new ArrayList<>();
        ArrayList<Integer> post2 = new ArrayList<>();
        getPost(root, post2);
        // System.out.println(pre2);
        System.out.println(post2);
        for(int i=0; i<n; i++){
        //    System.out.println( pre[i]+"   "+post[i]);
        //    if(pre[i] != pre2.get(i)) return false;
           if(post[i]!=post2.get(i)) return false;
        }
        return true;
    }

    public static TreeNode preOrIn(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
        if (isi > iei)
            return null;
        int idx = isi;
        while (in[idx] != pre[psi])
            idx++;

        int tel = idx - isi;
        TreeNode root = new TreeNode(pre[psi]);

        root.left = preOrIn(pre, psi + 1, psi + tel, in, isi, idx - 1);
        root.right = preOrIn(pre, psi + tel + 1, pei, in, idx + 1, iei);

        return root;
    }

    // public static TreeNode buildBSTtreeInOrder(int[] arr, int si, int ei){
    //     if(si>ei) return null;
    //     int mid = (si+ei)/2;
    //     TreeNode root = new TreeNode(arr[mid]);
    //     root.left = buildtreeInOrder(arr,si, mid-1);
    //     root.right = buildtreeInOrder(arr, mid+1, ei);
    //     return root;
    // }
    public static void getPost(TreeNode root,   ArrayList<Integer> post){
        if(root == null ) return ;
       
        getPost(root.left,  post);
        
        getPost(root.right,  post);
        post.add(root.val);
    }

    public static ArrayList<Integer> AddedSum(TreeNode root){
        if(root == null) return new ArrayList<>();
        LinkedList<TreeNode> pq = new LinkedList<>();
        pq.addLast(root);
        ArrayList<Integer> ans = new ArrayList<>();
        int d=0,sum=0,sum1 = root.val;
        int level = 0;
        ans.add(0);
        ans.add(0);
        while(pq.size()!=0){
            int sz = pq.size();
            sum=0;
            for(int i=0; i<sz; i++){
                TreeNode rn = pq.removeFirst();
                sum+=root.val;
                if(root.left!=null) pq.addLast(root.left);
                if(root.right!=null) pq.addLast(root.right);
            }
            if(level == 1){
                d = sum - sum1;
                sum1 = sum;
            }
            if(level>2){
                int z = (sum1+d) - sum;
                ans.add(z);
            }
            level++;
        }
        return ans;
    }

    public static void main(String[] args){
    int inOrder[] = {4, 2, 5, 1, 3};
    int preOrder[] = {1, 5, 4, 3,2};
    int postOrder[] = {4, 1, 2, 3, 5};
    boolean res = checkSameTree(inOrder, preOrder, postOrder);
    System.out.println(res);
    }
}