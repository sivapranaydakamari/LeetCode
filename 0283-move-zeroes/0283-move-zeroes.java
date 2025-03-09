class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0, j = i+1, n = nums.length;
        while(i<n){
            if(nums[i]==0){
                while(j<n){
                    if(nums[j]!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    }
                    j++;
                }
            }
            i++;
        }
    }
}