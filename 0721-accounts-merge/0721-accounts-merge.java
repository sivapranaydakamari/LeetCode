class Solution {
    static int[] parent;
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(map.containsKey(email)){
                    int prev = map.get(email);
                    union(i, prev);
                }else{
                    map.put(email, i);
                }
            }
        }

        HashMap<Integer, List<String>> groups = new HashMap<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int account = entry.getValue();
            String email = entry.getKey();

            int root = find(account);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: groups.entrySet()){
            int root = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> accountsList = new ArrayList<>();
            accountsList.add(accounts.get(root).get(0));
            accountsList.addAll(emails);
            list.add(accountsList);
        }
        return list;
    }
}