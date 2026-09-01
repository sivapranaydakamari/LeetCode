class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    private void findCombinations(int[] candidates, int target, List<Integer> ds){
        int sum = 0;
        for(int num: ds) sum += num;
        if(sum > target) return;
        for(int num: candidates){
            if(!ds.isEmpty() && num < ds.get(ds.size() - 1)) continue;
            int currSum = sum + num;
            if(currSum == target){
                ds.add(num);
                combinations.add(new ArrayList<>(ds));
                ds.remove(ds.size() - 1);
                continue;
            }else if(currSum < target){
                ds.add(num);
                findCombinations(candidates, target, ds);
                ds.remove(ds.size() - 1);
            }else continue;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations.clear();
        List<Integer> ds = new ArrayList<>();
        findCombinations(candidates, target, ds);
        return combinations;
    }
}