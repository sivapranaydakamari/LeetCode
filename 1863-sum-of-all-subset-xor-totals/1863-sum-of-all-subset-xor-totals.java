class Solution {
    int sum = 0;
    private void subsets(int[] nums,int i, int end, List<Integer> ds){
        if(i == end){
            int subsetXOR = 0;
            for(int j = 0; j < ds.size(); j++){
                subsetXOR ^= ds.get(j);
            }
            sum += subsetXOR;
            return;
        }

        ds.add(nums[i]);
        subsets(nums, i + 1, end, ds);
        ds.remove(ds.size() - 1);

        subsets(nums, i + 1, end, ds);

    }
    public int subsetXORSum(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        subsets(nums,0, nums.length, ds);
        return sum;
    }
}