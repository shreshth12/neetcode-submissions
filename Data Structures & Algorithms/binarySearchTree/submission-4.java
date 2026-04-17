// Class to create a treeNode
class TreeNode {
    int key;
    int val;
    TreeNode left; // Defaults to null
    TreeNode right; // Defaults to null

    public TreeNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}


class TreeMap {
    // Create a root node for the map
    private TreeNode root;

    public TreeMap() {
        // Initially the TreeMap is a null node
        this.root = null;
    }

    public void insert(int key, int val) {
        // Create a pointer to iterate in the tree
        TreeNode curr = this.root;

        // Create a TreeNode object with given key, val
        TreeNode newNode = new TreeNode(key, val);

        // If the map is empty, add the current node directly
        if(this.root == null){
            this.root = newNode;
        }

        while(curr != null){
            // If the given key is smaller than
            // the curr key then move towards left
            if(key < curr.key){
                // Check if we can insert on left
                if(curr.left == null){
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            }

            // Else move towards right
            else if(key > curr.key){
                // Check if we can insert on the right
                if(curr.right == null){
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            }

            // Check if its a collision
            else{
                curr.key = key;
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        // Create a pointer to iterate in the tree
        TreeNode curr = this.root;

        while(curr != null){
            // Check if the curr node is the key
            // if yes, return it
            if(curr.key == key){
                return curr.val;
            }
            // If the given key is smaller than the curr key
            // then move towards left
            else if(key < curr.key){
                curr = curr.left;
            }

            // Else move towards right
            else{
                curr = curr.right;
            }
        }

        // If we never returned, meaning key was never found, or current node is null 
        return -1;
    }

    public int getMin() {
        // Create a pointer to iterate in the tree
        TreeNode curr = this.root;

        // If the current node is null, return -1
        if(curr == null){
            return -1;
        }

        // Since the smallest key would be on the leftMost side, move there
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.val;
    }

    public int getMax() {
        // Create a pointer to iterate in the tree
        TreeNode curr = this.root;

        // If the current node is null, return -1
        if(curr == null){
            return -1;
        }

        // Since the smallest key would be on the rightMost side, move there
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.val;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    public List<Integer> getInorderKeys() {
        // Create an array to store the keys
        List<Integer> keys = new ArrayList<>();

        // Create a stack to perform dfs on the tree
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();

        // Create a pointer to iterate over the tree
        TreeNode curr = this.root;

        // Perform dfs | in-order traversal of the tree
        while(!stack.isEmpty() || curr != null){
            // Keep going left as long as we can
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }

            // Pop from the stack and add it to keys
            TreeNode node = stack.remove(stack.size() - 1);
            keys.add(node.key);
            curr = node.right;
        }

        // Return the list of keys
        return keys;
    }

    private TreeNode removeHelper(TreeNode root, int key){
        // If the root is empty, return
        if(root == null){return root;}

        // If the key is larger than current root key, go right
        if(key > root.key){
            root.right = removeHelper(root.right, key);
        }

        // If the key is smaller than current root key, go left
        else if(key < root.key){
            root.left = removeHelper(root.left, key);
        }

        // Else we found the key
        else{
            // Three scenarios :-
            // 1) The found key is a leaf node, simply return null
            // 2) The found key has a single child, replace with the non-null node
            // 3) The found key has two children, swap it with largest on leftside
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                // Get the largest leftSide node
                TreeNode largestLeftSide = getLargest(root.left);
                
                // Swap it with current one
                root.key = largestLeftSide.key;
                root.val = largestLeftSide.val;

                // Remove the leftSide largest one
                root.left = removeHelper(root.left, largestLeftSide.key);
            }
        }

        // Return the rool
        return root;
    }

    private TreeNode getLargest(TreeNode root){
        while(root != null && root.right != null){
            root = root.right;
        }
        return root;
    }
}
