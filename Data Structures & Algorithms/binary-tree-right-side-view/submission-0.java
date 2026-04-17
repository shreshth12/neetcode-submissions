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
    public List<Integer> rightSideView(TreeNode root) {
        // Create a deque to store the nodes for processing
        Deque<TreeNode> deque = new ArrayDeque<>();

        // Create an Array to store the results of processing
        ArrayList<Integer> inOrderTraversal = new ArrayList<>();

        // If the root is empty, return
        if(root == null){
            return inOrderTraversal;
        }

        // Add the root and start processing level by level
        deque.add(root);

        while(!deque.isEmpty()){
            // Get the size of the current level
            int currLevelSize = deque.size();

            // Get all the nodes of current level
            for(int i = 0; i < currLevelSize; i++){
                TreeNode currTreeNode = deque.removeFirst();

                if(currTreeNode.left != null){
                    deque.add(currTreeNode.left);
                }
                
                // Check if has children
                if(currTreeNode.right != null){
                    deque.add(currTreeNode.right);
                }
                
                // Only add if its the ending element
                if(i == currLevelSize - 1){
                    inOrderTraversal.add(currTreeNode.val);
                }   
            }
        }

        // Return the final output
        return inOrderTraversal;
    }
}
