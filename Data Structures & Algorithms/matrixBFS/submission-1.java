class Solution {
    public int shortestPath(int[][] grid) {
        // Set to keep track of visited coordinates
        Set<List<Integer>> visited = new HashSet<>();

        // Queue to keep track of coordinates to process
        Queue<int[]> deque = new ArrayDeque<>();

        // If the grid is empty, return, else add the first coordinate
        if (grid == null || grid.length == 0) {
            return -1;
        }
        deque.offer(new int[]{0, 0, 0});

        // Create a variable to keep track of the shortest path length
        int shortestLength = Integer.MAX_VALUE;
        
        // Keep going down layer by layer until no more coordinates to process
        while (!deque.isEmpty()) {
            int lengthOfQueue = deque.size(); 

            for (int i = 0; i < lengthOfQueue; i++) {
                // Get the current coordinate and mark it as visited
                int[] currCoordinate = deque.poll();
                visited.add(Arrays.asList(currCoordinate[0], currCoordinate[1]));

                // Check if the current coordinate is a blocker
                if(grid[currCoordinate[0]][currCoordinate[1]] == 1){
                    continue;
                }

                // Check if the current coordinate is at bottom-right
                if (currCoordinate[0] == grid.length - 1 && currCoordinate[1] == grid[0].length - 1) {
                    shortestLength = Math.min(shortestLength, currCoordinate[2]);
                }

                // Possible movements
                int[][] nextIncrements = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
                };

                for (int[] increment : nextIncrements) {
                    int currRow = currCoordinate[0];
                    int currCol = currCoordinate[1];

                    if (
                        (currRow + increment[0] < 0) ||
                        (currCol + increment[1] < 0) ||
                        (currRow + increment[0] >= grid.length) ||
                        (currCol + increment[1] >= grid[0].length) ||
                        (visited.contains(Arrays.asList(currRow + increment[0], currCol + increment[1])))
                    ) {
                        continue;
                    }

                    // Offer the new coordinates into the queue
                    deque.offer(new int[]{currRow + increment[0], currCol + increment[1], currCoordinate[2] + 1});
                }
            }
        }
        return (shortestLength == Integer.MAX_VALUE) ? -1 : shortestLength;
    }
}