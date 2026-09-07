class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();
    private void combinations(int i, int n, int k, List<Integer> ds){
        if(i == n){
            if(ds.size() == k){
                subsets.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(i);
        combinations(i + 1, n, k, ds);
        ds.remove(ds.size() - 1);

        combinations(i + 1, n, k, ds);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ds = new ArrayList<>();
        combinations(1, n + 1, k, ds);
        return subsets;
    }
}