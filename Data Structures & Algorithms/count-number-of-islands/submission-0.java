class Solution {
    public int numIslands(char[][] grid) {
        // Set to keep track of visited coordinates
        Set<List<Integer>> visited = new HashSet<>();

        // Variable to keep track of the total unique paths
        int numberOfIslands = 0;

        // Go through each r, c in the grid
        // and if that is a land, mark it as
        // visited, along with all the connected parts
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c, visited);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
        
    }

    private void dfs(char[][] grid, int row, int column, Set<List<Integer>> visited){
        // If out of bounds/grid, or if an obstacle/water,
        // or if the current coordinates are visted
        // then return 0, as adjacent lands cannot be connected
        if(Math.min(row, column) < 0 || 
            row >= grid.length ||
            column >= grid[0].length ||
            grid[row][column] != '1' ||
            visited.contains(Arrays.asList(row, column))
        ){
            return;
        }        

        // A path can be formed, so add the current coordinates
        // as being visited and then continue up/down/left/right
        visited.add(Arrays.asList(row, column));
        grid[row][column] = '2';
        dfs(grid, row + 1, column, visited);
        dfs(grid, row - 1, column, visited);
        dfs(grid, row, column + 1, visited);
        dfs(grid, row, column - 1, visited);
        visited.remove(Arrays.asList(row, column));
    }
}
