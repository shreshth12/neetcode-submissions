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
    // Create a variable to store the preOrder node index
    int preOrderNodeIndex = 0;

    // Create a hashmap to store the index of each value in inOrder array
    HashMap<Integer, Integer> indiciesInOrder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Go through each index in inOrder array and add it to the map
        for(int i = 0; i < inorder.length; i++){
            indiciesInOrder.put(inorder[i], i);
        }

        // Run the dfs method to construct the tree and return the root
        return dfs(preorder, 0, preorder.length - 1);
    }

    // Create a method to recursively build the tree
    private TreeNode dfs(int[] preorder, int left, int right){
        // Base case: If the pointers overlap, that is if there
        // are no more nodes to process, return
        if(left > right){
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(preorder[preOrderNodeIndex++]);

        // Get the splitting point
        int splitPoint = indiciesInOrder.get(root.val);

        // Create the left and right children
        root.left = dfs(preorder, left, splitPoint - 1);
        root.right = dfs(preorder, splitPoint + 1, right);

        // Return the root
        return root;
    }
}
