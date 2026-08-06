class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boatCount = 0;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                boatCount++;
                left++;
                right--;
            }else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }
}