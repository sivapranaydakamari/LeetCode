class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while(right - left + 1 > k){
            int a = arr[left], b = arr[right];
            if(Math.abs(x - a) > Math.abs(b - x)) left++;
            else right--;
        }
        List<Integer> closestElements = new ArrayList<>();
        for(int i = left; i <= right; i++){
            closestElements.add(arr[i]);
        }
        return closestElements;
    }
}