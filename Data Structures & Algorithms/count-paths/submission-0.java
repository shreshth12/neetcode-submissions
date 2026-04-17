class Solution {
    public int uniquePaths(int m, int n) {
        // Create a array to store the paths possible
        // to traverse starting from bottom most row
        int[] prevRow = new int[n];

        // Start building to the top (bottom-up)
        for(int i = m - 1; i >= 0; i--){
            // Compute current row's values for paths
            // Where the end will always have 1 path
            // coming from the top
            int[] currRow = new int[n];
            currRow[n - 1] = 1;
            for(int j = n - 2; j >= 0; j--){
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }

        // Our computed unique paths from grid[0][0] would be at 
        // prevRow's 0th index
        return prevRow[0];
    }
}
