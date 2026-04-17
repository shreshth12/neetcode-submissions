// import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Create a stack to keep track of the roots to process
        // And a variable to keep track of the num of nodes processed
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        int processed = 0;
        
        // Perform a DFS on the binaryTree
        while(!stack.isEmpty() || root != null){
            // Go to the leftmost node
            while(root != null){
                stack.add(root);
                root = root.left;
            }

            // Pop the node from the stack
            TreeNode currNode = stack.remove(stack.size() - 1);
            
            // Increment the number of node we have processed
            // And check if its the kth node we were looking for
            // Since its a in-order DFS, we will look at the nodes
            // in a smallest to largest fashion
            if(++processed == k){
                return currNode.val;
            }

            // Move the root pointer to the right child, so it can be processed
            root = currNode.right;
        }

        // If there was no root to process
        return root.val;
    }
}
