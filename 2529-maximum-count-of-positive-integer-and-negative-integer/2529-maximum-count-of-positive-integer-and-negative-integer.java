class Solution {
    public int maximumCount(int[] nums) {
        int neg_c = 0, pos_c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>0){
                pos_c++;
            }
            else if(nums[i] < 0){
                neg_c++;
            }
        }
        return Math.max(pos_c, neg_c);
    }
}