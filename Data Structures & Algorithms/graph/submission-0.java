class Graph {
    // Create instance variables
    Map<Integer, ArrayList<Integer>> adjacencyMatrix;

    public Graph() {
        adjacencyMatrix = new HashMap<>(); // Initilize the adjacency matrix for graph
    }

    public void addEdge(int src, int dst) {
        // Check if the source or destination does not exist, then add them
        if(!adjacencyMatrix.containsKey(src)){
            adjacencyMatrix.put(src, new ArrayList<>());
        }
        if(!adjacencyMatrix.containsKey(dst)){
            adjacencyMatrix.put(dst, new ArrayList<>());
        }
        
        // Add an edge from source to destination
        ArrayList<Integer> neighbors = adjacencyMatrix.get(src);
        neighbors.add(dst);
        adjacencyMatrix.put(src, neighbors);
    }

    public boolean removeEdge(int src, int dst) {
        // If the source or destination does not exist, return false
        // or if the edge doesn't even exist from source to destination
        if( !adjacencyMatrix.containsKey(src) ||
            !adjacencyMatrix.containsKey(dst) ||
            !adjacencyMatrix.get(src).contains(dst)
          ){return false;}

        // Remove the edge from source to destination
        ArrayList<Integer> neighbors = adjacencyMatrix.get(src);
        neighbors.remove(Integer.valueOf(dst));
        adjacencyMatrix.put(src, neighbors);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        // Create a queue to keep track of vertices to process
        // Create a set to keep track of visited vertices
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Add the source node in the queue to start processing
        bfsQueue.offer(src);
        visited.add(src);

        // While the queue is not empty, i.e a neighbor exists
        // keeping finding a path to dest
        while(!bfsQueue.isEmpty()){
            int currVertex = bfsQueue.poll();

            // If this is the destination vertex, found a path
            if(currVertex == dst){return true;}

            // Go through each neighbors and if they are not seen before
            // add them to the queue for processing
            ArrayList<Integer> currNeighbors = adjacencyMatrix.get(currVertex);
            for(int neighbor: currNeighbors){
                if(!visited.contains(neighbor)){
                    bfsQueue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        // If we never returned true, hence a path was not found, return false
        return false;
    }
}
