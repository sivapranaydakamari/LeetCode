class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int remainingHealth = health - grid.get(0).get(0);
        if (remainingHealth < 1)
            return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, remainingHealth });

        int[][] dir = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };

        int[][] best = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            Arrays.fill(best[i], -1);
        }
        best[0][0] = remainingHealth;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int remHealth = current[2];
            
            if (row == grid.size() - 1 && col == grid.get(0).size() - 1 && remHealth >= 1) {
                return true;
            }

            for (int i = 0; i < dir.length; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if (nr >= 0 && nc >= 0 && nr < grid.size() && nc < grid.get(0).size()) {
                    int newHealth = remHealth;
                    if (grid.get(nr).get(nc) == 1)
                        newHealth--;
                    if (newHealth <= 0)
                        continue;

                    if (newHealth <= best[nr][nc])
                        continue;

                    best[nr][nc] = newHealth;

                    queue.offer(new int[] { nr, nc, newHealth });
                }
            }
        }

        return false;
    }
}