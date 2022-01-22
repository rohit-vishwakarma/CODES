package Tree;

import java.util.ArrayList;

public class traversal {
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }

    public static ArrayList<Integer> morrisInOrderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation area
                    rightMostNode.right = curr; // thread is created
                    curr = curr.left;
                } else {
                    // thread destroy area
                    rightMostNode.right = null; // thread destroyed
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> morrisPreOrderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation area
                    rightMostNode.right = curr; // thread is created
                    ans.add(curr.val);
                    curr = curr.left;
                } else {
                    // thread destroy area
                    rightMostNode.right = null; // thread destroyed

                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    // Validate BST

    public static boolean isValidBST(TreeNode root, TreeNode[] prev) {
        if (root == null)
            return true;

        if (!isValidBST(root.left, prev))
            return false;

        if (prev[0] != null && prev[0].val >= root.val)
            return false;

        prev[0] = root;

        if (!isValidBST(root.right, prev))
            return false;

        return true;
    }

    public static boolean isValidBST_02(TreeNode root, TreeNode[] prev) {
        TreeNode curr = root;
        // ArrayList<Integer> ans = new ArrayList<>();
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if(prev[0].val >= curr.val) return false;
                prev[0] = curr;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    if(prev[0].val >= curr.val) return false;
                prev[0] = curr;
                    curr = curr.right;
                }
            }
        }
       
        return true;
    }

    public static int KthLargestNode(TreeNode root, int k) {
        TreeNode curr = root;
        // ArrayList<Integer> ans = new ArrayList<>();
        while (curr != null) {
            TreeNode left = curr.left;
            if(left==null){
               if(--k == 0) return curr.val;
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    if(--k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}