// A doubly linkedList class to create a cache using
private class listNode {
    listNode prev;    
    listNode next;
    int key;
    int val;

    public listNode(){}
    public listNode(int key, int value){
        this.key = key;
        this.val = value;
    }
}

class LRUCache {
    int capacity = 0;
    listNode leastRecentlyUsed;
    listNode mostRecentlyUsed;
    HashMap<Integer, listNode> cache; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.leastRecentlyUsed = new listNode();
        this.mostRecentlyUsed = new listNode();
        this.cache = new HashMap<Integer, listNode>();
        leastRecentlyUsed.next = mostRecentlyUsed;
        mostRecentlyUsed.prev = leastRecentlyUsed;
    }

    private void insert(listNode node){
        node.prev = mostRecentlyUsed.prev;
        node.next = mostRecentlyUsed;
        mostRecentlyUsed.prev.next = node;
        mostRecentlyUsed.prev = node;
        this.cache.put(node.key, node);
    }

    private void remove(listNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.cache.remove(node.key);
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            listNode foundNode = this.cache.get(key);
            // Make this key the most recently used
            remove(foundNode);
            insert(foundNode);
            return foundNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // If the key already exists, remove it.
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
        }

        listNode newNode = new listNode(key, value);
        insert(newNode);

        if(this.cache.size() > this.capacity){
            remove(this.leastRecentlyUsed.next);
        }
    }
}
