class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Set<String> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit.add("0,0");

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] neighbor : neighbors) {
                    int dr = neighbor[0], dc = neighbor[1];
                    if (Math.min(r + dr, c + dc) < 0 ||
                        r + dr == ROWS || c + dc == COLS ||
                        visit.contains((r + dr) + "," + (c + dc)) || grid[r + dr][c + dc] == 1) {
                        continue;
                    }
                    queue.add(new int[]{r + dr, c + dc});
                    visit.add((r + dr) + "," + (c + dc));
                }
            }
            length++;
        }
        return -1;
    }
}