class Solution {
    // Global variable/set to keep track of the path currently being visited
    Set<List<Integer>> visited = new HashSet<>();

    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int row, int column){
        // If out of bounds/grid, or if an obstacle,
        // or if the current coordinates are visted
        // then return 0, as a path cannot be formed
        if(Math.min(row, column) < 0 || 
            row >= grid.length ||
            column >= grid[0].length ||
            grid[row][column] != 0 ||
            visited.contains(Arrays.asList(row, column))
        ){
            return 0;
        }

        // Check if we reached the bottom-right
        else if(row == grid.length - 1 && column == grid[0].length - 1){
            return 1;
        }

        // Variable to keep track of unique paths found
        int uniquePaths = 0;

        // A path can be formed, so add the current coordinates
        // as being visited and then continue up/down/left/right
        visited.add(Arrays.asList(row, column));
        uniquePaths += dfs(grid, row + 1, column);
        uniquePaths += dfs(grid, row - 1, column);
        uniquePaths += dfs(grid, row, column + 1);
        uniquePaths += dfs(grid, row, column - 1);
        visited.remove(Arrays.asList(row, column));

        return uniquePaths;
    }
}
