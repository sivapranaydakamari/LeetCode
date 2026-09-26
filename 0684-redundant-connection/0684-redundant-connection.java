class Solution {
    static int[] parent;
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            if(rootA == rootB){
                return new int[]{edge[0], edge[1]};
            }

            parent[rootB] = rootA;
        }
        return new int[]{};
    }
}