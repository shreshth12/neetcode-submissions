/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Create a map to keep track the nodes that are created
    Map<Integer, Node> createdNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        // If the node is null, return
        if(node == null){return node;}

        // If the node has been created before, return its pointer
        if(createdNodes.containsKey(node.val)){return createdNodes.get(node.val);}
        
        // Make a copy of the current node
        // and add it to the hashmap
        Node copyNode = new Node(node.val);
        createdNodes.put(copyNode.val, copyNode);

        // Go through each of the neighbors of the current node, copy them
        // and put them as neighbors of the copyNode
        for(Node neighbor: node.neighbors){
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the copiedNode
        return copyNode;
    }
}