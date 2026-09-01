class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    private void subSet(int[] nums, int i, int end, List<Integer> ds){
        if(i == end){
            // System.out.println(Arrays.asList(ds));
            subsets.add(new ArrayList<>(ds));
            return;
        }
        //choicing
        ds.add(nums[i]);
        subSet(nums, i+1, end, ds);
        ds.removeLast();

        //skip and check
        subSet(nums, i+1, end, ds);

    }
    public List<List<Integer>> subsets(int[] nums) {
        // if(nums.length == 1) return new ArrayList(List.of(List.of(nums[0])));
        List<Integer> ds = new ArrayList<>();
        subSet(nums, 0, nums.length, ds);
        return subsets;
    }
}