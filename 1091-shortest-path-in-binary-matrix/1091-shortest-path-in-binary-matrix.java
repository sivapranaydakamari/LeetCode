class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        if(n == 1) return 1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        while(!queue.isEmpty()){
            int[] currCell = queue.poll();
            int row = currCell[0];
            int col = currCell[1];
            int dist = currCell[2];

            if(row == n - 1 && col == n - 1) return dist;

            for(int i = 0; i < 8; i++){
                int nRow = row + directions[i][0];
                int nCol = col + directions[i][1];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && visited[nRow][nCol] == false){
                    if(grid[nRow][nCol] == 0){
                        queue.offer(new int[]{nRow, nCol, dist + 1});
                        visited[nRow][nCol] = true;
                    }
                }
            }
        }
        return -1;
    }
}