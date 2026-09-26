class Solution {
    static int[] parent;
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int cities = n;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1){
                    int rootI = find(i);
                    int rootJ = find(j);
                    if(rootI != rootJ){
                        parent[rootJ] = rootI;
                        cities--; 
                    }
                }
            }
        }
        return cities;
    }
}