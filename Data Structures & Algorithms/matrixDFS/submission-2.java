class Solution {
    // Global variable to keep track of the total unique paths
    private int uniquePaths = 0;

    // Global set to keep track of visited coordinates
    private Set<List<Integer>> visited = new HashSet<>();

    public int countPaths(int[][] grid) {
        // For each instance of the class, reset it
        uniquePaths = 0;
        dfs(grid, 0, 0);
        return uniquePaths;
    }

    private void dfs(int[][] grid, int row, int column){
        // If out of bounds/grid, or if an obstacle,
        // or if the current coordinates are visted
        // then return 0, as a path cannot be formed
        if(Math.min(row, column) < 0 || 
            row >= grid.length ||
            column >= grid[0].length ||
            grid[row][column] != 0 ||
            visited.contains(Arrays.asList(row, column))
        ){
            return;
        }

        // Check if we reached the bottom-right
        else if(row == grid.length - 1 && column == grid[0].length - 1){
            uniquePaths++;
            return;
        }

        // A path can be formed, so add the current coordinates
        // as being visited and then continue up/down/left/right
        visited.add(Arrays.asList(row, column));
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
        visited.remove(Arrays.asList(row, column));
    }
}
