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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        PreOrder: root -> left -> right
        InOrder: left -> root -> right
        preorder = [1,2,3,4], inorder = [2,1,3,4]

        Everytime we get the root from the preorder array, we are able to find out
        how many nodes have to go to the left side of the array and right side of 
        array by looking at the inorder array.

        For example, the root in 1st iteration is "1" from preorder, that implies
        that {2} is the left side view of the tree and {3,4} is the right side
        view of the tree. We recursively use this formula to construct the tree.
        */

        // Base case: If either of the arrays are empty, tree formed in null
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(preorder[0]);

        int splitPoint = -1; // Initialize with -1 to indicate not found

        // Iterate through the array to find the split point
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                splitPoint = i;
                break; // Exit the loop once the value is found
            }
        }

        // Split the inorder and preorder arrays and pass them to recursively form the tree
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, splitPoint + 1), Arrays.copyOfRange(inorder, 0, splitPoint));
        root.right = buildTree(Arrays.copyOfRange(preorder, splitPoint + 1, preorder.length), Arrays.copyOfRange(inorder, splitPoint + 1, inorder.length));

        // Return the root
        return root;
    }
}
