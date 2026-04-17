class Solution {
    public int orangesRotting(int[][] grid) {
        // Get the length of the row and column of the grid
        int LENGTH_ROW = grid.length;
        int LENGTH_COLUMN = grid[0].length;

        // If the grid does not exist, or it is empty
        // meaning there, are no fruits to consider
        if (grid == null || grid.length == 0) {return -1;}

        // Boolean array to keep track of visited coordinates
        boolean[][] visited = new boolean[LENGTH_ROW][LENGTH_COLUMN];

        // Create a deque to keep track of coordinates to process
        // and a variable to keep track of fresh fruits in the grid
        Queue<int[]> deque = new ArrayDeque<>();
        int freshFruits = 0;

        // Go through each of the coordinates to find ones with rotten fruits
        for(int r = 0; r < LENGTH_ROW; r++){
            for(int c = 0; c < LENGTH_COLUMN; c++){
                if(grid[r][c] == 2){
                    deque.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
                else if(grid[r][c] == 1){freshFruits++;}
            }
        }

        // Process all the fruits around rotten fruits
        int processedMinute = 0;
        while(!deque.isEmpty()){
            if(freshFruits == 0){return processedMinute;}

            // Go through each rotten fruit and make the adjacent one rotten
            int currRottenFruits = deque.size();
            for(int i = 0; i < currRottenFruits; i++){
                int[] currentRottenFriutCoordinates = deque.poll();
                int currRow = currentRottenFriutCoordinates[0];
                int currCol = currentRottenFriutCoordinates[1];

                // Vertical and horizontal columns to look at
                int[][] nextCoordinates = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
                };

                for (int[] increment : nextCoordinates) {
                    int nextRow = currRow + increment[0];
                    int nextCol = currCol + increment[1];
                    if (
                        (nextRow >= 0) &&
                        (nextCol >= 0) &&
                        (nextRow < LENGTH_ROW) &&
                        (nextCol < LENGTH_COLUMN) &&
                        (grid[nextRow][nextCol] == 1) &&
                        (visited[nextRow][nextCol] != true)
                    ) {
                        // Adjacent fruits get rotten and get sent into the queue to process
                        freshFruits--;
                        visited[nextRow][nextCol] = true;
                        deque.offer(new int[]{nextRow, nextCol});
                    }
                }
            }

            // Processing cycle complete, hence increment the minute
            processedMinute++;

        }

        // If we never returned minutes that it took to process, it means
        // either all fresh fruits didn't rot or there were not rotten fruits
        // in the first place
        return (freshFruits == 0) ? processedMinute : -1;
    }
}
